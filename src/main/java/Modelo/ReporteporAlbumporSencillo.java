package Modelo;

public class ReporteporAlbumporSencillo {
    private Cancion tituloCancion;
    private int ventas;

    public ReporteporAlbumporSencillo(Cancion tituloCancion, int ventas) {
        this.tituloCancion = tituloCancion;
        this.ventas = ventas;
    }

    public Cancion getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(Cancion tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
