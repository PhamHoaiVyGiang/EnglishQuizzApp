module com.phvg.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.phvg.mavenproject3 to javafx.fxml;
    exports com.phvg.mavenproject3;
}
