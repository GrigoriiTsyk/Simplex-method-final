package grigorii.tsykarev;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.util.Locale;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("launching Application!");

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        View view = new View();

        Scene scene = new Scene(view.createElements());
        stage.setScene(scene);
        stage.setTitle("Simplex method");
        stage.setWidth(600);
        stage.setHeight(500);
        stage.show();
    }
}