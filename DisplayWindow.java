import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Vector;

public class DisplayWindow extends JFrame
{
    protected Vector<DanceFloorSetDisplayPanel> danceFloorSets;

    public DisplayWindow()
    {
        super("DisplayNextDance - Display Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.getContentPane().setBackground(Color.black);
        
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
        
        danceFloorSets = new Vector<DanceFloorSetDisplayPanel>();
        for (int i = 0; i < nbDancesDisplayed; ++i)
        {
            DanceFloorSet dfs = new DanceFloorSet();
            Dance d = new Dance("Dance #" + i);
            dfs.add(d);
            DanceFloorSetDisplayPanel danceFloorSetDisplayPanel = new DanceFloorSetDisplayPanel(dfs);
            this.add(danceFloorSetDisplayPanel);
            danceFloorSets.add(danceFloorSetDisplayPanel);
        }
        
        this.setVisible(true);
    }
    
    public void listNextDances(Vector<DanceFloorSet> dances)
    {
        for (DanceFloorSetDisplayPanel dfsdp : danceFloorSets)
        {
            //dfsdp
        }
        /*int i = 0;
        for (Vector<JLabel> cols : labels)
        {
            int j = 0;
            for (JLabel label : cols)
            {
                if ((i < dances.size())
                /*&&  (j < dances.get(i).size())*//*)
                {
                    label.setText(dances.get(i).get(j).toString());
                }
                else
                {
                    label.setText("");
                }
                adjustFontSize(label);
                ++j;
            }
            ++i;
        }*/
        /*for (DanceFloorSet dfs : dances)
        {
            labels.get(i).get(0).setText(dfs.get(0).toString());
            adjustFontSize(labels.get(i).get(0));
            ++i;
        }*/
    }
}
