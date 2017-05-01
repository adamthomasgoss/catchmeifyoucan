/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JPanel;
import javax.swing.Timer;


class AnimationPanel extends JPanel {

    private int delay = 30;
    private int rectangleSize = 100;
    private ArrayList<AnimatedShape> list = new ArrayList<AnimatedShape>();
    private ArrayList<AnimatedAirplane> list_airplanes = new ArrayList<AnimatedAirplane>();
    private AnimatedRectange rectangle;
    private AnimatedAirplane airplane;
    private AnimatedAirplane airplane_WEST;
    
    private int screenWidth;
    private int screenHeight;

    public AnimationPanel() {
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // this.rectangle = new AnimatedRectange(-25, 200, 50, 25, Color.BLUE);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    // Create a timer with the initial delay
    // Add everything to the timer getBounds()
    protected Timer timer = new Timer(delay, new ActionListener() {
        /**
         * Handle the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (AnimatedShape ball : list) {
                ball.update(getBounds());
            }
            // rectangle.update(getBounds());
            for (AnimatedAirplane airplane : list_airplanes) {
                airplane.update(getBounds());
            }
            repaint();
        }
    });

    public void add() {
        int radius = 15;
        // Randomised position
        int x = (int) (Math.random() * (getWidth() - (radius * 2))) + radius;
        int y = (int) (Math.random() * (getHeight() - (radius * 2))) + radius;
        Color color = new Color((int) (Math.random() * 256),
                        (int) (Math.random() * 256), (int) (Math.random() * 256));

        AnimatedBall ball = new AnimatedBall(x, y, radius, color);

        list.add(ball);
    }

    public void subtract() {
        if (list.size() > 0) {
            list.remove(list.size() - 1); // Remove the last ball
        }
    }
    
    public void addAirplane() {
        // TODO
        
        int dir = ThreadLocalRandom.current().nextInt(0, 2);
        int buffer = ThreadLocalRandom.current().nextInt(0, 500);
        int width = ThreadLocalRandom.current().nextInt(50, 400);
        int height = width;
        int speed = width/40;
        AnimatedShape.Direction direction = (dir == 0) ? AnimatedShape.Direction.EAST : AnimatedShape.Direction.WEST;
        String imageFile = (dir == 0) ? "images/plane1.png" : "images/plane1_700wide_left.png";
        
        //AnimatedAirplane airplane = new AnimatedAirplane(-200, 200, 200, 200, AnimatedShape.Direction.EAST, "images/plane1.png");
        //AnimatedAirplane airplane_WEST = new AnimatedAirplane(screenWidth, 200, 355, 355, AnimatedShape.Direction.WEST, "images/plane1_700wide_left.png");
        AnimatedAirplane airplane = new AnimatedAirplane(300, 300, width, height, direction, imageFile, speed, buffer);
        
        list_airplanes.add(airplane);
    }
    
    public void removeAirplane() {
        // TODO
    }

    @Override
    // Paint the objects in the scene
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (AnimatedShape ball : list) {
            ball.paint(this, g2d);
        }
        // rectangle.paint(this, g2d);
        for (AnimatedAirplane airplane  : list_airplanes) {
            airplane.paint(this, g2d);
        }
    }

    public void suspend() {
        timer.stop();
    }

    public void resume() {
        timer.start();
    }

    public void setDelay(int delay) {
        this.delay = delay;
        timer.setDelay(delay);
    }
    
    public void changeRectangleColor() {
        // rectangle.changeRectangleColor();
    }
    
    public void setRectangleSize(int size) {
        // rectangle.setSize(size);
    }
}