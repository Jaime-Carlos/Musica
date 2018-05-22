/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    private void buscarReportesOnAction(ActionEvent event){
        System.out.println("Accion buscar reportes");
        System.out.println("DATE PICKER INFO INICIO:"+fechaInicio.getValue());
        System.out.println("DATE PICKER INFO CIERRE:"+fechaCierre.getValue());
        //FORMAT: Year/Month/Day
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

