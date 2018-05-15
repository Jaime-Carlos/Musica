package Administradores;

import DAOS.DAOReporteAlbum;
import DAOS.DAOReporteSencillo;
import Modelo.Artista;
import Modelo.Cancion;
import Modelo.ReporteAlbum;
import Modelo.ReporteSencillo;

import java.sql.Date;
import java.util.List;

public class AdminReporteSencillo {
    DAOReporteSencillo daoReporteSencillo=new DAOReporteSencillo();
    //Genera el corte si la fecha es anterior al ultimo corte devuelve false si la fecha es correcta true
    //El valor de fecha de corte debe ser una fecha en formato yyyy-mm-dd
    public boolean generarReporte(String fechadeCorte) {
        if (Date.valueOf(fechadeCorte).after(Date.valueOf(daoReporteSencillo.fechaFinCorteAnterior()))) {
            List<ReporteSencillo> reporteSencillos = daoReporteSencillo.ConsultarCorte(fechadeCorte);
            System.out.println(daoReporteSencillo.ConsultarCorte(fechadeCorte).size());
            if (daoReporteSencillo.ConsultarCorte(fechadeCorte).size() == 0) {
                reportePorDefecto(reporteSencillos, fechadeCorte);
            }
            for (int i = 0; i < reporteSencillos.size(); i++) {
                int aparicionesAnteriores = daoReporteSencillo.aparecicionesenreportesAnteriores(reporteSencillos.get(i).getTituloCancion().getTitulo());
                int puestoAnterior = daoReporteSencillo.puestoAnterior(reporteSencillos.get(i).getTituloCancion().getTitulo());
                reporteSencillos.get(i).setAparicionesEnReportesAnteriores(aparicionesAnteriores);
                reporteSencillos.get(i).setPosicionAnterior(puestoAnterior);
            }
            daoReporteSencillo.generarReporte(reporteSencillos);
            return true;
        } else {
            return false;
        }
    }

    //Lista un corte especifico
    public List<ReporteSencillo> listarAlbumesReporte(int numeroDeReporte) {
        return daoReporteSencillo.listarCorte(numeroDeReporte);
    }

    //Reporte por defecto en caso de que en ese corte no se haya vendio nada
    public void reportePorDefecto(List<ReporteSencillo> reporteSencillos, String fechaFinal) {
        reporteSencillos.add(new ReporteSencillo(daoReporteSencillo.ultimoNumerodeCorte() + 1, new Cancion(""), new Artista(""), 0, 0, 0, daoReporteSencillo.fechaFinCorteAnterior(), fechaFinal));
    }
}
