package DAOS;

import Modelo.Cancion;
import Modelo.ReporteInterprete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAOReporteInterprete {
    protected Connection conn = null;
    protected Statement stmt = null;
    protected Properties props = null;

    public List<ReporteInterprete> listarReporte(String fechaInicio,String fechaFinal,String nombreArtista){
        List<ReporteInterprete> reporteInterpretes = new ArrayList<>();
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select NombreAlbum,VentasPorAlbum,NombreArtista from (select sum(Ventas)as VentasPorAlbum,NombreAlbum,(strftime('%Y-%m-%d',FechaDeCompra/1000,'unixepoch'))as FechaCompra from VentasAlbum where FechaCompra>='"+fechaInicio+"' and FechaCompra<'"+fechaFinal+"' group by NombreAlbum) join Completo using (NombreAlbum) where NombreArtista='"+nombreArtista+"' group by NombreAlbum";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nombreAlbum = rs.getString("NombreAlbum");
                int ventasPorAlbum = rs.getInt("VentasPorAlbum");
                reporteInterpretes.add(new ReporteInterprete(new Cancion(nombreAlbum),ventasPorAlbum));
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
