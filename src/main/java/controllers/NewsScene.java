package controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.News;
import models.User;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class NewsScene implements Initializable {

    private List<News> newsArrayList = new ArrayList<>();
    private boolean sortType = true; //true - Z->A ; false - A->Z

    @FXML
    private Button back;

    @FXML
    private Button sort;

    @FXML
    private ListView news;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        newsArrayList.add(new News(2,"Baiden","What he is doing?"));
        newsArrayList.add(new News(1,"Putin","His life is hard"));
        newsArrayList.add(new News(3,"Robot surgery at Moorfields Eye Hospital saves the sight of 85-year-old grandmother","His life is hard"));
        newsArrayList.add(new News(4,"Boris Johnson wedding is a triumph for Carrie against Cummings","His life is hard"));
        newsArrayList.add(new News(5,"'Pistol game' theory in Belize police chief's death","His life is hard"));
        newsArrayList.add(new News(7,"How BBC plotted to show Martin Bashir's interview with Diana","His life is hard"));
        newsArrayList.add(new News(6,"Bashir and Diana: 'We've made a programme that could finish us all'","His life is hard"));

        //лист новостей
        ObservableList<News> list = FXCollections.observableList(newsArrayList);
        news.setItems(list);


        //возвращение к меню
        back.setOnMouseClicked(mouseEvent -> {
            Parent menuControl = null;
            try {
                menuControl = FXMLLoader.load(getClass().getResource("/menuScene.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene menu = new Scene(menuControl);
            Stage stage =(Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(menu);
            stage.show();
        });

        sort.setOnMouseClicked(mouseEvent -> {
            if(sortType){
                news.setItems( FXCollections.observableList(sortList("Z->A",newsArrayList)));
                sort.setText("Z->A");
                sortType = !sortType;
            }
            else{
                news.setItems( FXCollections.observableList(sortList("A->Z",newsArrayList)));
                sort.setText("A->Z");
                sortType = !sortType;
            }



        });

    }

    public List<News> sortList(String sortType, List<News> newsList){
        switch (sortType){
            case "A->Z":
                Collections.sort(newsList, new Comparator<News>() {
                    @Override
                    public int compare(News t1, News t2) {
                        return (t1.getTitle().toLowerCase().compareTo(t2.getTitle().toLowerCase()));
                    }
                });
                break;
            case "Z->A":
                Collections.sort(newsList, new Comparator<News>() {
                    @Override
                    public int compare(News t1, News t2) {
                        return -(t1.getTitle().toLowerCase().compareTo(t2.getTitle().toLowerCase()));
                    }
                });
                break;

        }

        return newsList;
    }
}
