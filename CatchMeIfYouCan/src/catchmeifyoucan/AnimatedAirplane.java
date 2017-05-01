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
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComponent;


class AnimatedAirplane extends AbstractAnimatedShape {
    
    private Image img;

    public AnimatedAirplane(int x, int y, int width, int height, Direction planeDirection) {
        setBounds(new Rectangle(x, y, width, height));
        this.img = openImage().getScaledInstance(width, height, 4);
        this.setAnimationDirection(planeDirection);
        switch (planeDirection) {
            case WEST:
                setDx(-2);
                break;
            case EAST:
                setDx(2);
                break;
            default:
                break;
        }
    }

    // Don't want to adjust the vertical speed
    @Override
    public void setDy(int dy) {
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
    
    public Image openImage () {
        Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("plane1.png"));
        return image;
    }
    
    // Even more customization for the airplane movement
    @Override
    public void update(Rectangle parentBounds) {
        Rectangle bounds = getBounds();
        int dx = getDx();
        int dy = getDy();
        int heightRange = parentBounds.height - bounds.height;
        int bufferDistance = 300;
        bounds.x += dx;
        bounds.y += dy;
        // <-----------------------------
        switch (this.getAnimationDirection()) {
            case WEST:
                if ((bounds.x + bounds.width)  < parentBounds.x) {
                    // Reset after plane goes off Screen Left <<<
                    bounds.x = parentBounds.x + parentBounds.width + bufferDistance;
                    bounds.y = ThreadLocalRandom.current().nextInt(0, heightRange + 1);
                }
                break;
            case EAST:
                if (bounds.x > parentBounds.x + parentBounds.width) {
                    // Reset after plane goes off Screen Right >>>
                    bounds.x = parentBounds.x - bufferDistance;
                    bounds.y = ThreadLocalRandom.current().nextInt(0, heightRange + 1);
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported airplane animation direction: " + this.getAnimationDirection());
        }
        /**
        if ((bounds.x + bounds.width)  < parentBounds.x) {
            bounds.x = parentBounds.x + parentBounds.width + bufferDistance;
            bounds.y = ThreadLocalRandom.current().nextInt(0, heightRange + 1);
            // Reset after plane goes off Screen Left <<<
        // ----------------------------->
        } else if (bounds.x > parentBounds.x + parentBounds.width) {
            bounds.x = parentBounds.x + (parentBounds.width);
            // Reset after plane goes off Screen Right >>>
            bounds.x = parentBounds.x - bufferDistance;
            bounds.y = ThreadLocalRandom.current().nextInt(0, heightRange + 1);
        }*/
    }
}
