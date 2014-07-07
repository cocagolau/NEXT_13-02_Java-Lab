package map;

import java.util.ArrayList;
import java.util.List;

import utility.Parser;
import utility.Util;

public class MapParser extends Parser{

	
	private List<Region.Name> regionList;
	private List<Region.Name> toRegionList;
	private List<Region.Name> fromRegionList;

	public MapParser(String docPath, Separator separator) {
		super(docPath, separator); 
	}
	
	public List<Region.Name> getToRegionList() {
		return toRegionList;
	}

	
	@Override
	protected Object createObject(String[] split) {
		return null;
	}
	@Override
	protected List createList(String[] split) {
		// 0일때  도착지점 설정, 
		if (getPresentLine() == 0)
			return setToRegionList(split);
		else
			return createEdgeList(split);
	}
	
	
	private List createEdgeList(String[] split) {
		Region.Name fromRegion = Util.Region(split[0]);
		if (!regionList.contains(fromRegion))
			regionList.add(fromRegion);
		
		List<Edge> edges = new ArrayList<Edge>();
		fromRegionList = new ArrayList<Region.Name>();
		int distance = 0;
		for (int i=1; i<toRegionList.size()+1; i++) {
			if (getPresentLine() < i) {  // 중복된 지역 제외
				distance = Integer.parseInt(split[i]);
				if (distance != 0)  // 거리 0인 곳은 연결되어 있지 않으므로 제외
					edges.add(Edge.create(fromRegion, toRegionList.get(i-1) , distance));
			}
		}
		return edges;
	}

	private List setToRegionList(String[] split) {
		Region.Name regionName;
		List<String> tempList = new ArrayList<String>();
		for (int i=1; i<split.length; i++)
			tempList.add(String.valueOf(split[i]));
		
		regionList = new ArrayList<Region.Name>();
		toRegionList = new ArrayList<Region.Name>();
		for (String name : tempList) {
			regionName = Util.Region(name);
			toRegionList.add(regionName);
			regionList.add(regionName);
		}
		this.regionList = regionList;
		return null;
	}
}
