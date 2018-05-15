package Administradores;

import DAOS.DAOVentasSencillo;
import Modelo.VentasSencillo;

public class AdminRegistroVentaSencillo {
    DAOVentasSencillo daoVentasSencillo=new DAOVentasSencillo();
    public void registrarVentasSencillo(VentasSencillo ventasSencillo){
        daoVentasSencillo.create(ventasSencillo);
    }
}
