/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


class AnimationPanel extends JPanel {

    private int delay = 30;
    private int delayAirplane = 30;
    private int delayLuggage = 30;
    private int rectangleSize = 100;
    private ArrayList<AnimatedShape> list = new ArrayList<AnimatedShape>();
    private ArrayList<AnimatedAirplane> list_airplanes = new ArrayList<AnimatedAirplane>();
    private ArrayList<AnimatedLuggage> list_luggage = new ArrayList<AnimatedLuggage>();
    private ArrayList<AnimatedRoyalty> list_royalty = new ArrayList<AnimatedRoyalty>();
    private AnimatedRectange rectangle;
    
    private int screenWidth;
    private int screenHeight;

    public AnimationPanel() {
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // this.rectangle = new AnimatedRectange(-25, 200, 50, 25, Color.BLUE);
        timer.start();
        airplaneTimer.start();
        luggageTimer.start();
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
            repaint();
        }
    });
    
    // Create a timer with the initial delay
    // Add airplanes to the timer getBounds()
    protected Timer airplaneTimer = new Timer(delayAirplane, new ActionListener() {
        /**
         * Handle the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (AnimatedAirplane airplane : list_airplanes) {
                airplane.update(getBounds());
            }
            repaint();
        }
    });
    
    // Create a timer with the initial delay
    // Add luggage to the timer getBounds()
    protected Timer luggageTimer = new Timer(delayLuggage, new ActionListener() {
        /**
         * Handle the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (AnimatedLuggage luggage : list_luggage) {
                luggage.update(getBounds());
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
    
    public void clearBalls() {
        list.clear();
    }
    
    public void addAirplane() {
        
        int dir = ThreadLocalRandom.current().nextInt(0, 2);
        int buffer = ThreadLocalRandom.current().nextInt(0, 500);
        int width = ThreadLocalRandom.current().nextInt(40, 400);
        int height = width;
        int speed = width/40; // Min = 1, Max = 10 (because width is between [40, 400])
        AnimatedShape.Direction direction = (dir == 0) ? AnimatedShape.Direction.EAST : AnimatedShape.Direction.WEST;
        String imageFile = (dir == 0) ? "images/plane1.png" : "images/plane1_700wide_left.png";
        int x = ThreadLocalRandom.current().nextInt(-200, 2120);
        int y = ThreadLocalRandom.current().nextInt(0, 1080-height);
        
        AnimatedAirplane airplane = new AnimatedAirplane(x, y, width, height, direction, imageFile, speed, buffer);
        
        list_airplanes.add(airplane);
        
        // Sort airplanes by width ascending
        Collections.sort(list_airplanes, new Comparator<AnimatedAirplane>() {
            @Override public int compare(AnimatedAirplane a1, AnimatedAirplane a2) {
                return a1.width - a2.width; // Ascending
            }
        });
    }
    
    public void removeAirplane() {
        if (list_airplanes.size() > 0) {
            list_airplanes.remove(list_airplanes.size() - 1); // Remove the last airplane
        }
    }
    
    public void clearAirplanes() {
        list_airplanes.clear();
    }
    
    public void addLuggage() {
        
        int dir = ThreadLocalRandom.current().nextInt(0, 2);
        int buffer = ThreadLocalRandom.current().nextInt(0, 500);
        int width = ThreadLocalRandom.current().nextInt(40, 400);
        int height = width;
        int speed = width/40; // Min = 1, Max = 10 (because width is between [40, 400])
        AnimatedShape.Direction direction = (dir == 0) ? AnimatedShape.Direction.NORTH : AnimatedShape.Direction.SOUTH;
        String imageFile = (dir == 0) ? "images/luggage1_700wide.png" : "images/luggagetag1_400wide.png";
        int x = ThreadLocalRandom.current().nextInt(-200, 2120);
        int y = ThreadLocalRandom.current().nextInt(0, 1080-height);
        
        AnimatedLuggage luggage = new AnimatedLuggage(x, y, width, height, direction, imageFile, speed, buffer);
        list_luggage.add(luggage);
        // TODO: sort (if we need to)
    }
    
    public void removeLuggage() {
        if (list_luggage.size() > 0) {
            list_luggage.remove(list_luggage.size() - 1); // Remove the last luggage
        }
    }
    
    public void clearLuggage() {
        list_luggage.clear();
    }
    
    public void hideAllRoyalty() {
        list_royalty.clear();
    }
    
    public void showAllRoyalty() {
        // 2000 pixels x 211 pixels
        Rectangle bounds = getBounds();
        
        // double widthD = (double)((bounds.getWidth() - 200.0) / 2.0);
        double widthD = 1000;
        System.out.println(widthD);
        int width = (int)widthD;
        
        double heightD = (double)(widthD * 211.0 / 2000.0); // between 1 and 10: 1 = light, 10 = black
        int height = (int)heightD;
        
        String promKing = "images/promKing.png";
        String promQueen = "images/promQueen.png";
        String promPrince = "images/promPrince.png";
        String promPrincess = "images/promPrincess.png";
        
        int x = 100;
        int y = 100;
        
        AnimatedRoyalty royalty_king = new AnimatedRoyalty(x, y, width, height, promKing);
        y += (height + 100);
        AnimatedRoyalty royalty_queen = new AnimatedRoyalty(x, y, width, height, promQueen);
        y += (height + 100);
        AnimatedRoyalty royalty_prince = new AnimatedRoyalty(x, y, width, height, promPrince);
        y += (height + 100);
        AnimatedRoyalty royalty_princess = new AnimatedRoyalty(x, y, width, height, promPrincess);
        
        list_royalty.add(royalty_king);
        list_royalty.add(royalty_queen);
        list_royalty.add(royalty_prince);
        list_royalty.add(royalty_princess);
        // TODO: sort (if we need to)
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
        for (AnimatedLuggage luggage  : list_luggage) {
            luggage.paint(this, g2d);
        }
        for (AnimatedRoyalty royalty : list_royalty) {
            royalty.paint(this, g2d);
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
    
    public void setAirplaneSpeed(int speed){
        this.delayAirplane = speed;
        airplaneTimer.setDelay(speed);
    }
    
    public void setLuggageSpeed(int speed){
        this.delayLuggage = speed;
        luggageTimer.setDelay(speed);
    }
}