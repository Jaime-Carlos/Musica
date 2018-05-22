package Controller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private static double xOffset = 0;
    private static double yOffset = 0;
    @Override
    public void start(final Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("../Vista/mainWindow.fxml"));
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE)
                {
                    System.out.println("click on escape");
                 Stage sb = (Stage)stage.getScene().getWindow();//use any one object
                 sb.close();
                }
            }
        });
        
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX();
                yOffset = stage.getY();
            }
        });
        
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX());
                stage.setY(event.getScreenY());
            }
        });
        
        
        //scene.getStylesheets().add("/styles/Styles.css");
       // stage.getIcons().add(new Image("/img/mainIcon.png"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Music App!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}