/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author agoss
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        new FirstStage();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
