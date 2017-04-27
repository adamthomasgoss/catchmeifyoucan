/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MultipleBall {

    public MultipleBall() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("MultipleBallApp");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new BallControl());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BallControl extends JPanel {

        private BallPanel ballPanel = new BallPanel();
        private JButton Suspend = new JButton("Suspend");
        private JButton Resume = new JButton("Resume");
        private JButton Add = new JButton("+1");
        private JButton Subtract = new JButton("-1");
        private JScrollBar Delay = new JScrollBar();

        public BallControl() {
            // Group buttons in a panel
            JPanel panel = new JPanel();
            panel.add(Suspend);
            panel.add(Resume);
            panel.add(Add);
            panel.add(Subtract);

            // Add ball and buttons to the panel
            ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
            Delay.setOrientation(JScrollBar.HORIZONTAL);
            ballPanel.setDelay(Delay.getMaximum());
            setLayout(new BorderLayout());
            add(Delay, BorderLayout.NORTH);
            add(ballPanel, BorderLayout.CENTER);
            add(panel, BorderLayout.SOUTH);

            // Register listeners
            Suspend.addActionListener(new Listener());
            Resume.addActionListener(new Listener());
            Add.addActionListener(new Listener());
            Subtract.addActionListener(new Listener());
            Delay.addAdjustmentListener(new AdjustmentListener() {

                public void adjustmentValueChanged(AdjustmentEvent e) {
                    ballPanel.setDelay(Delay.getMaximum() - e.getValue());
                }
            });
        }

        class Listener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Suspend) {
                    ballPanel.suspend();
                } else if (e.getSource() == Resume) {
                    ballPanel.resume();
                } else if (e.getSource() == Add) {
                    ballPanel.add();
                } else if (e.getSource() == Subtract) {
                    ballPanel.subtract();
                }
            }
        }
    }

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
    }

    public interface AnimatedShape {

        public void update(Rectangle bounds);

        public void paint(JComponent parent, Graphics2D g2d);
    }

    public abstract class AbstractAnimatedShape implements AnimatedShape {

        private Rectangle bounds;
        private int dx, dy;

        public AbstractAnimatedShape() {
        }

        public void setBounds(Rectangle bounds) {
            this.bounds = bounds;
        }

        public Rectangle getBounds() {
            return bounds;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }

        public void setDx(int dx) {
            this.dx = dx;
        }

        public void setDy(int dy) {
            this.dy = dy;
        }

        @Override
        public void update(Rectangle parentBounds) {
            Rectangle bounds = getBounds();
            int dx = getDx();
            int dy = getDy();
            bounds.x += dx;
            bounds.y += dy;
            if (bounds.x  < parentBounds.x) {
                bounds.x = parentBounds.x;
                setDx(dx *= -1);
            } else if (bounds.x + bounds.width > parentBounds.x + parentBounds.width) {
                bounds.x = parentBounds.x + (parentBounds.width - bounds.width);
                setDx(dx *= -1);
            }
            if (bounds.y < parentBounds.y) {
                bounds.y = parentBounds.y;
                setDy(dy *= -1);
            } else if (bounds.y + bounds.height > parentBounds.y + parentBounds.height) {
                bounds.y = parentBounds.y + (parentBounds.height - bounds.height);
                setDy(dy *= -1);
            }
        }
    }

    public class AnimatedBall extends AbstractAnimatedShape {

        private Color color;

        public AnimatedBall(int x, int y, int radius, Color color) {
            radius = (int)(radius * Math.random() * 5);
            setBounds(new Rectangle(x, y, radius * 2, radius * 2));
            this.color = color;
            setDx(Math.random() > 0.5 ? 2 : -15);
            setDy(Math.random() > 0.5 ? 2 : -15);
        }

        public Color getColor() {
            return color;
        }

        @Override
        public void paint(JComponent parent, Graphics2D g2d) {
            Rectangle bounds = getBounds();
            g2d.setColor(getColor());
            g2d.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

    public class AnimatedRectange extends AbstractAnimatedShape {

        private Color color;

        public AnimatedRectange(int x, int y, int width, int height, Color color) {
            setBounds(new Rectangle(x, y, width, height));
            this.color = color;
            setDx(2);
        }

        // Don't want to adjust the vertical speed
        @Override
        public void setDy(int dy) {
        }

        @Override
        public void paint(JComponent parent, Graphics2D g2d) {
            Rectangle bounds = getBounds();
            g2d.setColor(color);
            g2d.fill(bounds);
        }

    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        new MultipleBall();
    }
}