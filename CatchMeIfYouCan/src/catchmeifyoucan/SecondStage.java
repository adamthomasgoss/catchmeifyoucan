/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.Color;
import java.util.Random;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SecondStage {
    
    public Random rand = new Random();
    public JFrame frame;
    private AnimationControl ac;

    public SecondStage() {
        // Constructor
        ac = new AnimationControl();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                frame = new JFrame("MultipleBallApp");
                // MARK: setup frame behavior
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setUndecorated(true);
                
                frame.add(ac);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    public void add() { ac.add(); }
    public void subtract() { ac.subtract(); }
    public void clearBalls() { ac.clearBalls(); }
    public void suspend() { ac.suspend(); }
    public void resume() { ac.resume(); }
    public void setDelay (int delay) { ac.setDelay(delay); }
    public void changeRectangleColor() { ac.changeRectangleColor(); }
    public void setRectangleSize (int size) { ac.setRectangleSize(size); }
    public void setAirplaneSpeed (int speed) { ac.setAirplaneSpeed(speed); }
    public void setLuggageSpeed (int speed) { ac.setLuggageSpeed(speed); }
    public void addAirplane() { ac.addAirplane(); }
    public void removeAirplane() { ac.removeAirplane(); }
    public void clearAirplanes() { ac.clearAirplanes(); }
    public void addLuggage() { ac.addLuggage(); }
    public void removeLuggage() { ac.removeLuggage(); }
    public void clearLuggage() { ac.clearLuggage(); }
    public void initScene1() { ac.initScene1(); }
    public void initScene2() { ac.initScene2(); }
    public void hideAllRoyalty() { ac.hideAllRoyalty(); }
    public void showAllRoyalty() { ac.showAllRoyalty(); }
    public void setBackgroundColor(Color color) { ac.setBackgroundColor(color); }
}