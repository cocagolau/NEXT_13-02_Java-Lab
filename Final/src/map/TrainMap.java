package map;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TrainMap{

	private Map<Region.Name, HashMap<Region.Name, Integer>> shortestDistance;
	private List<Region.Name> regionList;
	private List<Region> regions;
	private List<Edge> edges;
	private Map<Region.Name, Region> regionCode = null;
	
	
	// private constructor
	private TrainMap (List<Region.Name> regionList, List<Edge> edges) {
		this.shortestDistance = new HashMap<Region.Name, HashMap<Region.Name, Integer>>();
		this.regionList = regionList;
		this.edges = edges;
		createRegion();
		connectRegions();
	}
	
	// factory
	public static TrainMap create(List<Region.Name> regionList, List<Edge> edges) {
		return new TrainMap(regionList, edges);
	}
	// hash
	public boolean containsKey(Region.Name region) {
		return shortestDistance.containsKey(region);
	}
	public void putKey(Region.Name region, HashMap<Region.Name, Integer> subResult) {
		shortestDistance.put(region, subResult);
	}
	public void init() {
		for (Region region : regions)
			region.init();
		for (Edge edge : edges)
			edge.init();
	}
	
	
	public List<Region> getRegionList() {
		return regions;
	}
	
	public int getShortestDistance(Region.Name from, Region.Name to) {
		if(!containsKey(from)) return -1;
		return getValue(from).get(to);
	}
	public Region getRegion(Region.Name name) {
		return regionCode.get(name);
	}
	
	
	private HashMap<Region.Name, Integer> getValue(Region.Name region) {
		return shortestDistance.get(region);
	}
	
	private void createRegion() {
		if (regionCode == null)  // hashmap 없는 경우 생성
			regionCode = new HashMap<Region.Name, Region>();
		
		regions = new ArrayList<Region>();
		
		Region region;
		for (Region.Name name : regionList) {
			region = Region.create(name);
			regionCode.put(name, region);
			regions.add(region);
		}
	}
	
	// edges를 순환하여 각각의 region에 edge의 레퍼런스를 삽입하는 코드
	// edge에 있는 두곳의 region.name을 hash로 접근해 region객체를 받아온 후, 각각의 객체에 edge의 객체를 저장
	private void connectRegions() {
		List<Region.Name> regionNameList;
		for (Edge edge : edges) {
			regionNameList = Arrays.asList(edge.getRegions());
			
			Region region;
			for (Region.Name name : regionNameList) {
				region = getRegion(name);
				region.addEdge(edge);
			}
		}
	}
}
