package Modelo;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestVotoAlbum {
    @Test
    public void crearVotoAlbumComprobarVoto() {
        VotoAlbum votoAlbum = new VotoAlbum(1, new Album("nuevoAlbum"), "2000-01-30");
        assertEquals(1, votoAlbum.getVoto());
    }

    @Test
    public void crearVotoAlbumComprobarAlbum() {
        VotoAlbum votoAlbum = new VotoAlbum(1, new Album("nuevoAlbum"), "2000-01-30");
        assertEquals(new Album("nuevoAlbum").getTitulo(), votoAlbum.getAlbum().getTitulo());
    }
    @Test
    public void crearVotoAlbumComprobarFechaAño(){
        VotoAlbum votoAlbum = new VotoAlbum(1, new Album("nuevoAlbum"), "2010-01-01");
        assertEquals("2010-01-01", votoAlbum.getFechaDeCompra());
    }
    @Test
    public void crearVotoAlbumComprobarFechaMes(){
        VotoAlbum votoAlbum = new VotoAlbum(1, new Album("nuevoAlbum"), "2010-01-01");

        for(int i=1;i<13;i++) {
            String mes="0"+Integer.toString(i);
            if(i<10){
            }else {
                mes=Integer.toString(i);
            }
            votoAlbum.setFechaDeCompra("2010-"+mes+"-01");
            assertEquals("2010-"+mes+"-01", votoAlbum.getFechaDeCompra());
        }
    }
    @Test
    public void crearVotoAlbumComprobarFechaDia(){
        VotoAlbum votoAlbum = new VotoAlbum(1, new Album("nuevoAlbum"), "2010-01-01");
        for(int i=1;i<32;i++){
            String dia="0"+Integer.toString(i);
            if(i<10){
            }else {
                dia=Integer.toString(i);
            }
            votoAlbum.setFechaDeCompra("2010-01-"+dia);
            assertEquals("2010-01-"+dia, votoAlbum.getFechaDeCompra());
        }
    }
}
