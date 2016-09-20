import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class InputPanel extends JPanel implements ActionListener
{
	private JComboBox startlocation;
	private JComboBox endlocation;
	private JTextArea starttext;
	private JTextArea endtext;
	private Location[] locationlist;
	public InputPanel(Location[] l)
	{
		locationlist = l;
		startlocation = new JComboBox();
		endlocation = new JComboBox();
		for(int i = 0; i < locationlist.length && locationlist[i].getName() != null; i++) 
		{
			startlocation.addItem(locationlist[i].getName());
			endlocation.addItem(locationlist[i].getName());
		}
		starttext = new JTextArea("Starting Location:");
		endtext = new JTextArea("Destination:");
		starttext.setEditable(false);
		endtext.setEditable(false);
		setLayout(new GridLayout(2,2));
		add(starttext);
		add(startlocation);
		add(endtext);
		add(endlocation);
	}
	public void clear()
	{
		startlocation.setSelectedItem(0);
		endlocation.setSelectedItem(0);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
}

