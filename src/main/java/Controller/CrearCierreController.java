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
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
    public void generarCierreAlbum(ActionEvent event) {
        boolean flag = alertaAlbum(fechaCorte.getValue().toString());
        if (flag) {
            AdminReporteAlbum adminReporteAlbum = new AdminReporteAlbum();
            adminReporteAlbum.generarReporte(fechaCorte.getValue().toString());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Fecha de Corte");
            alert.setHeaderText("Error en la fecha!");
            alert.setContentText("Selecciona una fecha válida.");

            alert.showAndWait();
        }
    }

    @FXML
    public void genearCierreSencillo(ActionEvent event) {
        boolean flag = alertaSencillo(fechaCorte.getValue().toString());
        if (flag) {
            AdminReporteSencillo adminReporteSencillo = new AdminReporteSencillo();
            adminReporteSencillo.generarReporte(fechaCorte.getValue().toString());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Fecha de Corte");
            alert.setHeaderText("Error en la fecha!");
            alert.setContentText("Selecciona una fecha válida.");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public boolean alertaSencillo(String fecha) {
        AdminReporteSencillo adminReporteSencillo = new AdminReporteSencillo();
        if (Date.valueOf(fecha).before(Date.valueOf(adminReporteSencillo.fechaDelAnteriorCorte()))) {
            return true;
        }
        return false;
    }

    public boolean alertaAlbum(String fecha) {
        AdminReporteAlbum adminReporteAlbum = new AdminReporteAlbum();
        if (Date.valueOf(fecha).before(Date.valueOf(adminReporteAlbum.fechaDelAnteriorCorte()))) {
            return true;
        }
        return false;
    }
}
