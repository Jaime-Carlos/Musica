package Run;

import Administradores.AdminReporteAlbum;
import Administradores.AdminReporteSencillo;
import DAOS.*;
import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
//        DAOVentasAlbum daoVentasAlbum=new DAOVentasAlbum();
//        daoVentasAlbum.create(new VentasAlbum(50,new Album("This is Noise"),"2018-01-02"));
//        DAOReporteAlbum daoReporteAlbum = new DAOReporteAlbum();
//        System.out.println(daoReporteAlbum.FechaFinCorteAnterior());
//        System.out.println(daoReporteAlbum.ultimoNumerodeCorte());
//        AdminReporteAlbum adminReporteAlbum = new AdminReporteAlbum();
//        System.out.println(adminReporteAlbum.generarReporte("2018-03-13"));
//        DAOAlbum daoAlbum = new DAOAlbum();
//        List<Album> albums = daoAlbum.listarAlbumes();
//        for (int i = 0; i < albums.size(); i++) {
//            System.out.println(albums.get(i).getTitulo());
//        }
//        List<ReporteAlbum> reporteAlbums = adminReporteAlbum.listarAlbumesReporte(0);
//        for (int i = 0; i < reporteAlbums.size(); i++) {
//            System.out.println(reporteAlbums.get(i));
//        }
        DAOCanciones daoCanciones=new DAOCanciones();
        List<Cancion> cancions=daoCanciones.ListaCanciones();
//        for(int i=0;i<cancions.size();i++){
//            System.out.println(cancions.get(i).getTitulo());
//        }
        AdminReporteSencillo adminReporteSencillo=new AdminReporteSencillo();
        //adminReporteSencillo.generarReporte("2018-02-13");
        List<ReporteSencillo> reporteSencillos=adminReporteSencillo.listarSencillosReporte(1);
        for(int i=0;i<reporteSencillos.size();i++){
           System.out.println(reporteSencillos.get(i).getTituloCancion().getTitulo());
        }
        DAOVentasSencillo daoVentasSencillo=new DAOVentasSencillo();
        //daoVentasSencillo.create(new VentasSencillo(10,new Cancion("Yerbatero"),"2018-01-10"));

    }
}
