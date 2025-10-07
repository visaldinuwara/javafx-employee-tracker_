package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class logInController {
    public TextField txtUserName;
    public PasswordField passwordField;
    public Button btnLogIn;

    public void btnLogIn(ActionEvent actionEvent) {
        String userName = "1";
        String password = "1";
        try {
            if(txtUserName.getText().equalsIgnoreCase(userName)) {
                if (passwordField.getText().equals(password)) {
                    Stage stage = new Stage();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/dashBoard.fxml"))));
                    stage.show();
                }
            }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

    }
}
