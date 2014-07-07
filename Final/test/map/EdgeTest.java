package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class EdgeTest extends TestCase{
	
	List<Edge> edges;
	int[] distance = new int[] {20,29,22,16,28,31,32,23,15,12,35,25,18};
	Region.Name[] regionList = {Region.Name.Seoul, Region.Name.Asan, Region.Name.Chuncheon, Region.Name.Deajeon, Region.Name.Wonju, Region.Name.Gwangju, Region.Name.Kyungju}; 
	List<Region> regions;
	
	Edge s2a, s2d, s2w, s2c;
	Edge c2w, c2k;
	Edge w2k, w2d;
	Edge d2k, d2g, d2a;
	Edge a2g;
	Edge k2g;
	
	public void setUp() {
		edges = new ArrayList<Edge>();
		
		s2a = Edge.create(Region.Name.Seoul, Region.Name.Asan, 20);
		edges.add(s2a);
		s2d = Edge.create(Region.Name.Seoul, Region.Name.Deajeon, 29);
		edges.add(s2d);
		s2w = Edge.create(Region.Name.Seoul, Region.Name.Wonju, 22);
		edges.add(s2w);
		s2c = Edge.create(Region.Name.Seoul, Region.Name.Chuncheon, 16);
		edges.add(s2c);
		
		c2w = Edge.create(Region.Name.Chuncheon, Region.Name.Wonju, 28);
		edges.add(c2w);
		c2k = Edge.create(Region.Name.Chuncheon, Region.Name.Kyungju, 31);
		edges.add(c2k);
		
		w2k = Edge.create(Region.Name.Wonju, Region.Name.Kyungju, 32);
		edges.add(w2k);
		w2d = Edge.create(Region.Name.Wonju, Region.Name.Deajeon, 23);
		edges.add(w2d);
		
		d2k = Edge.create(Region.Name.Deajeon, Region.Name.Kyungju, 15);
		edges.add(d2k);
		d2g = Edge.create(Region.Name.Deajeon, Region.Name.Gwangju, 12);
		edges.add(d2g);
		d2a = Edge.create(Region.Name.Deajeon, Region.Name.Asan, 35);
		edges.add(d2a);
		
		a2g = Edge.create(Region.Name.Asan, Region.Name.Gwangju, 25);
		edges.add(a2g);
		
		k2g = Edge.create(Region.Name.Kyungju, Region.Name.Gwangju, 18);
		edges.add(k2g);
	}
	
	public void testGetDistance () {
		int i=0;
		for (Edge edge : edges)
			assertEquals (distance[i++], edge.getDistance());
	}
	
	public void testGetOppositeRegionName() {
		assertEquals (Region.Name.Asan, s2a.getOppositeRegionName(Region.Name.Seoul));
		assertEquals (Region.Name.Seoul, s2a.getOppositeRegionName(Region.Name.Asan));
		
		assertEquals (Region.Name.Gwangju, k2g.getOppositeRegionName(Region.Name.Kyungju));
		assertEquals (Region.Name.Kyungju, k2g.getOppositeRegionName(Region.Name.Gwangju));
	}
	
	public void getdRegions() {
		List<Region.Name> regions;
		for (Edge edge : edges) {
			regions = Arrays.asList(edge.getRegions());
			assertEquals (2, regions.size());
		}
	}


}
