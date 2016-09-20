
public class Path {
	private PathNode start;
	private PathNode curr;
	private PathNode end;
	private int length;
	
	public Path(Location l) {
		start = end = curr = new PathNode(l);
		length = 0;
	}
	
	public void add(Location l, int edgeweight) {
		end.setNext(l);
		end = end.next();
		length += edgeweight;
	}
	private void add(Location l) {
		end.setNext(l);
		end = end.next();
	}
	private void setLength(int l) {
		length = l;
	}
	
	public Location get() {
		if(curr == null) return null;
		Location rtn = curr.getLocation();
		curr = curr.next();
		return rtn;
	}
	public Path copy() {
		Path rtn = new Path(start.getLocation());
		PathNode p = start.next();
		while(p != null) {
			rtn.add(p.getLocation());
			p = p.next();
		}
		rtn.setLength(length);
		return rtn;
	}
	public void moveToStart() {
		curr = start;
	}
	
	public int length() {return length;}
}
