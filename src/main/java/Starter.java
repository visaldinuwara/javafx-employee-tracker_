import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Starter extends Application {
    public static void main(String[] args){
        launch();
    }
    public void start(Stage stage){
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/logInPage.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
