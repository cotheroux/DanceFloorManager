import java.awt.*;
import javax.swing.*;
import java.util.Vector;

public class DisplayWindow extends JFrame
{
    private Vector< Vector<JLabel> > labels;

    public DisplayWindow()
    {
        super("DisplayNextDance - Display Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int nbDancesDisplayed = 5;
        int nbAlternativesDisplayed = 1;
        
        this.setLayout(new GridLayout(nbDancesDisplayed, nbAlternativesDisplayed));
        
        // Full screen (even over windows taskbar)
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        
        // Full screen (but leave windows taskbar alone)
        // @see https://stackoverflow.com/questions/52148325/java-show-fullscreen-swing-application-with-taskbar-without-titlebar
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        //this.setUndecorated(true);
        this.setSize(r.width, r.height);
        
        //JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        
        labels = new Vector< Vector<JLabel> >();
        for (int i = 0; i < nbDancesDisplayed; ++i)
        {
            Vector<JLabel> cols = new Vector<JLabel>();
            for (int j = 0; j < nbAlternativesDisplayed; ++j)
            {
                //JLabel label = new JLabel(Integer.toString(i));
                JLabel label = new JLabel(i + " " + j);
                this.add(label);
                cols.add(label);
            }
            labels.add(cols);
        }
        
        this.setVisible(true);
    }
    
    public void listNextDances(DanceFloorSet[] dfs)
    {
        labels.get(0).get(0).setText("New dance");
    }
}
