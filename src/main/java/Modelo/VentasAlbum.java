package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentasAlbum {
    private int numeroDeCompras;
    private Album tituloDelAlbum;
    private Date fechaDeCompra;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    public VentasAlbum(int numeroDeCompras, Album tituloDelAlbum, String fechaDeCompra) {
        this.numeroDeCompras = numeroDeCompras;
        this.tituloDelAlbum = tituloDelAlbum;
        try {
            this.fechaDeCompra = sdf.parse(fechaDeCompra);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public String getFechaDeCompra() {
        return sdf.format(fechaDeCompra);
    }

    public void setFechaDeCompra(String fechaDeCompra) {
        try {
            this.fechaDeCompra = sdf.parse(fechaDeCompra);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public Album getTituloDelAlbum() {
        return tituloDelAlbum;
    }

    public void setTituloDelAlbum(Album tituloDelAlbum) {
        this.tituloDelAlbum = tituloDelAlbum;
    }

    public int getNumeroDeCompras() {
        return numeroDeCompras;
    }

    public void setNumeroDeCompras(int numeroDeCompras) {
        this.numeroDeCompras = numeroDeCompras;
    }
}
