package catchmeifyoucan;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;


public class AnimationControl extends JPanel {

    protected AnimationPanel animationPanel = new AnimationPanel();

    public AnimationControl() {
        // Group buttons in a panel
        JPanel panel = new JPanel();

        // Add ball and buttons to the panel
        // ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
        setLayout(new BorderLayout());
        // add(Delay, BorderLayout.NORTH);
        add(animationPanel, BorderLayout.CENTER);
        // add(panel, BorderLayout.SOUTH);
    }
    
    public void add() { animationPanel.add(); }
    public void subtract() { animationPanel.subtract(); }
    public void clearBalls() { animationPanel.clearBalls(); }
    public void suspend() { animationPanel.suspend(); }
    public void resume() { animationPanel.resume(); }
    public void setDelay(int delay) { animationPanel.setDelay(delay); }
    public void changeRectangleColor() { animationPanel.changeRectangleColor(); }
    public void setRectangleSize(int size) { animationPanel.setRectangleSize(size); }
    public void setAirplaneSpeed(int speed) { animationPanel.setAirplaneSpeed(speed); }
    public void setLuggageSpeed(int speed) { animationPanel.setLuggageSpeed(speed); }
    public void addAirplane() { animationPanel.addAirplane(); }
    public void removeAirplane() { animationPanel.removeAirplane(); }
    public void clearAirplanes() { animationPanel.clearAirplanes(); }
    public void addLuggage() { animationPanel.addLuggage(); }
    public void removeLuggage() { animationPanel.removeLuggage(); }
    public void clearLuggage() { animationPanel.clearLuggage(); }
    public void setBackgroundColor(Color color) {
        animationPanel.setBackground(color);
    }
}