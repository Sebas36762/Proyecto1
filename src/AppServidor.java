
import Socket.Servidor;
import java.io.*;
import InterfacesFX.LoginScreen.loginInterface;
import InterfacesFX.WatingScreen.waitInterface;
import javafx.application.Application;


public class AppServidor {

    public static void main(String[] args) throws IOException {
        Servidor server = new Servidor();
        Application.launch(loginInterface.class, args);
        //Application.launch(waitInterface.class, args);
        server.linkS();

    }
}