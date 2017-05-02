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
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
        // Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource(fileName));
        BufferedImage image = null;
        try {
            image = ImageIO.read(AnimatedAirplane.class.getResourceAsStream(fileName));
        } catch (Exception e) {
            // TODO - handle exception
        }
        image = dye(image, Color.RED);
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
    
    // MARK: Image dyeing 
    
    public void DyeImage() throws Exception
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image = ImageIO.read(new File("DRVpH.png"));
        JPanel panel = new JPanel(new GridLayout(1,0));
        panel.add(new JLabel(new ImageIcon(image)));
        panel.add(new JLabel(new ImageIcon(dye(image, new Color(255,0,0,128)))));
        panel.add(new JLabel(new ImageIcon(dye(image, new Color(255,0,0,32)))));
        panel.add(new JLabel(new ImageIcon(dye(image, new Color(0,128,0,32)))));
        panel.add(new JLabel(new ImageIcon(dye(image, new Color(0,0,255,32)))));
        f.getContentPane().add(panel);
        f.pack();
        f.setVisible(true);
    }


    private static BufferedImage dye(BufferedImage image, Color color)
    {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage dyed = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dyed.createGraphics();
        g.drawImage(image, 0,0, null);
        g.setComposite(AlphaComposite.SrcAtop);
        g.setColor(color);
        g.fillRect(0,0,w,h);
        g.dispose();
        return dyed;
    }
}
