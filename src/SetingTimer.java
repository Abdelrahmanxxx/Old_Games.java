import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetingTimer extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JButton startButton;
    private Timer timer;

    public SetingTimer() {
        setTitle("Timer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Enter time in minutes:");
        add(label);

        textField = new JTextField(10);
        add(textField);

        startButton = new JButton("Start Timer");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int timeInMinutes = Integer.parseInt(textField.getText());
                int delay = timeInMinutes * 60 * 1000; // Convert to milliseconds

                timer = new Timer(delay, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(SetingTimer.this, "Time's Up!");
                        timer.stop();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
        add(startButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
