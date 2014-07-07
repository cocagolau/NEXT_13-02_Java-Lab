package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import map.Edge;
import map.Region;
import map.TrainMap;


public class Dijkstra {

	private TrainMap tMap;
	
	private boolean flag = false;
	private List<Region> tempRegions;
	private List<Region> defectiveList = null;
	private List<Edge> edgeList;
		
	public Dijkstra(TrainMap tMap) {
		this.tMap = tMap;
	}

	public int getShortestDistance(Region.Name from, Region.Name to) {
		execute(from);
		return tMap.getShortestDistance(from, to);
	}
	
	// execute
	private void execute(Region.Name name) {
		if (!containsKey(name)) {
			Region region = getRegion(name);
			
			setSourceRegion(region);  // 최초 시작 지역 설정
			calculateShortestDistance(region); // 최단거리 계산
			updateDistance(region);  // 계산결과 최신화 
			trainMapInit();  // map init;
		}
	}
	
	private void setSourceRegion(Region region) {
		region.setDistance(0); // 거리 0으로 설정
		region.setDecided();  // 최단거리 확정 설정
	}
	private void updateDistance(Region region) {
		HashMap<Region.Name, Integer> subResult = new HashMap<Region.Name, Integer>();

		for (Region tempRegion : tMap.getRegionList())
			if (!region.equals(tempRegion))  // 동일지역 제외
				subResult.put(tempRegion.getName(), tempRegion.getDistance());
		putKey(region.getName(), subResult);
	}


	private void calculateShortestDistance(Region region) {		
		tempRegions = new ArrayList<Region>();
		edgeList = region.getEdgeList();
		setFlag(false);
		
		//갈수 있는 지역으로 이동하면서 거리계산
		traverseRegions(region);
		selectRegion(region);
		
	}
	
	// traverse Regions
	private void traverseRegions(Region region) {
		Region nextRegion;
		for (Edge edge : edgeList) {
			if (!edge.isUsed()) {
				edge.setUsed();
				setFlag(true);
				nextRegion = getRegion(edge.getOppositeRegionName(region.getName()));
				tempRegions.add(nextRegion);
				setDistance(nextRegion, (region.getDistance()+edge.getDistance()));
			}
		}
		
	}
	private void setFlag(boolean onOff) {
		flag = onOff;
	}
	private void setDistance(Region nextRegion, int tempDistance) {
		if (nextRegion.isChosen()) {
			if (nextRegion.getDistance() > tempDistance) {
				nextRegion.setDistance(tempDistance);
			}
		}
		else // 거리가 없는 경우, 저장호, 선택
			nextRegion.setDistance(tempDistance);
	}
	
	
	// select Region
	private void selectRegion(Region region) {
		if (flag) {  // 정상
			Collections.sort(tempRegions);
			calculateShortestDistance(getShortestRegion());
		}
		else {  // 비정상
			handleDefectiveRegion(region);  // 문제있는 region 처리
			checkCalculation();	
		}
	}
	// shortestRegion 설정 후 반환
	private Region getShortestRegion() {
		Region region = tempRegions.remove(0);
		region.setDecided();
		return region;
	}
	private void handleDefectiveRegion(Region region) {
		if (region.isChosen() && !region.isDecided())
			region.setDecided();		
	}	
	private void checkCalculation() {
		if (hasDefectiveResult()) {
			for (Region re : defectiveList)
				calculateShortestDistance(re);
		}
	}
	
	// defectiveList
	private boolean hasDefectiveResult() {
		if (createDefectiveList() > 0) return true;
		return false;
	}
	private int createDefectiveList() {
		defectiveList = new ArrayList<Region>();
		for (Region tempR : tMap.getRegionList())
			if (!tempR.isDecided())
				defectiveList.add(tempR);
		
		return defectiveList.size();
	}

	

	
	// Train Map
	private Region getRegion(Region.Name name) {
		return tMap.getRegion(name);
	}
	private void trainMapInit() {
		tMap.init();
	}
	private void putKey(Region.Name region, HashMap<Region.Name, Integer> subResult) {
		tMap.putKey(region, subResult);		
	}
	private boolean containsKey(Region.Name region) { // null인 경우는??
		return tMap.containsKey(region);
	}

}
	

