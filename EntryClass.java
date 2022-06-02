import java.awt.*;
import javax.swing.*;
import java.util.Vector;

public class EntryClass
{
    private static void createWindow()
    {
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        //frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.getContentPane().add(textLabel);
        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
	public static void main(String args[])
	{
        //createWindow();
        ControlWindow controlWindow = new ControlWindow();
        DisplayWindow displayWindow = new DisplayWindow();
        
        Vector<DanceFloorSet> dfsa = new Vector<DanceFloorSet>();
        DanceFloorSet dfs1 = new DanceFloorSet();
        DanceFloorSet dfs2 = new DanceFloorSet();
        Dance d1 = new Dance("Chill Factor");
        Dance d2 = new Dance("Un maudite longue danse pour rien, mais รงa va tester mon programme");
        
        dfs1.add(d1);
        dfs2.add(d2);
        dfsa.add(dfs1);
        dfsa.add(dfs2);
        
        displayWindow.listNextDances(dfsa);
	}
}
// @see https://stackoverflow.com/questions/9311720/how-to-change-jlabel-font-size-to-fill-jpanel-free-space-while-resizing
// @see https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size