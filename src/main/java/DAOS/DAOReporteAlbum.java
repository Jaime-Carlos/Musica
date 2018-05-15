package DAOS;

import Modelo.Album;
import Modelo.Artista;
import Modelo.ReporteAlbum;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class DAOReporteAlbum {
    protected Connection conn = null;
    protected Statement stmt = null;
    protected Properties props = null;

    public int aparecicionesenreportesAnteriores(String tituloAlbum) {
        int apariciones = -1;
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select Count(NombreAlbum) as AparicionesAnteriores from CorteAlbum where NombreAlbum='" + tituloAlbum + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                apariciones = (rs.getInt("AparicionesAnteriores"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apariciones;
    }

    //Funcion encargada de extraer cuando fue el ultimo corte
    public String FechaFinCorteAnterior() {
        connectDB();
        String fechaFinCorteAnterior = new String();
        try {
            stmt = conn.createStatement();
            String sql = "select FechaFinal from CorteAlbum order by FechaFinal desc limit 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                fechaFinCorteAnterior = (rs.getDate("FechaFinal")).toString();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fechaFinCorteAnterior;
    }

    //Funcion encargada de traer cual es el numero de la ultima lista realizada
    public int ultimoNumerodeCorte() {
        connectDB();
        int utimoNumeroDeCorte = -1;
        try {
            stmt = conn.createStatement();
            String sql = "select NumerodeLista from CorteAlbum order by FechaFinal desc limit 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                utimoNumeroDeCorte = (rs.getInt("NumerodeLista"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utimoNumeroDeCorte;
    }

    //Funcion axuiliar consulta el corte anterior para traer informacion que es necesaria para crear el nuevo corte
    public List<ReporteAlbum> ConsultarCorte(String FechaNuevoCorte) {
        List<ReporteAlbum> reporteAlbums = new ArrayList<>();
        int ultimoReporte = ultimoNumerodeCorte();
        String finFechaCorteAnterior = FechaFinCorteAnterior();
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select NombreAlbum,NombreArtista,Ventas from((select NombreAlbum,sum(Ventas) as Ventas,(strftime('%Y-%m-%d', FechaDeCompra / 1000, 'unixepoch'))as FechaCompra from VentasAlbum where FechaCompra>='" + finFechaCorteAnterior + "' and FechaCompra<'" + FechaNuevoCorte + "' group by (NombreAlbum)))join Completo using (NombreAlbum) group by NombreAlbum order by Ventas desc ";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                String NombreAlbum = rs.getString("NombreAlbum");
                String NombreArtista = rs.getString("NombreArtista");
                int Ventas = rs.getInt("Ventas");
                Album album = new Album(NombreAlbum);
                Artista artista = new Artista(NombreArtista);
                ReporteAlbum reporteAlbum = new ReporteAlbum(ultimoReporte + 1, album, artista, i, 0, 0, finFechaCorteAnterior, FechaNuevoCorte);
                reporteAlbums.add(reporteAlbum);
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporteAlbums;
    }

    //Funcion para conectar a la base de datos
    protected void connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:MusicaDB";
            props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "root");
            props.setProperty("useSSL", "false");
            props.setProperty("useUnicode", "true");
            props.setProperty("useJDBCCompliantTimezoneShift", "true");
            props.setProperty("useLegacyDatetimeCode", "false");
            props.setProperty("serverTimezone", "UTF-8");
            conn = DriverManager.getConnection(url, props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Busca en que posicion quedo el titulo de album ingresado en el reporte anterior
    public int puestoAnterior(String tituloAlbum) {
        int puestoAnterior = 0;
        int ultimoCorte = ultimoNumerodeCorte();
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select * from CorteAlbum where NumerodeLista='" + ultimoCorte + "' and NombreAlbum='" + tituloAlbum + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                puestoAnterior = rs.getInt("Posicion");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return puestoAnterior;
    }

    //Inserta el Reporte(Lista)
    public void generarReporte(List<ReporteAlbum> reporteAlbums) {
        connectDB();
        try {
            stmt = conn.createStatement();
            for (int i = 0; i < reporteAlbums.size(); i++) {
                String sql = "INSERT INTO cortealbum (NumerodeLista,Posicion,NombreAlbum,FechaInico,FechaFinal,VecesQueHaAparecido,PosicionAnterior) "
                        + "VALUES (?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, reporteAlbums.get(i).getNumeroDeReporte());
                preparedStatement.setInt(2, reporteAlbums.get(i).getPosicion());
                preparedStatement.setString(3, reporteAlbums.get(i).getTituloDelAlbum().getTitulo());
                preparedStatement.setDate(4, java.sql.Date.valueOf(reporteAlbums.get(i).getFechaIncioDelReporte()));
                preparedStatement.setDate(5, java.sql.Date.valueOf(reporteAlbums.get(i).getFechaFinalDelReporte()));
                preparedStatement.setInt(6, reporteAlbums.get(i).getAparicionesEnReportesAnteriores());
                preparedStatement.setInt(7, reporteAlbums.get(i).getPosicionAnterior());
                preparedStatement.execute();
                preparedStatement.close();
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Lista un corte especifico
    public List<ReporteAlbum> listarCorte(int numeroDeCorte) {
        List<ReporteAlbum> reportesDeAlbumes = new ArrayList<>();
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select * from CorteAlbum join Completo using (NombreAlbum) where NumerodeLista=" + numeroDeCorte + " group by NombreAlbum order by Posicion asc ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int numerodeListaumerodeLista = rs.getInt("NumerodeLista");
                int posicion = rs.getInt("Posicion");
                String nombreArtista = rs.getString("NombreArtista");
                String tituloAlbum = rs.getString("NombreAlbum");
                String fechaInicio = (rs.getDate("FechaInico")).toString();
                String fechaFinal = (rs.getDate("FechaFinal")).toString();
                int vecesQueHaAparecido = rs.getInt("VecesQueHaAparecido");
                int posicionAnterior = rs.getInt("PosicionAnterior");
                reportesDeAlbumes.add(new ReporteAlbum(numerodeListaumerodeLista, new Album(tituloAlbum), new Artista(nombreArtista), posicion, posicionAnterior, vecesQueHaAparecido, fechaInicio, fechaFinal));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reportesDeAlbumes;
    }
}
