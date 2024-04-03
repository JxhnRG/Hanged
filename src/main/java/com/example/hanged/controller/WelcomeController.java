package com.example.hanged.controller;

import com.example.hanged.model.SecretWord;
import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;
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
        if(secretWordTextField.getText().length()<=0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            // Establecer el título de la alerta
            alert.setTitle("Error");

            // Establecer el encabezado de la alerta
            alert.setHeaderText("Palabra demasiado corta");

            // Establecer el contenido de la alerta
            alert.setContentText("Por favor ingrese una palabra valida");

            // Mostrar la alerta y esperar a que el usuario la cierre
            alert.showAndWait();
        } else if (secretWordTextField.getText().matches("^[a-zA-Z]+$")==false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            // Establecer el título de la alerta
            alert.setTitle("Error");

            // Establecer el encabezado de la alerta
            alert.setHeaderText("Palabra con caracteres prohibidos");

            // Establecer el contenido de la alerta
            alert.setContentText("Por favor ingrese una palabra valida");

            // Mostrar la alerta y esperar a que el usuario la cierre
            alert.showAndWait();
        } else {
            SecretWord secretWord = new SecretWord(secretWordTextField.getText().trim());
            GameStage.getInstance().getGameController().setSecretWord(secretWord);
            WelcomeStage.deleteInstance();
            System.out.println(secretWord.getWord());
        }
    }
}