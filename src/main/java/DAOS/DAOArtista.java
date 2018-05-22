package DAOS;

import Modelo.Artista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAOArtista {
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

    public List<Artista> listarArtistas() {
        List<Artista> listaDeAlbumes = new ArrayList<>();
        connectDB();
        try {
            stmt = conn.createStatement();
            String sql = "select Nombre from Artista";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nombreArtista = rs.getString("Nombre");
                listaDeAlbumes.add(new Artista(nombreArtista));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDeAlbumes;
    }
}
