import java.awt.*;
import javax.swing.*;

public class ControlWindow extends JFrame
{
    public ControlWindow()
    {
        super("DisplayNextDance - Control Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        //JTextField txt = new JTextField();
        textLabel.setPreferredSize(new Dimension(300, 100));
        this.getContentPane().add(textLabel, BorderLayout.CENTER);
        
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
}
