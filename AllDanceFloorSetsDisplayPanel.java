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
            
            DanceFloorSetDisplayPanel danceFloorSetDisplayPanel = new DanceFloorSetDisplayPanel(danceFloorSet);
            this.add(danceFloorSetDisplayPanel);
            danceFloorSetDisplayPanels.add(danceFloorSetDisplayPanel);
        }
    }
    
    //-------------------------------------------------------------------------
    /**
     * Sets the foreground color of this component and every panels inside it.
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

    //-------------------------------------------------------------------------
    /**
     * Sets the background color of this component and every panels inside it.
     **/
    public void setBackground(Color fg)
    {
        super.setBackground(fg);

        if (danceFloorSetDisplayPanels != null)
        {
            for (DanceFloorSetDisplayPanel danceFloorSetDisplayPanel : danceFloorSetDisplayPanels)
            {
                danceFloorSetDisplayPanel.setBackground(fg);
            }
        }
    }

    //-------------------------------------------------------------------------
    /**
     *
     **/
    public void set(Vector<DanceFloorSet> dances)
    {
        int i = 0;
        //Vector<DanceFloorSetDisplayPanel> danceFloorSetDisplayPanels;
        for (DanceFloorSetDisplayPanel danceFloorSetDisplayPanel : danceFloorSetDisplayPanels)
        {
            System.out.println("AllDanceFloorSetsDisplayPanel: " + i);
            if (i < dances.size())
            {
                danceFloorSetDisplayPanel.setDanceFloor(dances.get(i++));
            }
            else
            {
                System.out.println("AllDanceFloorSetsDisplayPanel: " + "Clear");
                danceFloorSetDisplayPanel.clear();
            }
        }
    }
}
