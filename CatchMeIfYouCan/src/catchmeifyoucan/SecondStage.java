/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.util.Random;
import java.awt.EventQueue;
import javax.swing.JFrame;
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
}