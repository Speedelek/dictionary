package com.kakotech;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.kakotech.Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class PrimaryController implements Initializable {

    @FXML
    TableView tableDictionary;
    @FXML
    TableView tableAddWord;
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
    TextField inputEnglishWord;
    @FXML
    TextField inputHungarianWord;
    @FXML
    TextField inputExampleSentence;
    @FXML
    Button AddNewWordButton;

    int wordsSum = 0;

    ConnectionClass connectionClass = new ConnectionClass();



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

    /*
    public void setTableData(){
        TableColumn columnEng = new TableColumn("English");
        columnEng.setMinWidth(100);
        columnEng.setCellFactory(TextFieldTableCell.forTableColumn());
        //columnEng.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
    }*/

    private final ObservableList<Line> data =
            FXCollections.observableArrayList(
                    //new Line("absence", "hiány", "A new teacher was appointed during his absence."),
                    //new Line("duke", "herceg", "A duke is a man of very high rank."),
                    //new Line("earl", "gróf", "An earl is a man of high social rank.")
            );

    @FXML
    private void addNewWord(ActionEvent event) throws SQLException { //throws SQLException {
        data.add(new Line(inputEnglishWord.getText(),inputHungarianWord.getText(),inputExampleSentence.getText()));
        System.out.println(data);

        wordsSum++;


        Connection connection = connectionClass.getConnection();

        //String sql = "INSERT INTO DICTIONARY VALUES ('"+inputEnglishWord.getText()+"')";

        //le kell kerdezni elotte hogy hanyadik szo kovetkezuk kulonben nem mukodik
        String sql = "INSERT INTO DICTIONARY (id,english,hungarian,examplesentence) " +
                "VALUES ('"+wordsSum+"','"+inputEnglishWord.getText()+"'," +
                "'"+inputHungarianWord.getText()+"'," +
                "'"+inputExampleSentence.getText()+"')";

        System.out.println(sql);
        System.out.println(inputEnglishWord.getText());
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        inputEnglishWord.clear();
        inputHungarianWord.clear();
        inputExampleSentence.clear();

    }

    public void setTable(){
        TableColumn columnEng = new TableColumn("English word");
        columnEng.setMinWidth(100);
        columnEng.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEng.setCellValueFactory(new PropertyValueFactory<Line, String>("wordEnglish"));

        columnEng.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Line, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Line, String> t){
                        ((Line) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setWordEnglish(t.getNewValue());
                    }
                }
        );

        TableColumn columnHun = new TableColumn("Hungarian word");
        columnHun.setMinWidth(100);
        columnHun.setCellFactory(TextFieldTableCell.forTableColumn());
        columnHun.setCellValueFactory(new PropertyValueFactory<Line, String>("wordHungarian"));

        columnHun.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Line, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Line, String> t){
                        ((Line) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setWordHungarian(t.getNewValue());
                    }
                }
        );

        TableColumn columnExample = new TableColumn("Example sentence");
        columnExample.setMinWidth(300);
        columnExample.setCellFactory(TextFieldTableCell.forTableColumn());
        columnExample.setCellValueFactory(new PropertyValueFactory<Line, String>("exampleSentence"));

        columnExample.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Line, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Line, String> t){
                        ((Line) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setExampleSentence(t.getNewValue());
                    }
                }
        );

        tableAddWord.getColumns().addAll(columnEng, columnHun, columnExample);
        tableAddWord.setItems(data);
        tableDictionary.getColumns().addAll(columnEng, columnHun, columnExample);
        tableDictionary.setItems(data);


    }


    @Override
    public void initialize(URL url, ResourceBundle rb){

        Connection connection = connectionClass.getConnection();

        try {

            ResultSet resultSet = connection.createStatement().executeQuery("select * from dictionary");

            while (resultSet.next()){
                wordsSum = resultSet.getInt("id");
                data.add(new Line(resultSet.getString("english"),
                        resultSet.getString("hungarian"),
                        resultSet.getString("examplesentence")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setTable();
    }









}
