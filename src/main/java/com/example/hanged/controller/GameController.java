package com.example.hanged.controller;

import com.example.hanged.model.SecretWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class GameController {
    @FXML
    private HBox gameHBoxLayout;
    @FXML
    private TextField wordsTxts[];
    @FXML
    private Button buttonPlay;

    private SecretWord secretWord;
    @FXML
    public void onHandleButtonPlay(ActionEvent event){
        wordsTxts= new TextField[secretWord.getWord().length()];
        for (int i=0; i<secretWord.getWord().length(); i++){
            TextField wordTxt = new TextField();
            wordTxt.setPrefWidth(30);
            gameHBoxLayout.getChildren().add(wordTxt);
            //keyPressed(wordTxt, i);
            //wordsTxts[i] = wordTxt;
            buttonPlay.setVisible(false);

        }

   }
    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }
}
