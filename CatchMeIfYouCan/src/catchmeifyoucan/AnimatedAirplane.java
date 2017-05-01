/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


class AnimatedAirplane extends AbstractAnimatedShape {

    private Color color;
    private Image img;

    public AnimatedAirplane(int x, int y, int width, int height, Color color) {
        setBounds(new Rectangle(x, y, width, height));
        this.color = color;
        this.img = openImage();
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
        g2d.drawImage(this.img, 100, 100, null);
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
    
        public Image openImage () {
        BufferedImage img = null;
        try {
            return img = ImageIO.read(new File("plane1.png"));
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Couldn't open image");
        }
        Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("plane1.png"));
        return image;
    }
}
