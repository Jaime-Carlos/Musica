package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReporteSencillo {
    private int numeroDeReporte;
    private Cancion tituloCancion;
    private Artista nombreDelArtista;
    private int posicion;
    private int posicionAnterior;
    private int aparicionesEnReportesAnteriores;
    private Date fechaIncioDelReporte;
    private Date fechaFinalDelReporte;
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

    public ReporteSencillo(int numeroDeReporte, Cancion tituloCancion, Artista nombreDelArtista, int posicion, int posicionAnterior, int aparicionesEnReportesAnteriores,String fechaIncioDelReporte, String fechaFinalDelReporte) {
        this.numeroDeReporte = numeroDeReporte;
        this.tituloCancion = tituloCancion;
        this.nombreDelArtista = nombreDelArtista;
        this.posicion = posicion;
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

    public Cancion getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(Cancion tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public Artista getNombreDelArtista() {
        return nombreDelArtista;
    }

    public void setNombreDelArtista(Artista nombreDelArtista) {
        this.nombreDelArtista = nombreDelArtista;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
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
