/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import java.awt.*;
import javax.swing.*;

import java.awt.Container;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SecondStage {
    
    public Random rand = new Random();
    public JFrame frame;
    public JPanel jp;
    
    public String[] colors = {"0099cc", "ccffcc", "66ccff", "003399"};
    
    SecondStage() {
        // Constructor
        frame = new JFrame("HelloWorldSwing");
        jp = new JPanel();
    }
    
    public void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.add(jp);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true); 
    }
    
    public void updateColor() {
        jp.add(generateRectangle());
        switch(rand.nextInt(5)) {
            case 0:
                frame.getContentPane().setBackground(java.awt.Color.red);
                jp.setBackground(java.awt.Color.red);
                break;
            case 1:
                frame.getContentPane().setBackground(java.awt.Color.orange);
                jp.setBackground(java.awt.Color.orange);
                break;
            case 2:
                frame.getContentPane().setBackground(java.awt.Color.yellow);
                jp.setBackground(java.awt.Color.yellow);
                break;
            case 3:
                frame.getContentPane().setBackground(java.awt.Color.green);
                jp.setBackground(java.awt.Color.green);
                break;
            default:
                frame.getContentPane().setBackground(java.awt.Color.blue);
                jp.setBackground(java.awt.Color.blue);
                break;
        }
    }
    
    public void clearCanvas() {
        jp.removeAll();
        jp.repaint();
        jp.validate();
    }
    
    public JPanel generateRectangle() {
        JPanel rectangle = new JPanel();
        rectangle.setBackground(java.awt.Color.white);
        rectangle.setBounds(rand.nextInt(frame.getWidth()), rand.nextInt(frame.getHeight()), rand.nextInt(300), rand.nextInt(300));
        
        return rectangle;
    }
}
