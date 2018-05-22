package DAOS;

import Controller.ReporteVentaPorInterpreteController;
import Modelo.Cancion;
import Modelo.ReporteporAlbumporSencillo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAOReporteporAlbumdeSencillo {
    protected Connection conn = null;
    protected Statement stmt = null;
    protected Properties props = null;

    public List<ReporteporAlbumporSencillo> listarReporte(String fechaInicio, String fechaFinal, String nombreAlbum){
        List<ReporteporAlbumporSencillo> reporteInterpretes = new ArrayList<>();
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select Cancion,VentasSencillo,NombreAlbum from (select sum(Ventas)as VentasSencillo, Cancion,(strftime('%Y-%m-%d',FechaCompra/1000,'unixepoch'))as FechadeCompra from VentasSencillo where FechadeCompra>='"+fechaInicio+"' and FechadeCompra<'"+fechaFinal+"' group by Cancion) join Completo where Cancion=NombreCancion and NombreAlbum='"+nombreAlbum+"' group by Cancion";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nombreCancion = rs.getString("Cancion");
                int ventasPorCancion = rs.getInt("VentasSencillo");
                reporteInterpretes.add(new ReporteporAlbumporSencillo(new Cancion(nombreCancion),ventasPorCancion));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporteInterpretes;
    }
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
}
