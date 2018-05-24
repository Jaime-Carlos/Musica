/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Administradores.AdminReporteAlbum;
import DAOS.DAOAlbum;
import DAOS.DAOReporteporAlbumdeSencillo;
import Modelo.Album;
import Modelo.ReporteporAlbumporSencillo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

public class ReporteVentaPorAlbumController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXButton buscarReportes;
    @FXML
    private JFXDatePicker fechaInicio;
    @FXML
    private JFXDatePicker fechaCierre;
    @FXML
    private JFXListView vistaSencillos;
    @FXML
    private JFXComboBox album;

    @FXML
    private void buscarReportesOnAction(ActionEvent event) {
        System.out.println("Accion buscar reportes");
        System.out.println("DATE PICKER INFO INICIO:" + fechaInicio.getValue());
        System.out.println("DATE PICKER INFO CIERRE:" + fechaCierre.getValue());
        boolean flag;
        flag=alerta(fechaInicio.getValue().toString(),fechaCierre.getValue().toString());
        if(flag){
            //FORMAT: Year/Month/Day
        vistaSencillos.getItems().clear();
        DAOReporteporAlbumdeSencillo daoReporteporAlbumdeSencillo=new DAOReporteporAlbumdeSencillo();
        List<ReporteporAlbumporSencillo> reporte= daoReporteporAlbumdeSencillo.listarReporte(fechaInicio.getValue().toString(),fechaCierre.getValue().toString(),album.getValue().toString());
        for(int i=0;i<reporte.size();i++){
            String tituloCancion=reporte.get(i).getTituloCancion().getTitulo();
            int totalidadVentas=reporte.get(i).getVentas();
            vistaSencillos.getItems().add("Titulo del Album: "+tituloCancion+
                    " Ventas: "+totalidadVentas);

        }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Fecha");
            alert.setHeaderText("Error en las fechas!");
            alert.setContentText("Selecciona unas fechas válidas.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DAOAlbum daoAlbum=new DAOAlbum();
        List<Album> albumes=daoAlbum.listarAlbumes();
        for (int i=0;i<albumes.size();i++){
            album.getItems().add(albumes.get(i).getTitulo());
        }
    }
    
    public boolean alerta(String fechaInicio, String fechaFinal) {
        
        if (Date.valueOf(fechaInicio).before(Date.valueOf(fechaFinal))) {
            return true;
        }
        return false;
    }
    
    

}

