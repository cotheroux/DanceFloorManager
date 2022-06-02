import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * GUI to edit a single dance.
 **/
public class DancePanel extends JPanel
{
    public DancePanel()
    {
        super();
        GridLayout layout = new GridLayout(3, 2); // 3 rows, 2 cols.
        layout.setHgap(10);
        //layout.setVgap(10);
        this.setLayout(layout);

        //this.setBackground(Color.yellow);
        
        JLabel danceNameLabel = new JLabel("Nom de la danse");
        //danceNameLabel.setOpaque(true);
        //danceNameLabel.setBackground(Color.gray);
        this.add(danceNameLabel);
        
        JTextField danceNameTextbox = new JTextField(30);
        this.add(danceNameTextbox);
        
        JRadioButton lineRadio    = new JRadioButton("En ligne");
        JRadioButton partnerRadio = new JRadioButton("En partenaire");
        
        ButtonGroup lpRadioGroup = new ButtonGroup();
        lpRadioGroup.add(lineRadio);
        lpRadioGroup.add(partnerRadio);
        
        this.add(lineRadio);
        this.add(partnerRadio);
        
        JButton cancelDanceButton = new JButton("Annuler");
        this.add(cancelDanceButton);

        JButton addDanceButton = new JButton("Ajouter");
        this.add(addDanceButton);
    }
}