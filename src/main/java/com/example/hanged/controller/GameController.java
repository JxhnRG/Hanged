package com.example.hanged.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {
    @FXML
    private TextField secretWordTextField;
    @FXML
    public void onHandleButtomPlay(ActionEvent event){
        String secretWord = secretWordTextField.getText();
        System.out.println(secretWord);

    }
}
