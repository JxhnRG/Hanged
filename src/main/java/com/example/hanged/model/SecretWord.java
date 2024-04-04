package com.example.hanged.model;

public class SecretWord {
    private String word;
    private String[] arrayWord;
    //Constructor de la clase SecretWord
    public SecretWord(String word){
        this.word=word;
        this.arrayWord=word.split("");
    }
    //Método que retorna la letra de la palabra secreta en la posición indicada
    public char getLetterAtIndex(int index) {
        if (index >= 0 && index < arrayWord.length) {
            return arrayWord[index].charAt(0);
        }
        return ' '; // Si el índice está fuera de rango, retorna un espacio en blanco
    }

    public String getWord() {
        return word;
    }

    public String[] getArrayWord() {
        return arrayWord;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setArrayWord(String[] arrayWord) {
        this.arrayWord = arrayWord;
    }
}
