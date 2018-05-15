package Run;

import Administradores.AdminReporteAlbum;
import DAOS.DAOAlbum;
import DAOS.DAOReporteAlbum;
import DAOS.DAOVentasAlbum;
import DAOS.DAOVentasSencillo;
import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        //DAOVentasAlbum daoVentasAlbum=new DAOVentasAlbum();
        //daoVentasAlbum.create(new VentasAlbum(50,new Album("This is Noise"),"2018-01-02"));
        DAOReporteAlbum daoReporteAlbum=new DAOReporteAlbum();
        System.out.println(daoReporteAlbum.FechaFinCorteAnterior());
        System.out.println(daoReporteAlbum.ultimoNumerodeCorte());
        AdminReporteAlbum adminReporteAlbum=new AdminReporteAlbum();
        //adminReporteAlbum.generarReporte("2018-02-13");
        DAOAlbum daoAlbum=new DAOAlbum();
        List<Album> albums=daoAlbum.listarAlbumes();
        for(int i=0;i<albums.size();i++){
            System.out.println(albums.get(i).getTitulo());
        }
        List<ReporteAlbum> reporteAlbums=daoReporteAlbum.listarCorte(2);
        for(int i=0;i<reporteAlbums.size();i++){
            System.out.println(reporteAlbums.get(i));
        }
    }
}
