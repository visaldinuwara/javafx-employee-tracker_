package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class logInController {
    public TextField txtUserName;
    public PasswordField passwordField;

    public void btnLogIn(ActionEvent actionEvent) {
        String userName = "";
        String password = "";
        if(txtUserName.getText().equalsIgnoreCase(userName)){
            if(passwordField.getText().equals(password)){
                Stage stage=new Stage();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/dashBoard.fxml"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.show();
            }
        }
    }
}
