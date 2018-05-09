package Modelo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestAlbum {
    @Test
    public void crearAlbum(){
        Album album=new Album("AlbumName");
        assertEquals("AlbumName",album.getTitulo());
    }
    @Test
    public void editarTituloAlbum(){
        Album album=new Album("AlbumName");
        album.setTitulo("TituloNuevo");
        assertEquals("TituloNuevo",album.getTitulo());
    }
    @Test
    public void tituloVacio(){
        Album album=new Album("");
        assertEquals("",album.getTitulo());
    }
}
