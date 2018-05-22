package Run;

import Administradores.AdminReporteAlbum;
import Administradores.AdminReporteSencillo;
import DAOS.*;
import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        DAOArtista daoArtista=new DAOArtista();
        List<Artista> artistas=daoArtista.listarArtistas();
        for (int i=0;i<artistas.size();i++){
            System.out.println(artistas.get(i).getNombre());
        }

    }
}
