
public class PathNode {
	Location vertex;
	PathNode next;
	
	public PathNode(Location v) {
		vertex = v;
		next = null;
	}
	public Location getLocation() {
		return vertex;
	}
	public PathNode next() {
		return next;
	}
	
	public void setNext(Location vertex) {
		next = new PathNode(vertex);
	}
}
