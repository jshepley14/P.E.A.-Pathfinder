public class Location implements Comparable<Location> {
	String name;
	int x;
	int y;
	boolean mark;
	
	public Location(String n, int mx, int my) { //O(1) Constructor
		name = n;
		x = mx;
		y = my;
		mark = false;
	}
	
	public String getName() {return name;} //O(1) Getter method
	public int getX() {return x;} //O(1) Getter method
	public int getY() {return y;} //O(1) Getter method
	public void setMark(boolean b) {
		mark = b;
	}
	public boolean getMark() {
		return mark;
	}

	@Override
	public int compareTo(Location l) {
		if(name == null) return 1;
		if(l.getName()== null) return -1;
		return name.compareTo(l.getName());
	}
}
