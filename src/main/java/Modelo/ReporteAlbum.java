package Modelo;

import sun.util.calendar.LocalGregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReporteAlbum {
    private int numeroDeReporte;
    private Album tituloDelAlbum;
    private Artista nombreDelArtista;
    private int posicionAnterior;
    private int aparicionesEnReportesAnteriores;
    private Date fechaIncioDelReporte;
    private Date fechaFinalDelReporte;
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

    public ReporteAlbum(int numeroDeReporte, Album tituloDelAlbum, Artista nombreDelArtista, int posicionAnterior, int aparicionesEnReportesAnteriores, String fechaIncioDelReporte, String fechaFinalDelReporte) {
        this.numeroDeReporte = numeroDeReporte;
        this.tituloDelAlbum = tituloDelAlbum;
        this.nombreDelArtista = nombreDelArtista;
        this.posicionAnterior = posicionAnterior;
        this.aparicionesEnReportesAnteriores = aparicionesEnReportesAnteriores;
        try {
            this.fechaIncioDelReporte = sdf.parse(fechaIncioDelReporte);
            this.fechaFinalDelReporte=sdf.parse(fechaFinalDelReporte);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public int getNumeroDeReporte() {
        return numeroDeReporte;
    }

    public void setNumeroDeReporte(int numeroDeReporte) {
        this.numeroDeReporte = numeroDeReporte;
    }

    public Album getTituloDelAlbum() {
        return tituloDelAlbum;
    }

    public void setTituloDelAlbum(Album tituloDelAlbum) {
        this.tituloDelAlbum = tituloDelAlbum;
    }

    public Artista getNombreDelArtista() {
        return nombreDelArtista;
    }

    public void setNombreDelArtista(Artista nombreDelArtista) {
        this.nombreDelArtista = nombreDelArtista;
    }

    public int getPosicionAnterior() {
        return posicionAnterior;
    }

    public void setPosicionAnterior(int posicionAnterior) {
        this.posicionAnterior = posicionAnterior;
    }

    public int getAparicionesEnReportesAnteriores() {
        return aparicionesEnReportesAnteriores;
    }

    public void setAparicionesEnReportesAnteriores(int aparicionesEnReportesAnteriores) {
        this.aparicionesEnReportesAnteriores = aparicionesEnReportesAnteriores;
    }

    public String getFechaIncioDelReporte() {
        return sdf.format(fechaIncioDelReporte);
    }

    public void setFechaIncioDelReporte(String fechaIncioDelReporte) {
        try{
            this.fechaIncioDelReporte = sdf.parse(fechaIncioDelReporte);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public String getFechaFinalDelReporte() {
        return sdf.format(fechaFinalDelReporte);
    }

    public void setFechaFinalDelReporte(String fechaFinalDelReporte) {
        try{
            this.fechaFinalDelReporte = sdf.parse(fechaFinalDelReporte);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
