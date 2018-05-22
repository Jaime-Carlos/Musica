/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Administradores.AdminReporteAlbum;
import Modelo.ReporteAlbum;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.List;
import javax.swing.text.html.ListView;

/**
 * FXML Controller class
 *
 * @author james
 */
public class ReporteListaAlbumsController implements Initializable {

    @FXML
    JFXComboBox numeroDeReporte;
    @FXML
    JFXListView reporte;

    protected AdminReporteAlbum adminReporteAlbum = new AdminReporteAlbum();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generarComboBox();
    }

    public void generarComboBox() {
        int numeroDeReportes = adminReporteAlbum.numeroDeReportes();
        for (int i = 0; i <= numeroDeReportes; i++) {
            numeroDeReporte.getItems().add(i);
        }
    }
    @FXML
    public void generarVistaDeCorte(ActionEvent event){
        reporte.getItems().clear();
        int valorSelecionado=(Integer) numeroDeReporte.getValue();
        List<ReporteAlbum> reporteAlbums=adminReporteAlbum.listarAlbumesReporte(valorSelecionado);
        for(int i=0;i<reporteAlbums.size();i++){
            String titulo=reporteAlbums.get(i).getTituloDelAlbum().getTitulo();
            String interprete=reporteAlbums.get(i).getNombreDelArtista().getNombre();
            int puestoAnterior=reporteAlbums.get(i).getPosicionAnterior();
            int aparicionesAnteriores=reporteAlbums.get(i).getAparicionesEnReportesAnteriores();
            int puesto=reporteAlbums.get(i).getPosicion();
            reporte.getItems().add("Puesto: "+puesto+
                    " Puesto Anterior: "+puestoAnterior+
                    " Titulo: "+titulo+
                    " Interprete: "+interprete+
                    " AparicionesAnteriores: "+aparicionesAnteriores);
        }
    }
}
