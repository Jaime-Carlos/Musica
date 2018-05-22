/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Administradores.AdminRegistroVentaSencillo;
import Administradores.AdminReporteSencillo;
import DAOS.DAOAlbum;
import DAOS.DAOCanciones;
import Modelo.Album;
import Modelo.Cancion;
import Modelo.VentasSencillo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author james
 */
public class RegistroCancionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXComboBox sencillo;
    @FXML
    private JFXDatePicker fechaDeCompra;
    @FXML
    Spinner<Integer> spinner;
    AdminRegistroVentaSencillo adminRegistroVentaSencillo=new AdminRegistroVentaSencillo();
    private void registrarCancionOnAction(ActionEvent event){
        System.out.println("Registrando cancion");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         final int initialValue = 0;

        SpinnerValueFactory<Integer> valueFactory
                = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5000, initialValue);
        spinner.setValueFactory(valueFactory);
        spinner.setEditable(true);
        DAOCanciones daoCanciones = new DAOCanciones();
        List<Cancion> canciones = daoCanciones.ListaCanciones();
        for (int i = 0; i < canciones.size(); i++) {
            sencillo.getItems().add(canciones.get(i).getTitulo());
        }
    }
    @FXML
    public void generarVenta() {
        String fecha=fechaDeCompra.getValue().toString();
        int numeroDeVentas=spinner.getValue();
        Cancion tituloCancion=new Cancion(sencillo.getValue().toString());
        adminRegistroVentaSencillo.registrarVentasSencillo(new VentasSencillo(numeroDeVentas,tituloCancion,fecha));
    }
}
