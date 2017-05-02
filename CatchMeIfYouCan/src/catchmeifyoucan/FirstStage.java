/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FirstStage extends JPanel {

    // Motion Buttons
    private final JButton add = new JButton("+1");
    private final JButton subtract = new JButton("-1");
    private final JButton clearBalls = new JButton("CLEAR");
    private final JButton suspend = new JButton("Suspend");
    private final JButton resume = new JButton("Resume");
    private final JButton addPlane = new JButton("+1 Plane");
    private final JButton removePlane = new JButton("-1 Plane");
    private final JButton clearAirplanes = new JButton("CLEAR");
    
    // Color Buttons
    private final JButton changeRectangleColor = new JButton("Change Rectangle Color");
    
    // Other Controls
    private JScrollBar Delay = new JScrollBar();
    private JScrollBar AirplaneSpeed = new JScrollBar();
    private JScrollBar RectangleSize = new JScrollBar();
    private SecondStage ss;
    private JFrame frame;

    FirstStage() {
        
        // PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1
        Color p1color = Color.GRAY;
        Delay.setOrientation(JScrollBar.HORIZONTAL);
        JLabel jlabel1 = new JLabel("Ball Controls");
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel1_south = new JPanel();
        jlabel1.setFont(new Font("Verdana",1,20));
        panel1.setBackground(p1color);
        panel1_south.setBackground(p1color);
            panel1_south.add(suspend);
            panel1_south.add(resume);
            panel1_south.add(add);
            panel1_south.add(subtract);
            panel1_south.add(clearBalls);
        panel1.add(jlabel1, BorderLayout.NORTH);
        panel1.add(Delay, BorderLayout.CENTER);
        panel1.add(panel1_south, BorderLayout.SOUTH);
        // PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1 PANEL1
        
        
        
        // PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2
        Color p2color = Color.LIGHT_GRAY;
        RectangleSize.setOrientation(JScrollBar.HORIZONTAL);
        JLabel jlabel2 = new JLabel("Rectangle Controls");
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel2_south = new JPanel();
        jlabel2.setFont(new Font("Verdana",1,20));
        panel2.setBackground(p2color);
        panel2_south.setBackground(p2color);
            panel2_south.add(changeRectangleColor);
        panel2.add(jlabel2, BorderLayout.NORTH);
        panel2.add(RectangleSize, BorderLayout.CENTER);
        panel2.add(panel2_south, BorderLayout.SOUTH);
        // PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2
        
        
        
        // PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3
        Color p3color = Color.GREEN;
        AirplaneSpeed.setOrientation(JScrollBar.HORIZONTAL);
        JLabel jlabel3 = new JLabel("Airplane Controls");
        JPanel panel3 = new JPanel(new BorderLayout());
        JPanel panel3_south = new JPanel();
        jlabel3.setFont(new Font("Verdana",1,20));
        panel3.setBackground(p3color);
        panel3_south.setBackground(p3color);
            panel3_south.add(addPlane);
            panel3_south.add(removePlane);
            panel3_south.add(clearAirplanes);
        panel3.add(jlabel3, BorderLayout.NORTH);
        panel3.add(AirplaneSpeed, BorderLayout.CENTER);
        panel3.add(panel3_south, BorderLayout.SOUTH);
        // PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3
        
        
        // Register listeners
        suspend.addActionListener(new Listener());
        resume.addActionListener(new Listener());
        add.addActionListener(new Listener());
        subtract.addActionListener(new Listener());
        clearBalls.addActionListener(new Listener());
        changeRectangleColor.addActionListener(new Listener());
        addPlane.addActionListener(new Listener());
        removePlane.addActionListener(new Listener());
        clearAirplanes.addActionListener(new Listener());
        
        // Construct View
        ss = new SecondStage();
        
        // Layout Control Panel
        ss.setDelay(Delay.getMaximum());
        ss.setRectangleSize(RectangleSize.getMaximum());
        ss.setAirplaneSpeed(AirplaneSpeed.getMaximum());
        
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
        
        AirplaneSpeed.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                ss.setAirplaneSpeed(AirplaneSpeed.getMaximum() - e.getValue());
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
            } else if (e.getSource() == clearBalls) {
                ss.clearBalls();
            } else if (e.getSource() == changeRectangleColor) {
                ss.changeRectangleColor();
            } else if (e.getSource() == addPlane) {
                ss.addAirplane();
            } else if (e.getSource() == removePlane) {
                ss.removeAirplane();
            } else if (e.getSource() == clearAirplanes) {
                ss.clearAirplanes();
            }
        }
    }
}
