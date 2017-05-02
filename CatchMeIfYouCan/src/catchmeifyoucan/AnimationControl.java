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
    public void addAirplane() { animationPanel.addAirplane(); }
    public void removeAirplane() { animationPanel.removeAirplane(); }
    public void clearAirplanes() { animationPanel.clearAirplanes(); }
    public void setBackground(String color) {
        System.out.println("Set Color To: " + color);
        switch (color) {
            case "red":
                animationPanel.setBackground(Color.RED);
                break;
            case "orange":
                animationPanel.setBackground(Color.ORANGE);
                break;
            case "yellow":
                animationPanel.setBackground(Color.YELLOW);
                break;
            case "green":
                animationPanel.setBackground(Color.GREEN);
                break;
            case "blue":
                animationPanel.setBackground(Color.BLUE);
                break;
            default:
                animationPanel.setBackground(Color.GRAY);
                break;
        }
    }
}