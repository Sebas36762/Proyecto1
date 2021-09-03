package InterfacesFX.LoginScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class loginInterfaceController {

    @FXML
    private Button loginB;
    @FXML
    private TextField loginTF;

    public void handle(ActionEvent event) {

        String nameUser;
        nameUser = loginTF.getText();
        System.out.println(nameUser);
    }
}
