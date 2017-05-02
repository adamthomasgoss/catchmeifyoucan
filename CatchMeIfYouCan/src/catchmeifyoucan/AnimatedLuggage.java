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


class AnimatedLuggage extends AbstractAnimatedShape {
    
    private Image img;
    public int width;

    public AnimatedLuggage(int x, int y, int width, int height, Direction luggageDirection, String fileName,
        int speed, int buffer) {
        this.width = width;
        setBounds(new Rectangle(x, y, width, height));
        this.img = openImage(fileName, width).getScaledInstance(width, height, 4);
        this.setAnimationDirection(luggageDirection);
        switch (luggageDirection) {
            case NORTH:
                setDy(speed * (-1));
                break;
            case SOUTH:
                setDy(speed);
                break;
            default:
                break;
        }
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
        // Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource(fileName));
        BufferedImage image = null;
        try {
            image = ImageIO.read(AnimatedLuggage.class.getResourceAsStream(fileName));
        } catch (Exception e) {
            // TODO - handle exception
        }
        double colorDecimal = (double)(255.0*((400.0-width)/360.0)); // between 1 and 10: 1 = light, 10 = black
        int color = (int)colorDecimal;
        System.out.println("COLOR = "+color + ", WIDTH = "+width);
        Color c = new Color(color, color, color);
        image = dye(image, c);
        return image;
    }
    
    // Even more customization for the luggage movement
    @Override
    public void update(Rectangle parentBounds) {
        Rectangle bounds = getBounds();
        int dx = getDx();
        int dy = getDy();
        int widthRange = parentBounds.width - bounds.width;
        int bufferDistance = 300;
        bounds.x += dx;
        bounds.y += dy;
        // <-----------------------------
        switch (this.getAnimationDirection()) {
            case NORTH:
                if ((bounds.y + bounds.height)  < parentBounds.y) {
                    // Reset after luggage goes off Screen Left <<<
                    bounds.y = parentBounds.y + parentBounds.width + bufferDistance;
                    bounds.x = ThreadLocalRandom.current().nextInt(0, widthRange + 1);
                }
                break;
            case SOUTH:
                if (bounds.y > parentBounds.y + parentBounds.height) {
                    // Reset after luggage goes off Screen Right >>>
                    bounds.y = parentBounds.y - bufferDistance;
                    bounds.x = ThreadLocalRandom.current().nextInt(0, widthRange + 1);
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported luggage animation direction: " + this.getAnimationDirection());
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
