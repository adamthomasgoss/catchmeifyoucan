/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class AnimatedRoyalty extends AbstractAnimatedShape {
    
    private Image img;
    public int width;

    public AnimatedRoyalty(int x, int y, int width, int height, String fileName) {
        this.width = width;
        setBounds(new Rectangle(x, y, width, height));
        this.img = openImage(fileName, width).getScaledInstance(width, height, 4);
    }

    // Don't want to adjust the vertical speed
    @Override
    public void setDy(int dy) {
    }
    // Don't want to adjust the horizontal speed
    @Override
    public void setDx(int dx) {
    }

    @Override
    public void paint(JComponent parent, Graphics2D g2d) {
        Rectangle bounds = getBounds();
        g2d.drawImage(this.img, bounds.x, bounds.y, null);
    }
    
    public void setSize(int size) {
        Rectangle bounds = getBounds();
        bounds.height = size;
        this.setBounds(bounds);
    }
    
    public Image openImage (String fileName, int width) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(AnimatedRoyalty.class.getResourceAsStream(fileName));
        } catch (Exception e) {
            // TODO - handle exception
        }
        return image;
    }
    
    // Even more customization for the airplane movement
    @Override
    public void update(Rectangle parentBounds) {
        Rectangle bounds = getBounds();
        int heightRange = parentBounds.height - bounds.height;
        
        bounds.x = 300;
        bounds.y = 300;
    }
}
