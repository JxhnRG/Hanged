package com.example.hanged.controller;

import com.example.hanged.model.SecretWord;
import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;
    public void onHandleButtomPlay() throws IOException {
        GameStage.getInstance();
        WelcomeStage.deleteInstance();
        SecretWord secretWord = new SecretWord(secretWordTextField.getText().trim());
        System.out.println(secretWord.getWord());
    }
}