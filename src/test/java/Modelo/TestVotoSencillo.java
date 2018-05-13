package Modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVotoSencillo {
    @Test
    public void crearVotoAlbumComprobarFechaMes(){
        VotoAlbum votoAlbum = new TestVotoSencillo(1, new Album("nuevoAlbum"), "2010-01-01");
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

}
