/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Administradores.AdminRegistroVentaSencillo;
import Administradores.AdminRegistroVentasAlbum;
import Administradores.AdminReporteSencillo;
import DAOS.DAOAlbum;
import Modelo.Album;
import Modelo.VentasAlbum;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author james
 */
public class RegistroAlbumController implements Initializable {

    @FXML
    private JFXDatePicker fechaDeCompra;

    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private JFXComboBox album;
    AdminRegistroVentasAlbum registroVentasAlbum=new AdminRegistroVentasAlbum();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        final int initialValue = 0;

        SpinnerValueFactory<Integer> valueFactory
                = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5000, initialValue);
        spinner.setValueFactory(valueFactory);
        spinner.setEditable(true);
        DAOAlbum daoAlbum = new DAOAlbum();
        List<Album> albumes = daoAlbum.listarAlbumes();
        for (int i = 0; i < albumes.size(); i++) {
            album.getItems().add(albumes.get(i).getTitulo());
        }
    }

    @FXML
    public void generarVenta() {
        String fecha=fechaDeCompra.getValue().toString();
        int numeroDeVentas=spinner.getValue();
        Album tituloAlbum=new Album(album.getValue().toString());
        registroVentasAlbum.registrarVentasAlbum(new VentasAlbum(numeroDeVentas,tituloAlbum,fecha));
    }
}
