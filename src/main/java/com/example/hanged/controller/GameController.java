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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import com.example.hanged.view.alert.AlertBox;

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
    private Label labelNumberLifes;
    @FXML
    private Button buttonHelp;

    @FXML
    private int helpCount = 0;

    private SecretWord secretWord;
    @FXML
    private ImageView imageViewLifes;
    @FXML
    private ImageView imageViewGame;
    @FXML
    private ImageView imageViewHanged;
    private int countLifes = 1;
    private int countImages=0;

    @FXML
    public void onHandleButtonPlay(ActionEvent event) {
        texFieldInsert();
        buttonPlay.setVisible(false);
        buttonInsertLetter.setVisible(true);
        textFieldInsertLetter.setVisible(true);
        imageViewLifes.setVisible(true);
        labelNumberLifes.setVisible(true);
        buttonHelp.setVisible(true);
        imageViewGame.setVisible(false);
        imageViewHanged.setVisible(true);
        labelNumberLifes.setText("6");
    }

    @FXML
    public void onHandleButtonInsert(ActionEvent event) throws IOException {
        String letter = textFieldInsertLetter.getText().trim();
        if (textFieldInsertLetter.getText().matches("^[a-zA-Z]+$") == false) {
            String title = "Error";
            String header = "Caracter prohibido";
            String content = "Por favor ingrese una letra del alfabeto";
            new AlertBox().showMessage(title, header, content);
            textFieldInsertLetter.clear();
        } else if (textFieldInsertLetter.getText().length()>1) {
            String title = "Error";
            String header = "Caracter muy largo";
            String content = "Por favor ingrese un solo caracter";
            new AlertBox().showMessage(title, header, content);
            textFieldInsertLetter.clear();
        } else{
            if (countLifes <= 6) {
                for (int i = 0; i < secretWord.getWord().length(); i++) {
                    if (String.valueOf(secretWord.getWord().charAt(i)).equalsIgnoreCase(letter)) {
                        wordsTxts[i].setText(letter);
                        alertWinner();
                    }
                    countLifes();
                }
                if (!secretWord.getWord().contains(String.valueOf(textFieldInsertLetter.getText()))){
                    actualizar();
                }
                textFieldInsertLetter.clear();
            } else{
                String title = "Error";
                String header = "Vidas agotadas";
                String content = "No puedes ingresar mas letras";
                new AlertBox().showMessage(title, header, content);
                WelcomeStage.getInstance();
                GameStage.deleteInstance();
                countLifes=1;
                countImages=0;
            }
        }
        countLifes();
    }

    @FXML
    public void onHandleButtonHelp(ActionEvent event)throws IOException {
        if (helpCount < 3) {
            for (int i = 0; i < wordsTxts.length; i++) {
                if (wordsTxts[i].getText().isEmpty()) {
                    char letter = secretWord.getLetterAtIndex(i); // Obtener la letra correspondiente al índice
                    wordsTxts[i].setText(Character.toString(letter)); // Mostrar la letra en el campo de texto
                    break;
                }
            }
            helpCount++;// Incrementar el contador
            alertWinner();
        } else {
            String title = "AYUDAS";
            String header = "Ayudas agotadas";
            String content = "Haz acabado las 3 ayudas disponibles.";
            new AlertBox().showMessage(title, header, content);
        }
    }

    private boolean isWordComplete() {
        for (int i = 0; i < wordsTxts.length; i++) {
            if (wordsTxts[i].getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @FXML
    public void onHandleButtonBackWelcome(ActionEvent event) throws IOException {
        WelcomeStage.getInstance();
        GameStage.deleteInstance();
    }

    public void setSecretWord(SecretWord secretWord) {
        this.secretWord = secretWord;
    }

    public void texFieldInsert() {
        wordsTxts = new TextField[secretWord.getWord().length()];
        for (int i = 0; i < secretWord.getWord().length(); i++) {
            wordsTxts[i] = new TextField();
            wordsTxts[i].setDisable(true);
            wordsTxts[i].setPrefWidth(30);
            gameHBoxLayout.getChildren().add(wordsTxts[i]);
        }

    }

    public void countLifes() {
        if (!secretWord.getWord().contains(String.valueOf(textFieldInsertLetter.getText()))) {
            int maxLifes = 6;
            int numberLifes = maxLifes - countLifes;
            labelNumberLifes.setText(String.valueOf(numberLifes));
        }

    }
    public void actualizar(){
        countLifes++;
        countImages++;
        String PATH = "/com/example/hanged/images/hangedImage/";
        Image image= new Image(String.valueOf(getClass().getResource(PATH + "hanged" + countImages + ".png")));
        imageViewHanged.setImage(image);
    }
    public void alertWinner() throws IOException{
        if (isWordComplete()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String title = "GANASTE";
            String header = "Felicidades";
            String content = "Haz adivinado la palabra secreta.";
            new AlertBox().showMessage(title, header, content);
            WelcomeStage.getInstance();
            GameStage.deleteInstance();
            countLifes=1;
            countImages=0;

        }
    }
}

