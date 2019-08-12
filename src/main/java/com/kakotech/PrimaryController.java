package com.kakotech;

import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

public class PrimaryController {

    @FXML
    Button dictionaryButton;
    @FXML
    Button addWordButton;
    @FXML
    Button askButton;
    @FXML
    SplitPane dictionaryPane;
    @FXML
    SplitPane addWordsPane;
    @FXML
    SplitPane askPane;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToDictionaryPage(){
        dictionaryPane.setDisable(false);
        dictionaryPane.setVisible(true);
        addWordsPane.setDisable(true);
        addWordsPane.setVisible(false);
        askPane.setDisable(true);
        askPane.setVisible(false);
    }
    @FXML
    private void switchToAddWordsPage(){
        dictionaryPane.setDisable(true);
        dictionaryPane.setVisible(false);
        addWordsPane.setDisable(false);
        addWordsPane.setVisible(true);
        askPane.setDisable(true);
        askPane.setVisible(false);
    }
    @FXML
    private void switchToAskPage(){
        dictionaryPane.setDisable(true);
        dictionaryPane.setVisible(false);
        addWordsPane.setDisable(true);
        addWordsPane.setVisible(false);
        askPane.setDisable(false);
        askPane.setVisible(true);
    }

    public void setTableData(){
        TableColumn columnEng = new TableColumn("English");
        columnEng.setMinWidth(100);
        columnEng.setCellFactory(TextFieldTableCell.forTableColumn());
        //columnEng.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
    }

    private final ObservableList<Line> data =
            FXCollections.observableArrayList(
                    new Line("english1", "hungarian1", "example sentence1"),
                    new Line("english2", "hungarian2", "example sentence2"),
                    new Line("english3", "hungarian3", "example sentence3")
            );

    @Override
    public void initialize(URL url, ResourceBundle rb){
        TableColumn columnEng = new TableColumn("English word");
    }












































}
