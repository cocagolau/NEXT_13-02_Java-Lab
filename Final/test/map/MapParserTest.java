package map;

import java.util.List;

import simulation.Start;
import utility.Parser;
import junit.framework.TestCase;

public class MapParserTest extends TestCase{
	
	int[] distanceList = new int[] {20, 16, 29, 22, 35, 25, 28, 31, 23, 12, 15, 32, 18};
	Region.Name[] regionNameList = {Region.Name.Seoul, Region.Name.Asan, Region.Name.Chuncheon, Region.Name.Deajeon, Region.Name.Wonju, Region.Name.Gwangju, Region.Name.Kyungju};
	MapParser map;
	public void setUp() {
		map = new MapParser (Start.TRAIN_MAP_PATH, Parser.Separator.TAP);
	}
	
	public void testCreate() {
		
		List<Edge> edgeList = map.getCreations();
		
		// edgeList
		assertEquals (13, map.getCreations().size());
		for (int i=0; i<edgeList.size(); i++)
			assertEquals (distanceList[i], edgeList.get(i).getDistance());
		
		// regionList
		List<Region.Name> regionList = map.getToRegionList();
		assertEquals (7, regionList.size());
		for (int i=0; i<regionList.size(); i++)
			assertEquals (regionNameList[i], regionList.get(i));
	}

}
