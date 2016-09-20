import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class GUI extends JFrame
{
	private JButton reset;
	private JButton go;
	private JButton drawall;
	private JPanel map;
	private JPanel menu;
	private JPanel input;
	private File image;
	private BufferedImage campusmap;
	private DisplayPanel display;
	private PathGraph graph;
	private JComboBox startlocation;
	private JComboBox endlocation;
	//private PathGraph graph;
	public GUI()
	{
		Location[] locations = 
		{
				new Location("Abbot Hall", 341, 221), //0
				new Location("Academy Building", 334, 275), //1
				new Location("Amen Hall", 662, 285), //2
				new Location("Bancroft Hall", 649, 369), //3
				new Location("Bissell House", 468, 347), //4
				new Location("Boathouse", 227, 33), //5
				new Location("Cilley Hall", 683, 251), //6
				new Location("Dunbar Hall", 540, 320), //7
				new Location("Elm Street Dining Hall", 557, 201), //8
				new Location("Ewald Dormitory", 145, 218), //9
				new Location("Fisher Theater", 329, 463), //10
				new Location("Hoyt Hall", 350, 143), //11
				new Location("Jeremiah Smith Hall", 226, 271), //12
				new Location("Lamont Hall", 226, 407), //13
				new Location("Lamont Health Center", 254, 414), //14
				new Location("Langdell", 297, 169), //15
				new Location("Library", 541, 242), //16
				new Location("Love Gym", 847, 330), //17
				new Location("Main Street Hall", 102, 246), //18
				new Location("Mayer Arts Center", 334, 331), //19
				new Location("McConnell Hall", 614, 240), //20
				new Location("Merrill", 268, 165), //21
				new Location("Music Building", 366, 363), //22
				new Location("Peabody Hall", 377, 184), //23
				new Location("Phelps Academy Center", 262, 319), //24
				new Location("Phelps Science Center", 286, 375), //25
				new Location("Phillips Church", 411, 379), //26
				new Location("Phillips Hall", 274, 235), //27
				new Location("Soule Hall", 345, 183), //28
				new Location("Webster Hall", 617, 322), //29
				new Location("Wentworth Hall", 690, 321), //30
				new Location("Wetherell Dining Hall", 283, 166), //31
				new Location("Wheelwright", 242, 200), //32
				new Location(null, 244, 44), //33
				new Location(null, 239, 63), //34
				new Location(null, 253, 67), //35
				new Location(null, 252, 123), //36
				new Location(null, 241, 137), //37
				new Location(null, 229, 129), //38
				new Location(null, 179, 239), //39
				new Location(null, 192, 240), //40
				new Location(null, 149, 305), //41
				new Location(null, 242, 335), //42
				new Location(null, 290, 354), //43
				new Location(null, 290, 342), //44
				new Location(null, 332, 342), //45
				new Location(null, 338, 355), //46
				new Location(null, 368, 356), //47
				new Location(null, 368, 346), //48
				new Location(null, 371, 294), //49
				new Location(null, 369, 264), //50
				new Location(null, 394, 225), //51
				new Location(null, 422, 210), //52
				new Location(null, 426, 198), //53
				new Location(null, 443, 198), //54
				new Location(null, 496, 231), //55
				new Location(null, 513, 273), //56
				new Location(null, 494, 312), //57
				new Location(null, 456, 337), //58
				new Location(null, 435, 344), //59
				new Location(null, 417, 338), //60
				new Location(null, 267, 272), //61
				new Location(null, 298, 271), //62
				new Location(null, 309, 203), //63
				new Location(null, 278, 200), //64
				new Location(null, 281, 180), //65
				new Location(null, 240, 157), //66
				new Location(null, 366, 139), //67
				new Location(null, 626, 287), //68
				new Location(null, 652, 309), //69
				new Location(null, 649, 260), //70
				new Location(null, 733, 261), //71
				new Location(null, 783, 287), //72
				new Location(null, 767, 306), //73
				new Location(null, 747, 307), //74
				new Location(null, 360, 161), //75
				new Location(null, 241, 345), //76
				new Location(null, 311, 115), //77
				new Location(null, 318, 129), //78
				new Location(null, 312, 181)  //79
		};
		graph = new PathGraph(locations);
		graph.setEdge(5,33);
		graph.setEdge(33,34);
		graph.setEdge(34,35);
		graph.setEdge(34,38);
		graph.setEdge(35,36);
		graph.setEdge(36,37);
		graph.setEdge(38,37);
		graph.setEdge(38,39);
		graph.setEdge(39,9);
		graph.setEdge(39,18);
		graph.setEdge(39,40);
		graph.setEdge(40,41);
		graph.setEdge(41,42);
		graph.setEdge(42,24);
		graph.setEdge(42,76);
		graph.setEdge(76,13);
		graph.setEdge(13,14);
		graph.setEdge(14,25);
		graph.setEdge(76,43);
		graph.setEdge(42,44);
		graph.setEdge(43,44);
		graph.setEdge(24,44);
		graph.setEdge(44,45);
		graph.setEdge(45,19);
		graph.setEdge(45,46);
		graph.setEdge(45,48);
		graph.setEdge(46,47);
		graph.setEdge(47,22);
		graph.setEdge(22,26);
		graph.setEdge(46,10);
		graph.setEdge(24,61);
		graph.setEdge(61,12);
		graph.setEdge(12,40);
		graph.setEdge(12,41);
		graph.setEdge(61,27);
		graph.setEdge(27,12);
		graph.setEdge(27,62);
		graph.setEdge(62,61);
		graph.setEdge(62,1);
		graph.setEdge(1,0);
		graph.setEdge(0,63);
		graph.setEdge(27,63);
		graph.setEdge(27,64);
		graph.setEdge(63,64);
		graph.setEdge(65,64);
		graph.setEdge(65,15);
		graph.setEdge(65,21);
		graph.setEdge(65,31);
		graph.setEdge(21,31);
		graph.setEdge(31,15);
		graph.setEdge(15,21);
		graph.setEdge(65,32);
		graph.setEdge(64,32);
		graph.setEdge(32,27);
		graph.setEdge(32,66);
		graph.setEdge(66,37);
		graph.setEdge(36,77);
		graph.setEdge(77,78);
		graph.setEdge(37,78);
		graph.setEdge(78,11);
		graph.setEdge(11,67);
		graph.setEdge(11,75);
		graph.setEdge(11,28);
		graph.setEdge(67,53);
		graph.setEdge(53,52);
		graph.setEdge(53,54);
		graph.setEdge(52,51);
		graph.setEdge(75,23);
		graph.setEdge(28,23);
		graph.setEdge(51,50);
		graph.setEdge(50,1);
		graph.setEdge(50,49);
		graph.setEdge(49,1);
		graph.setEdge(49,60);
		graph.setEdge(60,59);
		graph.setEdge(59,58);
		graph.setEdge(58,4);
		graph.setEdge(58,57);
		graph.setEdge(57,7);
		graph.setEdge(57,56);
		graph.setEdge(56,16);
		graph.setEdge(56,55);
		graph.setEdge(54,8);
		graph.setEdge(55,8);
		graph.setEdge(7,29);
		graph.setEdge(7,16);
		graph.setEdge(56,7);
		graph.setEdge(16,8);
		graph.setEdge(29,68);
		graph.setEdge(29,69);
		graph.setEdge(69,3);
		graph.setEdge(69,30);
		graph.setEdge(69,68);
		graph.setEdge(68,8);
		graph.setEdge(68,70);
		graph.setEdge(70,20);
		graph.setEdge(70,2);
		graph.setEdge(69,2);
		graph.setEdge(70,6);
		graph.setEdge(6,71);
		graph.setEdge(71,72);
		graph.setEdge(72,17);
		graph.setEdge(17,73);
		graph.setEdge(72,73);
		graph.setEdge(73,74);
		graph.setEdge(74,30);
		graph.setEdge(46,10);
		graph.setEdge(14,10);
		graph.setEdge(25,10);
		graph.setEdge(55,54);
		graph.setEdge(20,8);
		graph.setEdge(28,0);
		graph.setEdge(23,53);
		graph.setEdge(28,79);
		graph.setEdge(63,79);
		graph.setEdge(65,79);
		graph.setEdge(78,79);
		graph.setEdge(62,63);
		graph.setEdge(26,59);
		graph.setEdge(10,26);
		graph.setEdge(48,27);
		graph.setEdge(48,59);
		graph.setEdge(12,32);
		graph.setEdge(51,0);
		graph.setEdge(0,62);
		graph.setEdge(24,62);
		graph.setEdge(28,79);
		graph.setEdge(24,1);
		graph.setEdge(44,62);
		graph.setEdge(43, 25);
		setLayout(new BorderLayout());
		input = inputPanel();
		menu = new JPanel(new FlowLayout());
		go = new JButton("Go!");
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.drawPath(graph.findPath(startlocation.getSelectedIndex(), endlocation.getSelectedIndex()));
			}
		});
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startlocation.setSelectedItem(0);
				endlocation.setSelectedItem(0);
				display.drawPath(null);
			}
		});
		drawall = new JButton("Draw All Paths");
		drawall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.drawAll();
			}
		});
		display = new DisplayPanel(graph);
		image = new File("exetermap.png");
		try 
		{
			campusmap = ImageIO.read(image);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		display.colorPanel(campusmap);
		add(input, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
		add(menu, BorderLayout.SOUTH);
		menu.add(go);
		menu.add(reset);
		menu.add(drawall);
		setSize(917,603);
		setVisible(true);
		/*display.addMouseListener(new MouseListener() {
			int i = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("new Location(null, "+e.getX()+", "+e.getY()+"),");
			
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
	}
	public JPanel inputPanel() {
		JPanel rtn = new JPanel();
		startlocation = new JComboBox();
		endlocation = new JComboBox();
		JTextArea starttext = new JTextArea("Starting Location:");
		JTextArea endtext = new JTextArea("Destination:");
		Location[] locationlist = graph.getLocations();
		for(int i = 0; i < locationlist.length && locationlist[i].getName() != null; i++) 
		{
			startlocation.addItem(locationlist[i].getName());
			endlocation.addItem(locationlist[i].getName());
		}
		starttext.setEditable(false);
		endtext.setEditable(false);
		rtn.setLayout(new GridLayout(2,2));
		rtn.add(starttext);
		rtn.add(startlocation);
		rtn.add(endtext);
		rtn.add(endlocation);
		return rtn;
	}
	public static void main(String[] args) 
	{
		GUI g = new GUI();
	}
}
