package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button news;

    @FXML
    private Button profile;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        news.setOnMouseClicked(mouseEvent -> {
            Parent menuControl = null;
            try {
                menuControl = FXMLLoader.load(getClass().getResource("/newsScene.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene menu = new Scene(menuControl);
            Stage stage =(Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(menu);
            stage.show();
        });
    }
}
