package com.example.hanged.controller;

import com.example.hanged.view.GameStage;
import com.example.hanged.view.WelcomeStage;

import java.io.IOException;

public class WelcomeController {
    public void onHandleButtomPlay() throws IOException {
        GameStage.getInstance();
        WelcomeStage.deleteInstance();
    }
}
