module pau.pau_zad3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pau.pau_zad3 to javafx.fxml;
    exports pau.pau_zad3;
}