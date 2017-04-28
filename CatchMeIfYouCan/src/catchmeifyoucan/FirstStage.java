/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FirstStage extends JPanel {

    // Motion Buttons
    private final JButton add = new JButton("+1");
    private final JButton subtract = new JButton("-1");
    private final JButton suspend = new JButton("Suspend");
    private final JButton resume = new JButton("Resume");
    
    // Color Buttons
    private final JButton changeRectangleColor = new JButton("Change Rectangle Color");
    
    // Other Controls
    private JScrollBar Delay = new JScrollBar();    
    private SecondStage ss;
    private JFrame frame;

    FirstStage() {
        
        JPanel panel1 = new JPanel();
        panel1.add(suspend);
        panel1.add(resume);
        panel1.add(add);
        panel1.add(subtract);
        
        JPanel panel2 = new JPanel();
        panel2.add(changeRectangleColor);
        
        // Register listeners
        suspend.addActionListener(new Listener());
        resume.addActionListener(new Listener());
        add.addActionListener(new Listener());
        subtract.addActionListener(new Listener());
        changeRectangleColor.addActionListener(new Listener());
        
        // Construct View
        ss = new SecondStage();
        
        // Layout Control Panel
        Delay.setOrientation(JScrollBar.HORIZONTAL);
        ss.setDelay(Delay.getMaximum());
        
        Delay.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                ss.setDelay(Delay.getMaximum() - e.getValue());
            }
        });
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                frame = new JFrame("Controller");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Add elements to the frame
                setLayout(new BorderLayout());
                frame.add(Delay, BorderLayout.NORTH);
                frame.add(panel1, BorderLayout.CENTER);
                frame.add(panel2, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    class Listener implements ActionListener {

        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getSource() == suspend) {
                ss.suspend();
            } else if (e.getSource() == resume) {
                ss.resume();
            } else if (e.getSource() == add) {
                ss.add();
            } else if (e.getSource() == subtract) {
                ss.subtract();
            } else if (e.getSource() == changeRectangleColor) {
                ss.changeRectangleColor();
            }
        }
    }
}
