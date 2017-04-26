/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstStage extends Stage {

    Button openOther = new Button("Open other Stage");
    HBox x = new HBox();

    FirstStage() {
        x.getChildren().add(openOther);
        this.setScene(new Scene(x, 300, 300));
        this.show();

        openOther.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                new SecondStage();
            }//end action
        });
    }
}
