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

    Button openOther = new Button("Random Color");
    HBox x = new HBox();
    SecondStage ss;

    FirstStage() {
        x.getChildren().add(openOther);
        this.setScene(new Scene(x, 300, 300));
        this.show();
        ss = new SecondStage();
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ss.createAndShowGUI();
            }
        });
        

        
            
        openOther.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ss.updateColor();
            }//end action
        });
    }
}
