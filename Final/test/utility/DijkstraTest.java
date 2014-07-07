package utility;

import java.util.ArrayList;
import java.util.List;

import map.Edge;
import map.Region;
import map.TrainMap;

import junit.framework.TestCase;

public class DijkstraTest extends TestCase{
	
	TrainMap tMap;
	List<Region.Name> regionList;
	List<Edge> edges;
	Dijkstra dijkstra;
	
	public void setUp() {
		createEdges();
		createRegions();
		tMap = TrainMap.create(regionList, edges);
		dijkstra = new Dijkstra (tMap);
	}
	private void createRegions() {
		regionList = new ArrayList<Region.Name>();
		
		regionList.add(Region.Name.Seoul);
		regionList.add(Region.Name.Asan);
		regionList.add(Region.Name.Chuncheon);
		regionList.add(Region.Name.Deajeon);
		regionList.add(Region.Name.Wonju);
		regionList.add(Region.Name.Gwangju);
		regionList.add(Region.Name.Kyungju);
		
	}
	private void createEdges() {
		edges = new ArrayList<Edge>();
		
		edges.add(Edge.create(Region.Name.Seoul, Region.Name.Asan, 20));
		edges.add(Edge.create(Region.Name.Seoul, Region.Name.Deajeon, 29));
		edges.add(Edge.create(Region.Name.Seoul, Region.Name.Wonju, 22));
		edges.add(Edge.create(Region.Name.Seoul, Region.Name.Chuncheon, 16));
		
		
		edges.add(Edge.create(Region.Name.Chuncheon, Region.Name.Wonju, 28));
		edges.add(Edge.create(Region.Name.Chuncheon, Region.Name.Kyungju, 31));
		
		edges.add(Edge.create(Region.Name.Wonju, Region.Name.Kyungju, 32));
		edges.add(Edge.create(Region.Name.Wonju, Region.Name.Deajeon, 23));
		
		edges.add(Edge.create(Region.Name.Deajeon, Region.Name.Kyungju, 15));
		edges.add(Edge.create(Region.Name.Deajeon, Region.Name.Gwangju, 12));
		edges.add(Edge.create(Region.Name.Deajeon, Region.Name.Asan, 35));
		
		edges.add(Edge.create(Region.Name.Asan, Region.Name.Gwangju, 25));
		
		edges.add(Edge.create(Region.Name.Kyungju, Region.Name.Gwangju, 18));		
	}
	
	
	public void testGetShortestDistance() {
		// seoul
		assertFalse (tMap.containsKey(Region.Name.Seoul));
		assertEquals (20, dijkstra.getShortestDistance(Region.Name.Seoul, Region.Name.Asan));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		
		assertEquals (16, dijkstra.getShortestDistance(Region.Name.Seoul, Region.Name.Chuncheon));
		assertEquals (29, dijkstra.getShortestDistance(Region.Name.Seoul, Region.Name.Deajeon));
		assertEquals (22, dijkstra.getShortestDistance(Region.Name.Seoul, Region.Name.Wonju));
		assertEquals (41, dijkstra.getShortestDistance(Region.Name.Seoul, Region.Name.Gwangju));
		assertEquals (44, dijkstra.getShortestDistance(Region.Name.Seoul, Region.Name.Kyungju));

		
		// asan
		assertFalse (tMap.containsKey(Region.Name.Asan));
		assertEquals (20, dijkstra.getShortestDistance(Region.Name.Asan, Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Asan));
		
		assertEquals (36, dijkstra.getShortestDistance(Region.Name.Asan, Region.Name.Chuncheon));
		assertEquals (35, dijkstra.getShortestDistance(Region.Name.Asan, Region.Name.Deajeon));
		assertEquals (42, dijkstra.getShortestDistance(Region.Name.Asan, Region.Name.Wonju));
		assertEquals (25, dijkstra.getShortestDistance(Region.Name.Asan, Region.Name.Gwangju));
		assertEquals (43, dijkstra.getShortestDistance(Region.Name.Asan, Region.Name.Kyungju));
		
		
		// chuncheon
		assertFalse (tMap.containsKey(Region.Name.Chuncheon));
		assertEquals (16, dijkstra.getShortestDistance(Region.Name.Chuncheon, Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Asan));
		assertTrue (tMap.containsKey(Region.Name.Chuncheon));
		assertEquals (36, dijkstra.getShortestDistance(Region.Name.Chuncheon, Region.Name.Asan));
		assertEquals (45, dijkstra.getShortestDistance(Region.Name.Chuncheon, Region.Name.Deajeon));
		assertEquals (28, dijkstra.getShortestDistance(Region.Name.Chuncheon, Region.Name.Wonju));
		assertEquals (49, dijkstra.getShortestDistance(Region.Name.Chuncheon, Region.Name.Gwangju));
		assertEquals (31, dijkstra.getShortestDistance(Region.Name.Chuncheon, Region.Name.Kyungju));
		
		
		// deajeon
		assertFalse (tMap.containsKey(Region.Name.Deajeon));
		assertEquals (29, dijkstra.getShortestDistance(Region.Name.Deajeon, Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Asan));
		assertTrue (tMap.containsKey(Region.Name.Chuncheon));
		assertTrue (tMap.containsKey(Region.Name.Deajeon));
		
		assertEquals (35, dijkstra.getShortestDistance(Region.Name.Deajeon, Region.Name.Asan));
		assertEquals (45, dijkstra.getShortestDistance(Region.Name.Deajeon, Region.Name.Chuncheon));
		assertEquals (23, dijkstra.getShortestDistance(Region.Name.Deajeon, Region.Name.Wonju));
		assertEquals (12, dijkstra.getShortestDistance(Region.Name.Deajeon, Region.Name.Gwangju));
		assertEquals (15, dijkstra.getShortestDistance(Region.Name.Deajeon, Region.Name.Kyungju));
		
		
		// wonju
		assertFalse (tMap.containsKey(Region.Name.Wonju));
		assertEquals (22, dijkstra.getShortestDistance(Region.Name.Wonju, Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Asan));
		assertTrue (tMap.containsKey(Region.Name.Chuncheon));
		assertTrue (tMap.containsKey(Region.Name.Deajeon));
		assertTrue (tMap.containsKey(Region.Name.Wonju));
		
		assertEquals (42, dijkstra.getShortestDistance(Region.Name.Wonju, Region.Name.Asan));
		assertEquals (28, dijkstra.getShortestDistance(Region.Name.Wonju, Region.Name.Chuncheon));
		assertEquals (23, dijkstra.getShortestDistance(Region.Name.Wonju, Region.Name.Deajeon));
		assertEquals (35, dijkstra.getShortestDistance(Region.Name.Wonju, Region.Name.Gwangju));
		assertEquals (32, dijkstra.getShortestDistance(Region.Name.Wonju, Region.Name.Kyungju));
		
		
		// Gwangju
		assertFalse (tMap.containsKey(Region.Name.Gwangju));
		assertEquals (41, dijkstra.getShortestDistance(Region.Name.Gwangju, Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Asan));
		assertTrue (tMap.containsKey(Region.Name.Chuncheon));
		assertTrue (tMap.containsKey(Region.Name.Deajeon));
		assertTrue (tMap.containsKey(Region.Name.Wonju));
		assertTrue (tMap.containsKey(Region.Name.Gwangju));
		
		assertEquals (25, dijkstra.getShortestDistance(Region.Name.Gwangju, Region.Name.Asan));
		assertEquals (49, dijkstra.getShortestDistance(Region.Name.Gwangju, Region.Name.Chuncheon));
		assertEquals (12, dijkstra.getShortestDistance(Region.Name.Gwangju, Region.Name.Deajeon));
		assertEquals (35, dijkstra.getShortestDistance(Region.Name.Gwangju, Region.Name.Wonju));
		assertEquals (18, dijkstra.getShortestDistance(Region.Name.Gwangju, Region.Name.Kyungju));
		
		
		// Kyungju
		assertFalse (tMap.containsKey(Region.Name.Kyungju));
		assertEquals (44, dijkstra.getShortestDistance(Region.Name.Kyungju, Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Seoul));
		assertTrue (tMap.containsKey(Region.Name.Asan));
		assertTrue (tMap.containsKey(Region.Name.Chuncheon));
		assertTrue (tMap.containsKey(Region.Name.Deajeon));
		assertTrue (tMap.containsKey(Region.Name.Wonju));
		assertTrue (tMap.containsKey(Region.Name.Gwangju));
		assertTrue (tMap.containsKey(Region.Name.Kyungju));
		
		assertEquals (43, dijkstra.getShortestDistance(Region.Name.Kyungju, Region.Name.Asan));
		assertEquals (31, dijkstra.getShortestDistance(Region.Name.Kyungju, Region.Name.Chuncheon));
		assertEquals (15, dijkstra.getShortestDistance(Region.Name.Kyungju, Region.Name.Deajeon));
		assertEquals (32, dijkstra.getShortestDistance(Region.Name.Kyungju, Region.Name.Wonju));
		assertEquals (18, dijkstra.getShortestDistance(Region.Name.Kyungju, Region.Name.Gwangju));
		
		
	}

}
