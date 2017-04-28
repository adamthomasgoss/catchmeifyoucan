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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


class BallPanel extends JPanel {

    private int delay = 30;
    private ArrayList<AnimatedShape> list = new ArrayList<AnimatedShape>();
    private AnimatedRectange rectangle;

    public BallPanel() {
        this.rectangle = new AnimatedRectange(-25, 200, 50, 25, Color.RED);

        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    // Create a timer with the initial delay
    protected Timer timer = new Timer(delay, new ActionListener() {
        /**
         * Handle the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (AnimatedShape ball : list) {
                ball.update(getBounds());
            }
            rectangle.update(getBounds());
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (AnimatedShape ball : list) {
            ball.paint(this, g2d);
        }
        rectangle.paint(this, g2d);
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
        rectangle.changeRectangleColor();
    }
}