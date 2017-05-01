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

    public AnimatedAirplane(int x, int y, int width, int height, Direction planeDirection, String fileName,
        int speed, int buffer) {
        setBounds(new Rectangle(x, y, width, height));
        this.img = openImage(fileName).getScaledInstance(width, height, 4);
        this.setAnimationDirection(planeDirection);
        switch (planeDirection) {
            case WEST:
                setDx(speed * (-1));
                break;
            case EAST:
                setDx(speed);
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
    
    public Image openImage (String fileName) {
        Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource(fileName));
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
    }
}
