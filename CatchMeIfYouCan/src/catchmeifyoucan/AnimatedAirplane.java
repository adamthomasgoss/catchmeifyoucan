/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JComponent;


class AnimatedAirplane extends AbstractAnimatedShape {

    private Image img;

    public AnimatedAirplane(int x, int y, int width, int height) {
        setBounds(new Rectangle(x, y, width, height));
        this.img = openImage().getScaledInstance(width, height, 4);
        setDx(2);
    }

    // Don't want to adjust the vertical speed
    @Override
    public void setDy(int dy) {
    }

    @Override
    public void paint(JComponent parent, Graphics2D g2d) {
        Rectangle bounds = getBounds();
        g2d.fill(bounds);
        g2d.drawImage(this.img, bounds.x, bounds.y, null);
    }
    
    public void setSize(int size) {
        Rectangle bounds = getBounds();
        bounds.height = size;
        this.setBounds(bounds);
    }
    
    public Image openImage () {
        Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("plane1.png"));
        return image;
    }
}
