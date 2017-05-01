package catchmeifyoucan;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;


public interface AnimatedShape {
    
    public enum Direction {
        NORTH, SOUTH, EAST, WEST, STATIC
    }

    public void update(Rectangle bounds);

    public void paint(JComponent parent, Graphics2D g2d);

}