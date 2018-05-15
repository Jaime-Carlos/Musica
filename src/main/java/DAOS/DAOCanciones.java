package DAOS;

import Modelo.Cancion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAOCanciones {
    protected Properties props = null;
    protected Connection conn = null;
    protected Statement stmt = null;

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
    public List<Cancion> ListaCanciones(){
        List<Cancion> canciones=new ArrayList<>();
        connectDB();
        try{
            stmt = conn.createStatement();
            String sql = "select NombreCancion from cancion";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String tituloCancion = rs.getString("NombreCancion");
                canciones.add(new Cancion(tituloCancion));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e){

        }
        return canciones;
    }
}
