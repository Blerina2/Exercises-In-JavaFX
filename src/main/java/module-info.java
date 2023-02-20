module com.example.ushtrimeprovim2023 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;


    exports com.example.ushtrimeprovim2023.Java01;
    opens com.example.ushtrimeprovim2023.Java01 to javafx.fxml;

    opens com.example.ushtrimeprovim2023  to javafx.fxml;
    exports com.example.ushtrimeprovim2023.DetyratNeVideo.video1;
    opens com.example.ushtrimeprovim2023.DetyratNeVideo.video1 to javafx.fxml;
    exports com.example.ushtrimeprovim2023.DetyratNeVideo.video2;
    opens com.example.ushtrimeprovim2023.DetyratNeVideo.video2 to javafx.fxml;
    exports com.example.ushtrimeprovim2023.DetyratNeVideo.video3dhe4;
    opens com.example.ushtrimeprovim2023.DetyratNeVideo.video3dhe4 to javafx.fxml;
    exports com.example.ushtrimeprovim2023.DetyratNeVideo.video5;
    opens com.example.ushtrimeprovim2023.DetyratNeVideo.video5 to javafx.fxml;
}