/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchmeifyoucan;


import java.awt.Rectangle;


public abstract class AbstractAnimatedShape implements AnimatedShape {

    private Rectangle bounds;
    private int dx, dy;

    public AbstractAnimatedShape() {
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    @Override
    public void update(Rectangle parentBounds) {
        Rectangle bounds = getBounds();
        int dx = getDx();
        int dy = getDy();
        bounds.x += dx;
        bounds.y += dy;
        if (bounds.x  < parentBounds.x) {
            bounds.x = parentBounds.x;
            setDx(dx *= -1);
        } else if (bounds.x + bounds.width > parentBounds.x + parentBounds.width) {
            bounds.x = parentBounds.x + (parentBounds.width - bounds.width);
            setDx(dx *= -1);
        }
        if (bounds.y < parentBounds.y) {
            bounds.y = parentBounds.y;
            setDy(dy *= -1);
        } else if (bounds.y + bounds.height > parentBounds.y + parentBounds.height) {
            bounds.y = parentBounds.y + (parentBounds.height - bounds.height);
            setDy(dy *= -1);
        }
    }
}