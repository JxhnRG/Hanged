package com.example.hanged.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    public GameStage() throws IOException {
        //Importamos la Vista de bienvenida
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/hanged/game-view.fxml"));
        //Creamos el Parent
        Parent root = loader.load();
        //Creamos una nueva Escena
        Scene scene = new Scene(root);
        //Insertamos la Escena al Stage
        setScene(scene);
        //Insertamos un titulo al Stage
        setTitle("Hanged Man");
        //Hacemos que el Stage no se pueda redimensionar
        setResizable(false);
        //Agregamos el icono al Stage
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource(
                                "/com/example/hanged/images/favicon.png"))));
        //Hacemos el show al stage
        show();
    }
    public static GameStage getInstance() throws IOException{
        return GameStage.GameStageHolder.INSTANCE = new GameStage();
    }
    private static class GameStageHolder{
        private static GameStage INSTANCE;
    }
}
