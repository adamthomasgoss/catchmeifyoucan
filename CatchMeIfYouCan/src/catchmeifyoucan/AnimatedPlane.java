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


class AnimatedPlane extends AbstractAnimatedShape {

    private Color color;

    public AnimatedPlane(int x, int y, int width, int height, Color color) {
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
    
    public void changeRectangleColor() {
        this.color = new Color((int) (Math.random() * 256),
                        (int) (Math.random() * 256), (int) (Math.random() * 256));
    }
    
    public void setSize(int size) {
        Rectangle bounds = getBounds();
        bounds.height = size;
        this.setBounds(bounds);
    }
}
