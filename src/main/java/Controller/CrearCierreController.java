/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Administradores.AdminReporteAlbum;
import Administradores.AdminReporteSencillo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author james
 */
public class CrearCierreController implements Initializable {
    @FXML
    private JFXDatePicker fechaCorte;

    @FXML
    private JFXButton cierreAlbum;

    @FXML
    private JFXButton cierreSencillo;
    /**
     * Initializes the controller class.
     */

    @FXML
    public void generarCierreAlbum(ActionEvent event){
        AdminReporteAlbum adminReporteAlbum=new AdminReporteAlbum();
        adminReporteAlbum.generarReporte(fechaCorte.getValue().toString());
    }

    @FXML
    public void genearCierreSencillo(ActionEvent event){
        AdminReporteSencillo adminReporteSencillo=new AdminReporteSencillo();
        adminReporteSencillo.generarReporte(fechaCorte.getValue().toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
