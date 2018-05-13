package DAOS;

import Modelo.VentasSencillo;
import java.sql.*;
import java.util.*;
public class DAOVentasSencillo {
    public boolean create(VentasSencillo ventaDeSencillo) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:MusicaDB";
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "root");
            props.setProperty("useSSL", "false");
            props.setProperty("useUnicode","true");
            props.setProperty("useJDBCCompliantTimezoneShift","true");
            props.setProperty("useLegacyDatetimeCode","false");
            props.setProperty("serverTimezone","UTF-8");
            Connection conn = DriverManager.getConnection(url, props);
            stmt = conn.createStatement();
            String sql = "INSERT INTO ventassencillo (ventas,Cancion,fechacompra) "
                    + "VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ventaDeSencillo.getNumeroDeCompras());
            preparedStatement.setString(2, ventaDeSencillo.getCancionSencillo().getTituloCancion().getTitulo());
            preparedStatement.setString(3, ventaDeSencillo.getFechaDeCompra());
            preparedStatement.execute();
            preparedStatement.close();
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
