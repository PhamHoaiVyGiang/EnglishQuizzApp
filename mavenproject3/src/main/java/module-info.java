module com.phvg.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.phvg.mavenproject3 to javafx.fxml;
    exports com.phvg.mavenproject3;
    exports com.phvg.pojo;
}
