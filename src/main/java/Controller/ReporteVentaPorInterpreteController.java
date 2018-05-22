/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOS.DAOArtista;
import DAOS.DAOReporteInterprete;
import Modelo.Artista;
import Modelo.ReporteInterprete;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author james
 */
public class ReporteVentaPorInterpreteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label label;
    
    @FXML
    private JFXButton buscarReportes;
    
    @FXML
    private JFXDatePicker fechaInicio;
    @FXML
    private JFXDatePicker fechaCierre;
    @FXML
    private JFXComboBox nombreArtista;
    @FXML
    private JFXListView vistaReporte;
    protected DAOReporteInterprete daoReporteInterprete=new DAOReporteInterprete();

    @FXML
    private void buscarReportesOnAction(ActionEvent event){
        System.out.println("Accion buscar reportes");
        System.out.println("DATE PICKER INFO INICIO:"+fechaInicio.getValue());
        System.out.println("DATE PICKER INFO CIERRE:"+fechaCierre.getValue());
        //FORMAT: Year/Month/Day
        vistaReporte.getItems().clear();
        List<ReporteInterprete> reporte=daoReporteInterprete.listarReporte(fechaInicio.getValue().toString(),fechaCierre.getValue().toString(),nombreArtista.getValue().toString());
        for(int i=0;i<reporte.size();i++){
            String tituloAlbum=reporte.get(i).getTituloCancion().getTitulo();
            int totalidadVentas=reporte.get(i).getVentas();
            vistaReporte.getItems().add("Titulo del Album: "+tituloAlbum+
                    " Ventas: "+totalidadVentas);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DAOArtista daoArtista=new DAOArtista();
        List<Artista> artistas=daoArtista.listarArtistas();
        for (int i=0;i<artistas.size();i++){
            nombreArtista.getItems().add(artistas.get(i).getNombre());
        }
    }    
    
}
