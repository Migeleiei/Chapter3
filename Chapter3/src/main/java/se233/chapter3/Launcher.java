package se233.chapter3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage)throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("main-view.fxml"));
    }
}
