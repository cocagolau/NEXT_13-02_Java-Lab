package map;

import java.util.ArrayList;
import java.util.List;

public class Region implements Comparable<Region>{
	
	public enum Name {
		Seoul, Asan, Chuncheon, Deajeon, Wonju, Gwangju, Kyungju;
	};
	
	private Region.Name name;
	private int distance;
	private boolean chosen;
	private boolean decided;
	private List<Edge> edges = null;
	
	
	// private constructor
	private Region (Region.Name name) {
		this.name = name;
		init();
	}	
	// factory
	public static Region create(Region.Name name) {
		return new Region(name);
	}
	
	@Override
	public int compareTo(Region that) {
		if (this.getDistance() < that.getDistance()) return -1;
		else if (this.getDistance() > that.getDistance()) return 0;
		return 0;
	}
	
	public void init() {
		distance = -1;
		chosen = false;
		decided = false;		
	}
	
	public boolean hasDefectiveResult() {
		if (isChosen() && !isDecided()) {
			for (Edge edge : edges)
				if (!edge.isUsed()) return true;
		}
		return false;
	}
	
	public boolean isChosen() {
		return chosen;
	}
	public boolean isDecided() {
		return decided;
	}
	
	public void setDecided() {
		if (isChosen())
			decided = true;		
	}
	
	private void setChosen() {
		chosen = true;		
	}
	public void setDistance(int distance) {
		if (!isDecided()) {
			this.distance = distance;
			if (!isChosen())
				setChosen();
		}
	}
	
	
	public Region.Name getName() {
		return name;
	}
	public int getDistance() {
		return distance;
	}
	public void addEdge(Edge edge) {
		if (edges == null)
			edges = new ArrayList<Edge>();
		edges.add(edge);
	}
	public List<Edge> getEdgeList() {
		return edges;
	}
}
