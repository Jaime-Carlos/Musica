package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VotoSencillo {
    int voto;
    Sencillo album;
    Date fechaDeCompra;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    public VotoSencillo(int voto, Album album, String fechaDeCompra) {
        this.voto = voto;
        this.album = album;
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

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
