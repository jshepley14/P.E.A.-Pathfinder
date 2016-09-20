import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
public class DisplayPanel extends JPanel
{
	private BufferedImage campus;
	private Path currentPath;
	private PathGraph pg;
	private boolean drawAll;
	public DisplayPanel(PathGraph d)
	{
		pg =d;
		drawAll = false;
	}
	public void drawPath(Path p) {
		drawAll = false;
		currentPath = p;
		repaint();
	}
	public void drawAll() {
		drawAll = true;
		repaint();
	}
	public void colorPanel(BufferedImage image)
	{
		campus = image;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(campus,0,0,null);
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(5));
		if(drawAll) {
			int[][] it = pg.edges();
			for(int i = 0; i < it.length; i++) {
				g2d.draw(new Line2D.Float(it[i][0], it[i][1], it[i][2], it[i][3]));
			}
			/*Location[] locations = pg.getLocations();
			g.setColor(Color.GREEN);
			for(int i = 0; i < locations.length; i++) {
				g.drawString(i + "", locations[i].getX(), locations[i].getY());
			}*/
		}
		if(currentPath != null) {
			currentPath.moveToStart();
			Location prev = currentPath.get();
			Location curr = currentPath.get();
			//if(curr == null) curr = prev;
			while(curr != null) {
				g2d.draw(new Line2D.Float(prev.getX(),prev.getY(),curr.getX(),curr.getY()));
				prev = curr;
				curr = currentPath.get();
			}
			float feet = currentPath.length()*2.83844f;
			float miles = feet/5280f;
			float minutes = (miles/3.1f)*60f;
			float sec = ((100*minutes)%100)*100*60;
			String fstring = ((int)(feet)) + " feet or " ;
			String mstring = (int)miles + ".";
			String timemin = (int)(minutes) + " minutes";
			int decimal = (int)(miles*100)%100;
			if(decimal < 10) mstring += "0";
			mstring += decimal +" miles. Estimated time:  ";
			
			g.setColor(Color.GREEN);
			g.setFont(new Font("Arial",Font.BOLD,20));
			g.drawString("Total Travel Distance is "+fstring+ mstring + timemin, 150,62);
		}
	}
}
