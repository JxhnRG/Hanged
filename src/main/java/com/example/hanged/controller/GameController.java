package com.example.hanged.controller;

import com.example.hanged.model.SecretWord;
import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class GameController {
    @FXML
    private HBox gameHBoxLayout;
    @FXML
    private TextField wordsTxts[];
    @FXML
    private Button buttonPlay;
    @FXML
    private Button buttonInsertLetter;
    @FXML
    private TextField textFieldInsertLetter;
    @FXML
    private Label labelGame;
    @FXML
    private Label labelLifes;
    @FXML
    private Label labelNumberLifes;
    @FXML
    private Button buttonHelp;

    @FXML
    private int helpCount = 0;

    private SecretWord secretWord;
    @FXML
    private TextField wordTxt;
    @FXML
    public void onHandleButtonPlay(ActionEvent event){
        texFieldInsert();
        buttonPlay.setVisible(false);
        buttonInsertLetter.setVisible(true);
        textFieldInsertLetter.setVisible(true);
        labelGame.setVisible(false);
        labelLifes.setVisible(true);
        labelNumberLifes.setVisible(true);
        buttonHelp.setVisible(true);
   }
   @FXML
   public void onHandleButtonInsert(ActionEvent event) {
       String letter = textFieldInsertLetter.getText().trim();
       if (textFieldInsertLetter.getText().matches("^[a-zA-Z]+$")==false) {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);

           // Establecer el título de la alerta
           alert.setTitle("Error");

           // Establecer el encabezado de la alerta
           alert.setHeaderText("Caracter prohibido");

           // Establecer el contenido de la alerta
           alert.setContentText("Por favor ingrese una letra del alfabeto");

           // Mostrar la alerta y esperar a que el usuario la cierre
           alert.showAndWait();
       }else {
           for (int i = 0; i < secretWord.getWord().length(); i++) {
               if (String.valueOf(secretWord.getWord().charAt(i)).equalsIgnoreCase(letter)) {
                   wordsTxts[i].setText(letter);
               }
           }
       }
       textFieldInsertLetter.clear();
   }
   @FXML
   public void onHandleButtonHelp(ActionEvent event){
       if (helpCount < 3) {
           for (int i = 0; i < wordsTxts.length; i++) {
               if (wordsTxts[i].getText().isEmpty()) {
                   char letter = secretWord.getLetterAtIndex(i); // Obtener la letra correspondiente al índice
                   wordsTxts[i].setText(Character.toString(letter)); // Mostrar la letra en el campo de texto
                   break;
               }
           }
           helpCount++; // Incrementar el contador
       } else {
           // Muestra un mensaje indicando que la función de ayuda ya se ha utilizado tres veces
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           // Establecer el título de la alerta
           alert.setTitle("AYUDAS");

           // Establecer el encabezado de la alerta
           alert.setHeaderText("Ayudas agotadas");

           // Establecer el contenido de la alerta
           alert.setContentText("Haz acabado las 3 ayudas disponibles.");

           // Mostrar la alerta y esperar a que el usuario la cierre
           alert.showAndWait();
       }
   }
   @FXML
   public void onHandleButtonBackWelcome(ActionEvent event) throws IOException {
       WelcomeStage.getInstance();
       GameStage.deleteInstance();
   }
    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
    public void texFieldInsert(){
        wordsTxts = new TextField[secretWord.getWord().length()];
        for (int i=0; i<secretWord.getWord().length(); i++) {
            wordsTxts[i]= new TextField();
            wordsTxts[i].setDisable(true);
            wordsTxts[i].setPrefWidth(30);
            gameHBoxLayout.getChildren().add(wordsTxts[i]);
        }

    }

}
