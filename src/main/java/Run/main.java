package Run;

import Administradores.AdminReporteAlbum;
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
        System.out.println(daoReporteAlbum.FechaFinCorteAnterior());
        System.out.println(daoReporteAlbum.ultimoNumerodeCorte());
        System.out.println(daoReporteAlbum.ultimoNumerodeCorte());
        AdminReporteAlbum adminReporteAlbum=new AdminReporteAlbum();
        adminReporteAlbum.generarReporte("2018-02-13");
    }
}
