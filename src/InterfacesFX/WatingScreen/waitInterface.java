package InterfacesFX.WatingScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author Josue, Gustavo, Sebastián
 */
public class waitInterface extends Application {

    /**
     * @param args Se inicia la pantalla
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Método principal para configurar todas las escenas realizadas en JFX, es decir, crea las interfaces
     * @param primaryStage Para la configuración de la escena de la aplicación pudiendo crear otras escenas si es necesario.
     * @throws IOException Para el manejo de las excepciones del código por si se presenta algún error
     */
    public void start(Stage primaryStage)throws IOException {

        Parent fxml = FXMLLoader.load(getClass().getResource("waitInterface.fxml"));
        Scene sceneWait = new Scene(fxml);
        primaryStage.setScene(sceneWait);
        primaryStage.show();
    }
}
