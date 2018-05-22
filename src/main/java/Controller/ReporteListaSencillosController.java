/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Administradores.AdminReporteSencillo;
import Modelo.ReporteSencillo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author james
 */
public class ReporteListaSencillosController implements Initializable {
    AdminReporteSencillo adminReporteSencillo=new AdminReporteSencillo();
    @FXML
    JFXListView reporte;
    @FXML
    JFXComboBox numeroDeReporte;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generarComboBox();
    }
    public void generarComboBox() {
        int numeroDeReportes = adminReporteSencillo.numeroDeReportes();
        for (int i = 0; i <= numeroDeReportes; i++) {
            numeroDeReporte.getItems().add(i);
        }
    }
    @FXML
    public void generarVistaDeCorte(ActionEvent event){
        reporte.getItems().clear();
        int valorSelecionado=(Integer) numeroDeReporte.getValue();
        List<ReporteSencillo> reporteAlbums=adminReporteSencillo.listarSencillosReporte(valorSelecionado);
        for(int i=0;i<reporteAlbums.size();i++){
            String titulo=reporteAlbums.get(i).getTituloCancion().getTitulo();
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
