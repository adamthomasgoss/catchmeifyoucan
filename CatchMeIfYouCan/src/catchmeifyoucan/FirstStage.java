/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
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
    private final JButton addPlane = new JButton("+1 Plane");
    private final JButton removePlane = new JButton("-1 Plane");
    
    // Color Buttons
    private final JButton changeRectangleColor = new JButton("Change Rectangle Color");
    
    // Other Controls
    private JScrollBar Delay = new JScrollBar();
    private JScrollBar RectangleSize = new JScrollBar();
    private SecondStage ss;
    private JFrame frame;

    FirstStage() {
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GRAY);
        panel1.add(Delay, BorderLayout.NORTH);
        panel1.add(suspend);
        panel1.add(resume);
        panel1.add(add);
        panel1.add(subtract);
        
        JPanel panel2 = new JPanel();
        setLayout(new BorderLayout());
        panel2.add(RectangleSize, BorderLayout.NORTH);
        panel2.add(changeRectangleColor, BorderLayout.SOUTH);
        
        JPanel panel3 = new JPanel();
        setLayout(new BorderLayout());
        panel3.add(addPlane);
        panel3.add(removePlane);
        
        // Register listeners
        suspend.addActionListener(new Listener());
        resume.addActionListener(new Listener());
        add.addActionListener(new Listener());
        subtract.addActionListener(new Listener());
        changeRectangleColor.addActionListener(new Listener());
        addPlane.addActionListener(new Listener());
        removePlane.addActionListener(new Listener());
        
        // Construct View
        ss = new SecondStage();
        
        // Layout Control Panel
        Delay.setOrientation(JScrollBar.HORIZONTAL);
        ss.setDelay(Delay.getMaximum());
        RectangleSize.setOrientation(JScrollBar.HORIZONTAL);
        ss.setRectangleSize(RectangleSize.getMaximum());
        
        Delay.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                ss.setDelay(Delay.getMaximum() - e.getValue());
            }
        });
        
        RectangleSize.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                ss.setRectangleSize(RectangleSize.getMaximum() - e.getValue());
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
                //setLayout(new BorderLayout());
                // frame.add(panel1, BorderLayout.NORTH);
                // frame.add(panel2, BorderLayout.CENTER);
                // frame.add(panel3, BorderLayout.SOUTH);
                
                // Grid Layout
                GridLayout experimentLayout = new GridLayout(0,2);

                JPanel panel4 = new JPanel();
                panel4.setLayout(experimentLayout);

                panel4.add(panel1);
                panel4.add(panel2);
                panel4.add(panel3);
                panel4.add(new JButton("Long-Named Button 4"));
                panel4.add(new JButton("5"));
                
                frame.add(panel4);
                
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
            } else if (e.getSource() == addPlane) {
                ss.addAirplane();
            } else if (e.getSource() == removePlane) {
                ss.removeAirplane();
            }
        }
    }
}
