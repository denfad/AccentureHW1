package controllers;

import dao.UsersDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Label help;

    @FXML
    private Button auth;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        auth.setOnMouseClicked(mouseEvent -> {

            if(auth() != null){
                help.setText("Successful auth!");
                try {
                    Parent menuControl = FXMLLoader.load(getClass().getResource("/menuScene.fxml"));
                    Scene menu = new Scene(menuControl);
                    Stage stage =(Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
                    stage.setScene(menu);
                    stage.show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
            else{
                help.setText("Try another login or password");
            }
        });
    }

    private User auth(){
        for(User u: UsersDAO.getInstance().getUsers()){
            if(u.getLogin().equals(login.getText()) & u.getPassword().equals(password.getText())){
                return u;
            }
        }
        return null;
    }
}
