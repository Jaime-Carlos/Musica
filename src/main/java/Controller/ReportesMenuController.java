/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author james
 */
public class ReportesMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void sencillosOnAction(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../Vista/reporteListaSencillos.fxml"));
        Scene home_scene_page = new Scene(home_page_parent);
        Stage app_stage = new Stage();
        Stage main_app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene_page);
        app_stage.getIcons().add(new Image("img/mainIcon.png"));
        app_stage.initOwner(main_app);
        app_stage.setResizable(false);
        app_stage.setTitle("Reporte Ventas - Sencillos");
        app_stage.initModality(Modality.APPLICATION_MODAL);
        app_stage.showAndWait();
    }
    
    @FXML
    private void albumsOnAction(ActionEvent event)throws IOException{
        System.out.println("Lista de albumes");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../Vista/reporteListaAlbums.fxml"));
        Scene home_scene_page = new Scene(home_page_parent);
        Stage app_stage = new Stage();
        Stage main_app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene_page);
        app_stage.getIcons().add(new Image("img/mainIcon.png"));
        app_stage.initOwner(main_app);
        app_stage.setResizable(false);
        app_stage.setTitle("Reporte de Venta - Albums vendidos por Interprete");
        app_stage.initModality(Modality.APPLICATION_MODAL);
        app_stage.showAndWait();
        
    }
    
    @FXML
    private void interpreteOnAction(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../Vista/reporteVentaPorInterprete.fxml"));
        Scene home_scene_page = new Scene(home_page_parent);
        Stage app_stage = new Stage();
        Stage main_app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene_page);
        app_stage.getIcons().add(new Image("img/mainIcon.png"));
        app_stage.initOwner(main_app);
        app_stage.setResizable(false);
        app_stage.setTitle("Reporte de Venta - Albums vendidos por Interprete");
        app_stage.initModality(Modality.APPLICATION_MODAL);
        app_stage.showAndWait();
        System.out.println("Interprete On Action");
    }
    
    @FXML
    private void ventasEnAlbumOnAction(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../Vista/ReporteVentaPorAlbum.fxml"));
        Scene home_scene_page = new Scene(home_page_parent);
        Stage app_stage = new Stage();
        Stage main_app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene_page);
        app_stage.getIcons().add(new Image("img/mainIcon.png"));
        app_stage.initOwner(main_app);
        app_stage.setResizable(false);
        app_stage.setTitle("Reporte de Venta - Canciones en Albúm");
        app_stage.initModality(Modality.APPLICATION_MODAL);
        app_stage.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
