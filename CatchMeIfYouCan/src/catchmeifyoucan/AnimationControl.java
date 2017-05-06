package catchmeifyoucan;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;


public class AnimationControl extends JPanel {

    protected AnimationPanel animationPanel1 = new AnimationPanel();
    protected AnimationPanel animationPanel2 = new AnimationPanel();
    protected int currentScene = 1;

    public AnimationControl() {
        // Group buttons in a panel
        JPanel panel = new JPanel();
        
        animationPanel2.setBackground(Color.black);

        // Add ball and buttons to the panel
        // ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
        setLayout(new BorderLayout());
        // add(Delay, BorderLayout.NORTH);
        add(animationPanel1, BorderLayout.CENTER);
        // add(panel, BorderLayout.SOUTH);
    }
    
    public void add() { animationPanel1.add(); }
    public void subtract() { animationPanel1.subtract(); }
    public void clearBalls() { animationPanel1.clearBalls(); }
    public void suspend() { animationPanel1.suspend(); }
    public void resume() { animationPanel1.resume(); }
    public void setDelay(int delay) { animationPanel1.setDelay(delay); }
    public void changeRectangleColor() { animationPanel1.changeRectangleColor(); }
    public void setRectangleSize(int size) { animationPanel1.setRectangleSize(size); }
    public void setAirplaneSpeed(int speed) { animationPanel1.setAirplaneSpeed(speed); }
    public void setLuggageSpeed(int speed) { animationPanel1.setLuggageSpeed(speed); }
    public void addAirplane() { animationPanel1.addAirplane(); }
    public void removeAirplane() { animationPanel1.removeAirplane(); }
    public void clearAirplanes() { animationPanel1.clearAirplanes(); }
    public void addLuggage() { animationPanel1.addLuggage(); }
    public void removeLuggage() { animationPanel1.removeLuggage(); }
    public void clearLuggage() { animationPanel1.clearLuggage(); }
    public void setBackgroundColor(Color color) {
        animationPanel1.setBackground(color);
    }
    public void initScene1() {
        if (currentScene == 2) {
            remove(animationPanel2);
            add(animationPanel1);
            revalidate();
            repaint();
            currentScene = 1;
        }
    }
    public void initScene2() {
        if (currentScene == 1) {
            remove(animationPanel1);
            add(animationPanel2);
            revalidate();
            repaint();
            currentScene = 2;
        }
    }
    public void hideAllRoyalty() {
        animationPanel2.hideAllRoyalty();
    }
    public void showAllRoyalty() {
        animationPanel2.showAllRoyalty();
    }
}