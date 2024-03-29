module com.example.hanged {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hanged to javafx.fxml;
    opens com.example.hanged.controller to javafx.fxml;
    exports com.example.hanged;
}