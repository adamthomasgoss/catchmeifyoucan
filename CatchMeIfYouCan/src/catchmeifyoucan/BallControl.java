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
    private JButton Suspend = new JButton("Suspend");
    private JButton Resume = new JButton("Resume");
    private JButton Add = new JButton("+1");
    private JButton Subtract = new JButton("-1");
    private JScrollBar Delay = new JScrollBar();

    public BallControl() {
        // Group buttons in a panel
        JPanel panel = new JPanel();
        panel.add(Suspend);
        panel.add(Resume);
        panel.add(Add);
        panel.add(Subtract);

        // Add ball and buttons to the panel
        ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
        Delay.setOrientation(JScrollBar.HORIZONTAL);
        ballPanel.setDelay(Delay.getMaximum());
        setLayout(new BorderLayout());
        add(Delay, BorderLayout.NORTH);
        add(ballPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Register listeners
        Suspend.addActionListener(new Listener());
        Resume.addActionListener(new Listener());
        Add.addActionListener(new Listener());
        Subtract.addActionListener(new Listener());
        Delay.addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent e) {
                ballPanel.setDelay(Delay.getMaximum() - e.getValue());
            }
        });
    }

    class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Suspend) {
                ballPanel.suspend();
            } else if (e.getSource() == Resume) {
                ballPanel.resume();
            } else if (e.getSource() == Add) {
                ballPanel.add();
            } else if (e.getSource() == Subtract) {
                ballPanel.subtract();
            }
        }
    }
}