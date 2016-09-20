
public class TwoWayDict {
	private Location[] locations;
	public TwoWayDict(Location[] l) {
		locations = l;
	}
	
	public Location find(int i) {
		return locations[i];
	}
	public int find(String s) {
		for(int i = 0; i < locations.length; i++) {
			if(locations[i].equals(s)) return i;
		}
		return -1;
	}
}
