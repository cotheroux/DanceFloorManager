import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class EntryClass
{
    private static void createWindow()
    {
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        //textLabel.setPreferredSize(new Dimension(300, 100));
        //frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        //frame.getContentPane().add(textLabel);
        
        //AllDanceFloorSetsDisplayPanel dancesPanel = new AllDanceFloorSetsDisplayPanel(5);
        //frame.getContentPane().add(dancesPanel, BorderLayout.CENTER);
        
        DanceFloorSet dfs1 = new DanceFloorSet();
        Dance d1 = new Dance("Chill Factor");
        dfs1.add(d1);
        Dance d2 = new Dance("Here we go");
        dfs1.add(d2);
        Dance d3 = new Dance("Doodah");
        dfs1.add(d3);
        DanceFloorSetDisplayPanel danceFloorPanel = new DanceFloorSetDisplayPanel(dfs1);
        danceFloorPanel.setBackground(Color.black);
        danceFloorPanel.setForeground(Color.white);
        frame.getContentPane().add(danceFloorPanel);
        
        JButton btn = new JButton("OK");
        frame.add(btn, BorderLayout.PAGE_END);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DanceFloorSet newDfs = new DanceFloorSet();
                Dance newDance = new Dance("Nouvelle danse");
                newDfs.add(newDance);
                danceFloorPanel.setDanceFloor(newDfs);
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
	public static void main(String args[])
	{
        ResizeLabelFont label=new ResizeLabelFont("Some text");
        JFrame frame=new JFrame("Resize label font");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.getContentPane().add(label);
 
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        //createWindow();
        /*DisplayWindow displayWindow = new DisplayWindow();
        ControlWindow controlWindow = new ControlWindow(displayWindow);
        
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
        
        DanceFloorSet dfs3 = new DanceFloorSet();
        Dance d3 = new Dance("Here we go");
        dfs3.add(d3);
        dfsa.add(dfs3);
        
        displayWindow.listNextDances(dfsa);
        /**/
	}
}
// @see https://stackoverflow.com/questions/9311720/how-to-change-jlabel-font-size-to-fill-jpanel-free-space-while-resizing
// @see https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size