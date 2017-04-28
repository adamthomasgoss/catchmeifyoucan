/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import java.awt.*;
import javax.swing.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstStage extends Stage {

    Button add = new Button("+1");
    Button subtract = new Button("-1");
    Button suspend = new Button("Suspend");
    Button resume = new Button("Resume");
    HBox x = new HBox();
    SecondStage ss;

    FirstStage() {
        x.getChildren().add(add);
        x.getChildren().add(subtract);
        x.getChildren().add(suspend);
        x.getChildren().add(resume);
        this.setScene(new Scene(x, 300, 300));
        this.show();
        ss = new SecondStage();

        // MARK: Listeners
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ss.add();
            }//end action
        });
        
        subtract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ss.subtract();
            }//end action
        });
        
        suspend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ss.suspend();
            }//end action
        });
        
        resume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ss.resume();
            }//end action
        });
    }
}
