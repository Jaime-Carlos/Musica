package Administradores;

import DAOS.DAOReporteAlbum;
import Modelo.ReporteAlbum;

import java.util.List;

public class AdminReporteAlbum {
    public void generarReporte(String fechadeCorte){
        DAOReporteAlbum daoReporteAlbum=new DAOReporteAlbum();
        List<ReporteAlbum> reporteAlbums=daoReporteAlbum.ConsultarCorte(fechadeCorte);
        for(int i=0; i<reporteAlbums.size();i++){
            int aparicionesAnteriores=daoReporteAlbum.aparecicionesenreportesAnteriores(reporteAlbums.get(i).getTituloDelAlbum().getTitulo());
            int puestoAnterior=daoReporteAlbum.puestoAnterior(reporteAlbums.get(i).getTituloDelAlbum().getTitulo());
            reporteAlbums.get(i).setAparicionesEnReportesAnteriores(aparicionesAnteriores);
            reporteAlbums.get(i).setPosicionAnterior(puestoAnterior);
        }
        daoReporteAlbum.generarReporte(reporteAlbums);
    }
}
