import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FontMetrics;

/**
 * GUI to display a single dance floor set.
 **/
public class DanceFloorSetDisplayPanel extends JPanel
{
    protected Vector<JLabel> labels;
    
    public DanceFloorSetDisplayPanel(DanceFloorSet set)
    {
        super();
        labels = new Vector<JLabel>();

        this.setDanceFloor(set);
        this.addComponentListener(new ResizeListener());
    }
    
    //-------------------------------------------------------------------------
    public void setDanceFloor(DanceFloorSet danceFloors)
    {
        this.removeLabels();
        GridLayout layout = new GridLayout(1, danceFloors.size()); // 1 row, many cols as necessary.
        layout.setHgap(10);
        //layout.setVgap(10);
        this.setLayout(layout);

        //for (Dance d: danceFloors) // @todo Implements iterator
        for (int i = 0; i < danceFloors.size(); ++i)
        {
            Dance d = danceFloors.get(i);
            JLabel danceNameLabel = new ResizeLabelFont(d.toString());
            danceNameLabel.setForeground(this.getForeground());
            this.add(danceNameLabel);
            labels.add(danceNameLabel);
        }
        
        this.revalidate();
    }
    
    private void removeLabels()
    {
        for (JLabel label: labels)
        {
            this.remove(label);
        }
        labels.clear();
    }
    
    //-------------------------------------------------------------------------
    /**
     * Sets the foreground color of this component and every labels inside it.
     **/
    public void setForeground(Color fg)
    {
        super.setForeground(fg);
        
        if (labels != null)
        {
            for (JLabel label : labels)
            {
                label.setForeground(fg);
            }
        }
    }

    /**
     * @see https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
     **/
    private void adjustFontSize(JLabel label)
    {
        Font font = label.getFont();
        
        // Set the label's font size to a small size.
        label.setFont(new Font(font.getName(), Font.PLAIN, 1));
        
        font = label.getFont();
        String text = label.getText();
        
        FontMetrics metrics = label.getFontMetrics(font);
        int stringWidth  = metrics.stringWidth(text);
        int stringHeight = metrics.getHeight();
        int componentWidth  = label.getWidth();
        int componentHeight = label.getHeight();
                
        // Find out how much the font can grow in width.
        double widthRatio  = (double) componentWidth  / (double) stringWidth;
        double heightRatio = (double) componentHeight / (double) stringHeight;
                
        int newFontSizeW  = (int) (font.getSize() * widthRatio);
        int newFontSizeH = (int) (font.getSize() * heightRatio);
                
        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSizeW, newFontSizeH);
                
        // Set the label's font size to the newly determined size.
        label.setFont(new Font(font.getName(), Font.PLAIN, fontSizeToUse));
    }
    
    // @see https://stackoverflow.com/questions/1088595/how-to-do-something-on-swing-component-resizing
    class ResizeListener extends ComponentAdapter
    {
        public void componentResized(ComponentEvent e)
        {
            for (JLabel label : ((DanceFloorSetDisplayPanel)e.getComponent()).labels)
            {
                //adjustFontSize(label);
            }
        }
    }
}