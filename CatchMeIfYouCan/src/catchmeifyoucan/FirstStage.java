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
    
    // Candidates
    private final String promQueen = "Prom Queen - Rece Legg";
    private final String promKing = "Prom King - Johnny Sanchez";
    private final String promPrince = "Prom Prince - Indigo Schultz";
    private final String promPrincess = "Prom Princess - Elicia Azua";

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
    private final JButton scene1 = new JButton("<<< VISUALS");
    private final JButton scene2 = new JButton("ROYALTY BOARD >>>");
    private final JButton showKing = new JButton("KING");
    private final JButton showQueen = new JButton("QUEEN");
    private final JButton showPrince = new JButton("PRINCE");
    private final JButton showPrincess = new JButton("PRINCESS");
    private final JButton hideKing = new JButton("HIDE");
    private final JButton hideQueen = new JButton("HIDE");
    private final JButton hidePrince = new JButton("HIDE");
    private final JButton hidePrincess = new JButton("HIDE");
    
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
    private int currentScene = 1;

    FirstStage() {
        
        JPanel panela = new JPanel(new BorderLayout());
        panela.setBackground(Color.WHITE);
        panela.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        
        JPanel panelb = new JPanel(new BorderLayout());
        panelb.setBackground(Color.WHITE);
        panelb.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        
        JPanel panelc = new JPanel(new BorderLayout());
        panelc.setBackground(Color.WHITE);
        panelc.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        
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
        
        
        
        
        // PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6
        Color p6color = Color.LIGHT_GRAY;
        JLabel jlabel6 = new JLabel("Scene Controls");
        JPanel panel6 = new JPanel(new BorderLayout());
        JPanel panel6_south = new JPanel();
        jlabel6.setFont(new Font("Verdana",1,20));
        panel6.setBackground(p6color);
        panel6_south.setBackground(p6color);
            panel6_south.add(scene1);
            panel6_south.add(scene2);
        panel6.add(jlabel6, BorderLayout.NORTH);
        // panel6.add(LuggageSpeed, BorderLayout.CENTER);
        panel6.add(panel6_south, BorderLayout.SOUTH);
        panel6.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        // PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6 PANEL6
        
        
        
        
        
        // PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7
        Color p7color = Color.LIGHT_GRAY;
        JLabel jlabel7 = new JLabel("Royalty Displays");
        JPanel panel7 = new JPanel(new BorderLayout());
        JPanel panel7_center = new JPanel();
        JPanel panel7_south = new JPanel();
        jlabel7.setFont(new Font("Verdana",1,20));
        panel7.setBackground(p7color);
        panel7_center.setBackground(p7color);
        panel7_south.setBackground(p7color);
            panel7_center.add(showKing);
            panel7_center.add(showQueen);
            panel7_center.add(showPrince);
            panel7_center.add(showPrincess);
            panel7_south.add(hideKing);
            panel7_south.add(hideQueen);
            panel7_south.add(hidePrince);
            panel7_south.add(hidePrincess);
        panel7.add(jlabel7, BorderLayout.NORTH);
        panel7.add(panel7_center, BorderLayout.CENTER);
        panel7.add(panel7_south, BorderLayout.SOUTH);
        panel7.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
        // PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7 PANEL7
        
        
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
        scene1.addActionListener(new Listener());
        scene2.addActionListener(new Listener());
        showKing.addActionListener(new Listener());
        showQueen.addActionListener(new Listener());
        showPrince.addActionListener(new Listener());
        showPrincess.addActionListener(new Listener());
        hideKing.addActionListener(new Listener());
        hideQueen.addActionListener(new Listener());
        hidePrince.addActionListener(new Listener());
        hidePrincess.addActionListener(new Listener());
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

                panelG.add(panel1);     panelG.add(panel6);
                panelG.add(panel3);     panelG.add(panel7);
                panelG.add(panel4);     panelG.add(panelb);
                panelG.add(panel5);     panelG.add(panelc);
                
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
            } else if (e.getSource() == scene1) {
                // CHANGE TO SCENE 1
                currentScene = 1;
                ss.initScene1();
            } else if (e.getSource() == scene2) {
                // CHANGE TO SCENE 2
                currentScene = 2;
                ss.hideAllRoyalty();
                ss.initScene2();
            } else if (e.getSource() == showKing) {
                ss.showKing();
            } else if (e.getSource() == showQueen) {
                ss.showQueen();
            } else if (e.getSource() == showPrince) {
                ss.showPrince();
            } else if (e.getSource() == showPrincess) {
                ss.showPrincess();
            } else if (e.getSource() == hideKing) {
                ss.hideKing();
            } else if (e.getSource() == hideQueen) {
                ss.hideQueen();
            } else if (e.getSource() == hidePrince) {
                ss.hidePrince();
            } else if (e.getSource() == hidePrincess) {
                ss.hidePrincess();
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
