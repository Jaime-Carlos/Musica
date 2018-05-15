package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentasSencillo {
    private int numeroDeCompras;
    private Cancion CancionSencillo;
    private Date fechaDeCompra;
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    public VentasSencillo(int numeroDeCompras, Cancion CancionSencillo, String fechaDeCompra) {
        this.numeroDeCompras = numeroDeCompras;
        this.CancionSencillo = CancionSencillo;
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

    public int getNumeroDeCompras() {
        return numeroDeCompras;
    }

    public void setNumeroDeCompras(int numeroDeCompras) {
        this.numeroDeCompras = numeroDeCompras;
    }

    public Cancion getCancionSencillo() {
        return CancionSencillo;
    }

    public void setCancionSencillo(Cancion CancionSencillo) {
        this.CancionSencillo = CancionSencillo;
    }
}
