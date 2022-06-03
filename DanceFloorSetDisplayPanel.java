import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * GUI to edit a single dance.
 **/
public class DanceFloorSetDisplayPanel extends JPanel
{
    protected Vector<JLabel> labels;
    
    public DanceFloorSetDisplayPanel(DanceFloorSet set)
    {
        super();
        GridLayout layout = new GridLayout(1, set.size()); // 1 row, many cols as necessary.
        layout.setHgap(10);
        //layout.setVgap(10);
        this.setLayout(layout);

        this.setBackground(Color.yellow);
        
        labels = new Vector<JLabel>();

        //for (Dance d: set) // @todo Implements iterator
        for (int i = 0; i < set.size(); ++i)
        {
            Dance d = set.get(i);
            JLabel danceNameLabel = new JLabel(d.toString(), SwingConstants.CENTER);
            //danceNameLabel.setOpaque(true);
            //danceNameLabel.setBackground(Color.gray);
            this.add(danceNameLabel);
            labels.add(danceNameLabel);
            
            danceNameLabel.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)  
                {
                    JLabel label = (JLabel) e.getComponent();
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
                    
                    System.out.println("string width = " + stringWidth);
                    System.out.println("component width = " + componentWidth);
                    System.out.println("width ration = " + widthRatio);
                    System.out.println("old font size = " + font.getSize());
                    System.out.println("new font size = " + newFontSize);
                    System.out.println("component height = " + componentHeight);
                    System.out.println("font size to use = " + fontSizeToUse);
                }
            });
        }
        
        this.addComponentListener(new ResizeListener());
    }
    
    // @see https://stackoverflow.com/questions/1088595/how-to-do-something-on-swing-component-resizing
    class ResizeListener extends ComponentAdapter
    {
        public void componentResized(ComponentEvent e)
        {
            for (JLabel label : ((DanceFloorSetDisplayPanel)e.getComponent()).labels)
            {
                this.adjustFontSize(label);
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
}