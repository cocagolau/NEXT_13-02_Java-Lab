package map;

import java.util.ArrayList;
import java.util.List;

import map.Region;
import junit.framework.TestCase;

public class RegionTest extends TestCase{
	
	Region seoul,asan,chuncheon,deajeon,wonju,gwangju,kyungju;
	List<Edge> edges;
	
	public void setUp() {
		seoul = Region.create(Region.Name.Seoul);
		asan = Region.create(Region.Name.Asan);
		chuncheon = Region.create(Region.Name.Chuncheon);
		deajeon = Region.create(Region.Name.Deajeon);
		wonju = Region.create(Region.Name.Wonju);
		gwangju = Region.create(Region.Name.Gwangju);
		kyungju = Region.create(Region.Name.Kyungju);
		
	}
	
	public void testCreateRegion() {
		
		assertRegion (seoul, Region.Name.Seoul, -1, false, false);
		assertRegion (asan, Region.Name.Asan, -1, false, false);
		assertRegion (chuncheon, Region.Name.Chuncheon, -1, false, false);
		assertRegion (deajeon, Region.Name.Deajeon, -1, false, false);
		assertRegion (wonju, Region.Name.Wonju, -1, false, false);
		assertRegion (gwangju, Region.Name.Gwangju, -1, false, false);
		assertRegion (kyungju, Region.Name.Kyungju, -1, false, false);
	
	}

	private void assertRegion(Region region, Region.Name name, int shortestDistance, boolean chosen, boolean decided) {
		assertEquals(name, region.getName());
		assertEquals(shortestDistance, region.getDistance());
		assertEquals(chosen, region.isChosen());
		assertEquals(decided, region.isDecided());
	}
	
	public void testAddEdge() {
		edges = new ArrayList<Edge>();
		
		Edge s2a = Edge.create(Region.Name.Seoul, Region.Name.Asan, 20);
		Edge s2d = Edge.create(Region.Name.Seoul, Region.Name.Deajeon, 29);
		Edge s2w = Edge.create(Region.Name.Seoul, Region.Name.Wonju, 22);
		Edge s2c = Edge.create(Region.Name.Seoul, Region.Name.Chuncheon, 16);
		
		edges.add(s2a);
		seoul.addEdge(s2a);
		
		edges.add(s2d);
		seoul.addEdge(s2d);
		
		edges.add(s2w);
		seoul.addEdge(s2w);
		
		edges.add(s2c);
		seoul.addEdge(s2c);
		
		assertEquals (4, seoul.getEdgeList().size() );
	}

}
