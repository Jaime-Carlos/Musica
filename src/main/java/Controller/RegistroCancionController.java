/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
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
    Spinner<Integer> spinner;
    
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
    }    
    
}
