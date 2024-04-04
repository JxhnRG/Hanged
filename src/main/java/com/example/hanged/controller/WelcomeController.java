package com.example.hanged.controller;

import com.example.hanged.model.SecretWord;
import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;
import com.example.hanged.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;
    @FXML
    public void onHandleButtonPlay(ActionEvent event) throws IOException {
        //Condicionales para verificar que la palabra sea valida
        if(secretWordTextField.getText().length()<=0) {
            String tittle = "Error";
            String header = "Palabra demasiado corta";
            String content = "Por favor ingrese una palabra valida";
            new AlertBox().showMessage(tittle, header, content);
        } else if (secretWordTextField.getText().matches("^[a-zA-Z]+$")==false) {
            String tittle = "Error";
            String header = "Palabra con caracteres prohibidos";
            String content = "Por favor ingrese una palabra valida";
            new AlertBox().showMessage(tittle, header, content);
        }
        //Si la palabra es valida se crea un objeto de tipo SecretWord y se setea en el GameController
        else {
            SecretWord secretWord = new SecretWord(secretWordTextField.getText().trim());
            GameStage.getInstance().getGameController().setSecretWord(secretWord);
            WelcomeStage.deleteInstance();
        }
    }
}