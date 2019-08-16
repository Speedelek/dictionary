module com.kakotech {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.kakotech to javafx.fxml;
    exports com.kakotech;
}