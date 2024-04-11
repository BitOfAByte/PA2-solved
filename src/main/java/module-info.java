module dk.sdu.pa2 {
    requires javafx.controls;
    requires javafx.fxml;


    exports dk.sdu.pa2.task3;
    opens dk.sdu.pa2.task3 to javafx.fxml;
}