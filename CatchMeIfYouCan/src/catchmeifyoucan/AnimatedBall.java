/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;


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