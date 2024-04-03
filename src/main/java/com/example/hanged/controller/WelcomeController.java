package com.example.hanged.controller;

import com.example.hanged.model.SecretWord;
import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;
    @FXML
    public void onHandleButtonPlay(ActionEvent event) throws IOException {
        SecretWord secretWord = new SecretWord(secretWordTextField.getText().trim());
        GameStage.getInstance().getGameController().setSecretWord(secretWord);
        WelcomeStage.deleteInstance();
        System.out.println(secretWord.getWord());
    }
}