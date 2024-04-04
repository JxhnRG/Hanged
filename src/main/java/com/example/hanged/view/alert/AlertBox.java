package com.example.hanged.view.alert;

import javafx.scene.control.Alert;
public class AlertBox implements IAlerbox{
    @Override
    //Se creo un metodo showMessage que recibe tres parametros de tipo String, Para las alertas de la aplicación.
    public void showMessage(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
