module com.kakotech {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.kakotech to javafx.fxml;
    exports com.kakotech;
}