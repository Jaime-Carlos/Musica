package Run;

import DAOS.DAOVentasAlbum;
import DAOS.DAOVentasSencillo;
import Modelo.*;

public class main {
    public static void main(String[] args) {
        DAOVentasAlbum daoVentasAlbum=new DAOVentasAlbum();
        daoVentasAlbum.create(new VentasAlbum(50,new Album("This is Noise"),"2018-01-02"));
    }
}
