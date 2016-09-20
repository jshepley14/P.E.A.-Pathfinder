
public class PathGraph {
	private int[][] matrix;
	private int numEdge;
	public Location[] locations;
	
	public PathGraph(Location[] l) {
		locations = l;
		matrix = new int[locations.length][locations.length];
		numEdge = 0;
	}
	
	public int n() { return locations.length; }
	public int e() { return numEdge; }
	
	public int next(int v, int w) {
		for(int i = w+1; i < matrix[v].length; i++) {
			if(matrix[v][i] != 0) return i;
		}
		return matrix[v].length;
	}
	
	public Location getLocation(int v) {
		return locations[v];
	}
	
	public void setEdge(int s, int e) {
		int wt = (int) Math.sqrt((locations[s].getX()-locations[e].getX())*(locations[s].getX()-locations[e].getX())+(locations[s].getY()-locations[e].getY())*(locations[s].getY()-locations[e].getY()));
		matrix[s][e] = wt;
		matrix[e][s] = wt;
		numEdge += 2;
	}
	
	public Path findPath(int s, int e) {
		Path[] D = new Path[locations.length];
		for(int i = 0; i < locations.length; i++) {
			locations[i].setMark(false);
			D[i] = null;
		}
		D[s] = new Path(locations[s]);
		for(int i = 0; i < locations.length; i++) {
			//System.out.println(i);
			int v = minVertex(D);
			locations[v].setMark(true);
			if(D[v] == null) {
				return null; //Unreachable
			}
			for(int w = next(v,-1); w < locations.length; w = next(v,w)) {
				if(D[w] == null || (D[w].length() > D[v].length() + matrix[v][w])) {
					D[w] = D[v].copy();
					D[w].add(locations[w], matrix[v][w]);
				}
			}
		}
		/*for(int i = 0; i < D.length; i++) {
			System.out.print(i+ " ");
			System.out.println(D[i].length());
		}*/
		return D[e];
	}
	private int minVertex(Path[] D) {
		int v = 0;
		for(int i = 0; i < locations.length; i++) {
			if(locations[i].getMark()==false) {
				//System.out.println("original unvisited: "+ i);
				v = i;
				break;
			}
		}
		for(int i=0; i < locations.length; i++) {
			if(D[i] != null && locations[i].getMark() == false && (D[v]==null || D[i].length() < D[v].length())) {
				v = i;
			}
		}
		//System.out.println(v + " " + D[v].length());
		return v;
	}
	public int[][] edges() {
		int[][] rtn = new int[numEdge][4];
		int a = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] > 0) {
					int[] it = rtn[a];
					it[0] = locations[i].getX();
					it[1] = locations[i].getY();
					it[2] = locations[j].getX();
					it[3] = locations[j].getY();
					a++;
				}
			}
		}
		return rtn;
	}
	public Location[] getLocations() {
		return locations;
	}
}
