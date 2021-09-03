package InterfacesFX.LoginScreen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author Josue
 */
public class loginInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent fxml = FXMLLoader.load(getClass().getResource("loginInterface.fxml"));
        Scene sceneLogin = new Scene(fxml);
        primaryStage.setScene(sceneLogin);
        primaryStage.show();

    }

}