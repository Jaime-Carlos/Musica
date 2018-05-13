package Modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVentasAlbum {
    @Test
    public void crearVotoAlbumComprobarVoto() {
        VentasAlbum ventasAlbum = new VentasAlbum(1, new Album("nuevoAlbum"), "2000-01-30");
        assertEquals(1, ventasAlbum.getNumeroDeCompras());
    }

    @Test
    public void crearVotoAlbumComprobarAlbum() {
        VentasAlbum ventasAlbum = new VentasAlbum(1, new Album("nuevoAlbum"), "2000-01-30");
        assertEquals(new Album("nuevoAlbum").getTitulo(), ventasAlbum.getTituloDelAlbum().getTitulo());
    }
    @Test
    public void crearVotoAlbumComprobarFechaAño(){
        VentasAlbum ventasAlbum = new VentasAlbum(1, new Album("nuevoAlbum"), "2010-01-01");
        assertEquals("2010-01-01", ventasAlbum.getFechaDeCompra());
    }
    @Test
    public void crearVotoAlbumComprobarFechaMes(){
        VentasAlbum ventasAlbum = new VentasAlbum(1, new Album("nuevoAlbum"), "2010-01-01");

        for(int i=1;i<13;i++) {
            String mes="0"+Integer.toString(i);
            if(i<10){
            }else {
                mes=Integer.toString(i);
            }
            ventasAlbum.setFechaDeCompra("2010-"+mes+"-01");
            assertEquals("2010-"+mes+"-01", ventasAlbum.getFechaDeCompra());
        }
    }
    @Test
    public void crearVotoAlbumComprobarFechaDia(){
        VentasAlbum ventasAlbum = new VentasAlbum(1, new Album("nuevoAlbum"), "2010-01-01");
        for(int i=1;i<32;i++){
            String dia="0"+Integer.toString(i);
            if(i<10){
            }else {
                dia=Integer.toString(i);
            }
            ventasAlbum.setFechaDeCompra("2010-01-"+dia);
            assertEquals("2010-01-"+dia, ventasAlbum.getFechaDeCompra());
        }
    }
}
