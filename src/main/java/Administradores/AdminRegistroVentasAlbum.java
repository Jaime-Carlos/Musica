package Administradores;

import DAOS.DAOVentasAlbum;
import Modelo.VentasAlbum;

public class AdminRegistroVentasAlbum {
    DAOVentasAlbum daoVentasAlbum=new DAOVentasAlbum();
    public void registrarVentasAlbum(VentasAlbum ventasAlbum){
        daoVentasAlbum.create(ventasAlbum);
    }
}
