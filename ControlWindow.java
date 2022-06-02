import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlWindow extends JFrame
{
    protected DisplayWindow displayWindow;
    protected Vector<DanceFloorSet> dances;

    public ControlWindow(DisplayWindow dw)
    {
        super("DisplayNextDance - Control Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        displayWindow = dw;
        dances = new Vector<DanceFloorSet>();
        
        /*JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        //JTextField txt = new JTextField();
        textLabel.setPreferredSize(new Dimension(300, 100));
        this.getContentPane().add(textLabel, BorderLayout.CENTER);*/
        
        DancePanel dancePanel = new DancePanel();
        this.getContentPane().add(dancePanel, BorderLayout.CENTER);
        
        JButton north = new JButton("Nord");
        JButton south = new JButton("Sud");
        JButton east  = new JButton("Est");
        JButton west  = new JButton("Ouest");
        this.add(north, BorderLayout.PAGE_START);
        this.add(south, BorderLayout.PAGE_END);
        this.add(west,  BorderLayout.LINE_START);
        this.add(east,  BorderLayout.LINE_END);
        
        dancePanel.addDanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //JOptionPane.showMessageDialog(null, "test");
                Dance d = new Dance(dancePanel.danceNameTextbox.getText());
                DanceFloorSet df = new DanceFloorSet();
                df.add(d);
                dances.add(df);
                dw.listNextDances(dances);
            }
        });
        
        this.setLocationRelativeTo(null);
        this.pack();
        this.setSize(300, 100);
        this.setVisible(true);
    }
}
