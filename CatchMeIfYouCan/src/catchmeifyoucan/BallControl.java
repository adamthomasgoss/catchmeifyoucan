package catchmeifyoucan;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;


public class BallControl extends JPanel {

    private BallPanel ballPanel = new BallPanel();

    public BallControl() {
        // Group buttons in a panel
        JPanel panel = new JPanel();

        // Add ball and buttons to the panel
        ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
        setLayout(new BorderLayout());
        // add(Delay, BorderLayout.NORTH);
        add(ballPanel, BorderLayout.CENTER);
        // add(panel, BorderLayout.SOUTH);
    }
    
    public void add() { ballPanel.add(); }
    public void subtract() { ballPanel.subtract(); }
    public void suspend() { ballPanel.suspend(); }
    public void resume() { ballPanel.resume(); }
    public void setDelay(int delay) { ballPanel.setDelay(delay); }
}