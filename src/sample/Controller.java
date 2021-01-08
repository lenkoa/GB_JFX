package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> listView;

    private final ObservableList<String> wordList = FXCollections.observableArrayList("Привет", "Часы", "Новый Год!");

    @FXML
    public void initialize(){
        listView.setItems(wordList);
    }

    @FXML
    public void addWordToList(){
        String word = inputField.getText();
        if(word.isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Ошибка ввода сообщения");
            alert.setContentText("Нельзя вводить пустое сообщение");
            alert.showAndWait();
            return;
        } else {
            listView.getItems().add(word);
        }
        inputField.clear();
    }

    @FXML
    public void exit(){
        System.exit(1);
    }

    @FXML
    public void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Lesson 4");
        alert.setContentText("Приложение, созданное в рамках четвертого занятия!");
        alert.showAndWait();
        return;
    }


}
