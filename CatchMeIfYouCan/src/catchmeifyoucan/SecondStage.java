/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.Container;
import java.util.Random;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.RectangleBuilder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SecondStage {
    
    public Random rand = new Random();
    public JFrame frame;
    private BallControl bc;

    public SecondStage() {
        // Constructor
        bc = new BallControl();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("MultipleBallApp");
                // MARK: setup frame behavior
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setUndecorated(true);
                
                frame.add(bc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    public void add() { bc.add(); }
    public void subtract() { bc.subtract(); }
    public void suspend() { bc.suspend(); }
    public void resume() { bc.resume(); }
    
    public JPanel generateRectangle() {
        JPanel rectangle = new JPanel();
        rectangle.setBackground(java.awt.Color.white);
        rectangle.setBounds(rand.nextInt(frame.getWidth()), rand.nextInt(frame.getHeight()), rand.nextInt(300), rand.nextInt(300));
        
        return rectangle;
    }
}