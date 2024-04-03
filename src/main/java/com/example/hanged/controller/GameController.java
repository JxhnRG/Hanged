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

    private SecretWord secretWord;
    @FXML
    private Button buttonInsertLetter;
    public void ocultarButton(){

    }
    public void onHandleButtonPlay(ActionEvent event){
        wordsTxts= new TextField[secretWord.getWord().length()];
        for (int i=0; i<secretWord.getWord().length(); i++) {
            TextField wordTxt = new TextField();
            wordTxt.setPrefWidth(30);
            gameHBoxLayout.getChildren().add(wordTxt);
            //keyPressed(wordTxt, i);
            //wordsTxts[i] = wordTxt;
            buttonPlay.setVisible(false);
            wordTxt.setDisable(true);
            }
   }
   @FXML
   public void onHandleButtonInsert(ActionEvent event){
       System.out.println(secretWord.getWord());
       }
   public void onHandleButtonHelp(ActionEvent event){
       System.out.println("Help");
   }
   @FXML
   public void onHandleButtonBackWelcome(ActionEvent event) throws IOException {
       WelcomeStage.getInstance();
       GameStage.deleteInstance();
   }
    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}
