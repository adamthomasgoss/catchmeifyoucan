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
    private final JButton addLuggage = new JButton("+1 Luggage");
    private final JButton removeLuggage = new JButton("-1 Luggage");
    private final JButton clearLuggage = new JButton("CLEAR");
    
    private final JButton color1 = new JButton("Color1");
    private final JButton color2 = new JButton("Color2");
    private final JButton color3 = new JButton("Color3");
    private final JButton color4 = new JButton("Color4");
    private final JButton color5 = new JButton("Color5");
    
    public final Color s1_c1 = new Color(162, 250, 163);
    public final Color s1_c2 = new Color(146, 201, 177);
    public final Color s1_c3 = new Color(79, 117, 155);
    public final Color s1_c4 = new Color(93, 81, 121);
    public final Color s1_c5 = new Color(87, 37, 78);
    
    // Color Buttons
    private final JButton changeRectangleColor = new JButton("Change Rectangle Color");
    
    // Other Controls
    private JScrollBar Delay = new JScrollBar();
    private JScrollBar RectangleSize = new JScrollBar();
    private JScrollBar AirplaneSpeed = new JScrollBar();
    private JScrollBar LuggageSpeed = new JScrollBar();
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
        panel1.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
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
        panel2.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        // PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2 PANEL2
        
        
        
        // PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3
        Color p3color = Color.LIGHT_GRAY;
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
        panel3.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        // PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3 PANEL3
        
             
        
        // PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4
        Color p4color = Color.GRAY;
        // AirplaneSpeed.setOrientation(JScrollBar.HORIZONTAL);
        JLabel jlabel4 = new JLabel("Background Color");
        JPanel panel4 = new JPanel(new BorderLayout());
        JPanel panel4_south = new JPanel();
        jlabel4.setFont(new Font("Verdana",1,20));
        panel4.setBackground(p4color);
        panel4_south.setBackground(p4color);
            color1.setBackground(s1_c1); 
            color1.setOpaque(true);
            color2.setBackground(s1_c2); 
            color2.setOpaque(true);
            color3.setBackground(s1_c3); 
            color3.setOpaque(true);
            color4.setBackground(s1_c4); 
            color4.setOpaque(true);
            color5.setBackground(s1_c5); 
            color5.setOpaque(true);
            panel4_south.add(color1);
            panel4_south.add(color2);
            panel4_south.add(color3);
            panel4_south.add(color4);
            panel4_south.add(color5);
        panel4.add(jlabel4, BorderLayout.NORTH);
        //panel4.add(AirplaneSpeed, BorderLayout.CENTER);
        panel4.add(panel4_south, BorderLayout.SOUTH);
        panel4.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        // PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4 PANEL4
        
        
        
        // PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5
        Color p5color = Color.GRAY;
        LuggageSpeed.setOrientation(JScrollBar.HORIZONTAL);
        JLabel jlabel5 = new JLabel("Luggage Controls");
        JPanel panel5 = new JPanel(new BorderLayout());
        JPanel panel5_south = new JPanel();
        jlabel5.setFont(new Font("Verdana",1,20));
        panel5.setBackground(p5color);
        panel5_south.setBackground(p5color);
            panel5_south.add(addLuggage);
            panel5_south.add(removeLuggage);
            panel5_south.add(clearLuggage);
        panel5.add(jlabel5, BorderLayout.NORTH);
        panel5.add(LuggageSpeed, BorderLayout.CENTER);
        panel5.add(panel5_south, BorderLayout.SOUTH);
        panel5.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        // PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5 PANEL5
        
        
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
        addLuggage.addActionListener(new Listener());
        removeLuggage.addActionListener(new Listener());
        clearLuggage.addActionListener(new Listener());
        color1.addActionListener(new Listener());
        color2.addActionListener(new Listener());
        color3.addActionListener(new Listener());
        color4.addActionListener(new Listener());
        color5.addActionListener(new Listener());
        
        // Construct View
        ss = new SecondStage();
        
        // Layout Control Panel
        ss.setDelay(Delay.getMaximum());
        ss.setRectangleSize(RectangleSize.getMaximum());
        ss.setAirplaneSpeed(AirplaneSpeed.getMaximum());
        ss.setLuggageSpeed(LuggageSpeed.getMaximum());
        
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
        
        LuggageSpeed.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                ss.setLuggageSpeed(LuggageSpeed.getMaximum() - e.getValue());
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

                JPanel panelG = new JPanel();
                panelG.setLayout(experimentLayout);

                panelG.add(panel1);
                panelG.add(panel2);
                panelG.add(panel3);
                panelG.add(panel4);
                panelG.add(panel5);
                
                frame.add(panelG);
                
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
            } else if (e.getSource() == addLuggage) {
                ss.addLuggage();
            } else if (e.getSource() == removeLuggage) {
                ss.removeLuggage();
            } else if (e.getSource() == clearLuggage) {
                ss.clearLuggage();
            } else if (e.getSource() == color1) {
                ss.setBackgroundColor(s1_c1);
            } else if (e.getSource() == color2) {
                ss.setBackgroundColor(s1_c2);
            } else if (e.getSource() == color3) {
                ss.setBackgroundColor(s1_c3);
            } else if (e.getSource() == color4) {
                ss.setBackgroundColor(s1_c4);
            } else if (e.getSource() == color5) {
                ss.setBackgroundColor(s1_c5);
            }
        }
    }
}
