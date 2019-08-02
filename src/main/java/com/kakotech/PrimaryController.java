package com.kakotech;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;

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

}
