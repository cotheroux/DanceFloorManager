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
                JLabel label = new JLabel(i + " " + j, SwingConstants.CENTER);
                this.add(label);
                cols.add(label);
            }
            labels.add(cols);
        }
        
        this.setVisible(true);
    }
    
    public void listNextDances(Vector<DanceFloorSet> dfsa)
    {
        int i = 0;
        for (DanceFloorSet dfs : dfsa)
        {
            labels.get(i).get(0).setText(dfs.get(0).toString());
            adjustFontSize(labels.get(i).get(0));
            ++i;
        }
    }
    
    /**
     * @see https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
     **/
    private void adjustFontSize(JLabel label)
    {
        
        Font font = label.getFont();
        String text = label.getText();
        
        int stringWidth = label.getFontMetrics(font).stringWidth(text);
        int componentWidth = label.getWidth();
        
        // Find out how much the font can grow in width.
        double widthRatio = (double) componentWidth / (double) stringWidth;
        
        int newFontSize = (int) (font.getSize() * widthRatio);
        int componentHeight = label.getHeight();
        
        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        
        // Set the label's font size to the newly determined size.
        label.setFont(new Font(font.getName(), Font.PLAIN, fontSizeToUse));
    }
}
