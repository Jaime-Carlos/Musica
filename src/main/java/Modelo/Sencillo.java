package Modelo;

public class Sencillo {
    private Artista NombreArtista;
    private Cancion TituloCancion;

    public Sencillo(Artista nombreArtista, Cancion tituloCancion) {
        NombreArtista = nombreArtista;
        TituloCancion = tituloCancion;
    }

    public Artista getNombreArtista() {
        return NombreArtista;
    }

    public void setNombreArtista(Artista nombreArtista) {
        NombreArtista = nombreArtista;
    }

    public Cancion getTituloCancion() {
        return TituloCancion;
    }

    public void setTituloCancion(Cancion tituloCancion) {
        TituloCancion = tituloCancion;
    }
}
