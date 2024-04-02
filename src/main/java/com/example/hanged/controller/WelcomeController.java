package com.example.hanged.controller;

import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private TextField secretWordTextField;

    public String getSecretWordTextField() {
        return secretWordTextField.getText();
    }
    public void onHandleButtomPlay() throws IOException {
        GameStage.getInstance();
        WelcomeStage.deleteInstance();
        System.out.println(getSecretWordTextField());
    }
}
