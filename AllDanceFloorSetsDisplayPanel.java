import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JPanel;

/**
 * GUI to display all dance floor sets.
 **/
public class AllDanceFloorSetsDisplayPanel extends JPanel
{
    protected Vector<DanceFloorSetDisplayPanel> danceFloorSetDisplayPanels;
    
    public AllDanceFloorSetsDisplayPanel(int nb)
    {
        super();
        GridLayout layout = new GridLayout(nb, 1); // 1 col, many rows as necessary.
        layout.setHgap(10);
        //layout.setVgap(10);
        this.setLayout(layout);

        danceFloorSetDisplayPanels = new Vector<DanceFloorSetDisplayPanel>();

        for (int i = 0; i < nb; ++i)
        {
            DanceFloorSet danceFloorSet = new DanceFloorSet();
            Dance d1 = new Dance("Chill Factor");
            danceFloorSet.add(d1);
            
            DanceFloorSetDisplayPanel danceFloorSetDisplayPanel = new DanceFloorSetDisplayPanel(danceFloorSet);
            this.add(danceFloorSetDisplayPanel);
            danceFloorSetDisplayPanels.add(danceFloorSetDisplayPanel);
        }
    }
    
    //-------------------------------------------------------------------------
    /**
     * Sets the foreground color of this component and every labels inside it.
     **/
    public void setForeground(Color fg)
    {
        super.setForeground(fg);
        
        if (danceFloorSetDisplayPanels != null)
        {
            for (DanceFloorSetDisplayPanel danceFloorSetDisplayPanel : danceFloorSetDisplayPanels)
            {
                danceFloorSetDisplayPanel.setForeground(fg);
            }
        }
    }
}