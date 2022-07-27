import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class EntryClass
{
    protected static Vector<DanceFloorSet> dances;
    
    private static void createWindow()
    {
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dances = new Vector<DanceFloorSet>();
        
        //JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        //textLabel.setPreferredSize(new Dimension(300, 100));
        //frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        //frame.getContentPane().add(textLabel);
        
        AllDanceFloorSetsDisplayPanel dancesPanel = new AllDanceFloorSetsDisplayPanel(5);
        dancesPanel.setBackground(Color.black);
        dancesPanel.setForeground(Color.white);
        frame.getContentPane().add(dancesPanel, BorderLayout.CENTER);
        
        /*DanceFloorSet dfs1 = new DanceFloorSet();
        Dance d1 = new Dance("Chill Factor");
        dfs1.add(d1);
        Dance d2 = new Dance("Here we go");
        dfs1.add(d2);
        Dance d3 = new Dance("Doodah");
        dfs1.add(d3);
        DanceFloorSetDisplayPanel danceFloorPanel = new DanceFloorSetDisplayPanel(dfs1);
        danceFloorPanel.setBackground(Color.black);
        danceFloorPanel.setForeground(Color.white);
        frame.getContentPane().add(danceFloorPanel);*/
        //DanceHistoryPanel danceHistoryPanel = new DanceHistoryPanel();
        //frame.getContentPane().add(danceHistoryPanel);
        
        JLabel etiquette = new JLabel("Etiquette");
        frame.add(etiquette, BorderLayout.PAGE_START);
        
        JButton btn = new JButton("Ajoute une danse");
        frame.add(btn, BorderLayout.PAGE_END);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dances.add(_tempAddDance("Aloha"));
                dances.add(_tempAddDance("Chill Factor"));
                dances.add(_tempAddDance("The Heartbreaker"));
                dances.add(_tempAddDance("Clap Happy"));
                dances.add(_tempAddDance("Better by the beer"));
                dances.add(_tempAddDance("Lève ton verre"));
                /*String danceName = JOptionPane.showInputDialog("Entrez le nom de la nouvelle danse:");
                if (danceName != null)
                {
                    DanceFloorSet newDfs = new DanceFloorSet();
                    Dance newDance = new Dance(danceName);
                    newDfs.add(newDance);
                    dances.add(newDfs);
                    System.out.println(newDance.toString());
                    //danceFloorPanel.setDanceFloor(newDfs);
                    dancesPanel.set(dances);
                }*/
                dancesPanel.set(dances);
            }
        });
        
        /*JButton btnSupprime = new JButton("Enlève la dernière danse");
        frame.add(btnSupprime, BorderLayout.LINE_END);
        
        btnSupprime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (dances.size() > 0)
                {
                    // Remove last dance.
                    dances.remove(dances.size() - 1);
                    dancesPanel.set(dances);
                }
            }
        });*/
        
        JButton btnUp = new JButton("UP");
        frame.add(btnUp, BorderLayout.LINE_START);
        
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dancesPanel.previous();
            }
        });
        
        JButton btnDown = new JButton("DOWN");
        frame.add(btnDown, BorderLayout.LINE_END);
        
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dancesPanel.next();
            }
        });

        /*JButton btnLine = new JButton("---");
        frame.add(btnLine, BorderLayout.LINE_START);
        
        btnLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //System.out.println("---------------------");
                frame.remove(etiquette);
                frame.revalidate();
            }
        });*/
        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Temporary, add a dance to the list.
     **/
    public static DanceFloorSet _tempAddDance(String s)
    {
        DanceFloorSet newDfs = new DanceFloorSet();
        Dance newDance = new Dance(s);
        newDfs.add(newDance);
        return newDfs;
    }
    
	public static void main(String args[])
	{
        /*ResizeLabelFont label=new ResizeLabelFont("Some text");
        JFrame frame=new JFrame("Resize label font");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.getContentPane().add(label);
 
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
        
        //JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green.");
        createWindow();
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