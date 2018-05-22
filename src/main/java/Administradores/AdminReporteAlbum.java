package Administradores;

import DAOS.DAOAlbum;
import DAOS.DAOReporteAlbum;
import Modelo.Album;
import Modelo.Artista;
import Modelo.ReporteAlbum;

import java.sql.Date;
import java.util.List;

public class AdminReporteAlbum {
    protected DAOReporteAlbum daoReporteAlbum = new DAOReporteAlbum();

    //Genera el corte si la fecha es anterior al ultimo corte devuelve false si la fecha es correcta true
    //El valor de fecha de corte debe ser una fecha en formato yyyy-mm-dd
    public boolean generarReporte(String fechadeCorte) {
        if (Date.valueOf(fechadeCorte).after(Date.valueOf(daoReporteAlbum.FechaFinCorteAnterior()))) {
            List<ReporteAlbum> reporteAlbums = daoReporteAlbum.ConsultarCorte(fechadeCorte);
            System.out.println(daoReporteAlbum.ConsultarCorte(fechadeCorte).size());
            if (daoReporteAlbum.ConsultarCorte(fechadeCorte).size() == 0) {
                reportePorDefecto(reporteAlbums, fechadeCorte);
            }
            for (int i = 0; i < reporteAlbums.size(); i++) {
                int aparicionesAnteriores = daoReporteAlbum.aparecicionesenreportesAnteriores(reporteAlbums.get(i).getTituloDelAlbum().getTitulo());
                int puestoAnterior = daoReporteAlbum.puestoAnterior(reporteAlbums.get(i).getTituloDelAlbum().getTitulo());
                reporteAlbums.get(i).setAparicionesEnReportesAnteriores(aparicionesAnteriores);
                reporteAlbums.get(i).setPosicionAnterior(puestoAnterior);
            }
            daoReporteAlbum.generarReporte(reporteAlbums);
            return true;
        } else {
            return false;
        }
    }

    //Lista un corte especifico
    public List<ReporteAlbum> listarAlbumesReporte(int numeroDeReporte) {
        return daoReporteAlbum.listarCorte(numeroDeReporte);
    }

    //Reporte por defecto en caso de que en ese corte no se haya vendio nada
    public void reportePorDefecto(List<ReporteAlbum> reporteAlbums, String fechaFinal) {
        reporteAlbums.add(new ReporteAlbum(daoReporteAlbum.ultimoNumerodeCorte() + 1, new Album(""), new Artista(""), 0, 0, 0, daoReporteAlbum.FechaFinCorteAnterior(), fechaFinal));
    }

    //Numero de Cortes
    public int numeroDeReportes(){
        int cantidadDeReportes=daoReporteAlbum.ultimoNumerodeCorte();
        return cantidadDeReportes;
    }
    public String fechaDelAnteriorCorte(){
        return daoReporteAlbum.FechaFinCorteAnterior();
    }
}
