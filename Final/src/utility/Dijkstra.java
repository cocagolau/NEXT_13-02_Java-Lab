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
			
			setSourceRegion(region);  // ���� ���� ���� ����
			calculateShortestDistance(region); // �ִܰŸ� ���
			updateDistance(region);  // ����� �ֽ�ȭ 
			trainMapInit();  // map init;
		}
	}
	
	private void setSourceRegion(Region region) {
		region.setDistance(0); // �Ÿ� 0���� ����
		region.setDecided();  // �ִܰŸ� Ȯ�� ����
	}
	private void updateDistance(Region region) {
		HashMap<Region.Name, Integer> subResult = new HashMap<Region.Name, Integer>();

		for (Region tempRegion : tMap.getRegionList())
			if (!region.equals(tempRegion))  // �������� ����
				subResult.put(tempRegion.getName(), tempRegion.getDistance());
		putKey(region.getName(), subResult);
	}


	private void calculateShortestDistance(Region region) {		
		tempRegions = new ArrayList<Region>();
		edgeList = region.getEdgeList();
		setFlag(false);
		
		//���� �ִ� �������� �̵��ϸ鼭 �Ÿ����
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
		else // �Ÿ��� ���� ���, ����ȣ, ����
			nextRegion.setDistance(tempDistance);
	}
	
	
	// select Region
	private void selectRegion(Region region) {
		if (flag) {  // ����
			Collections.sort(tempRegions);
			calculateShortestDistance(getShortestRegion());
		}
		else {  // ������
			handleDefectiveRegion(region);  // �����ִ� region ó��
			checkCalculation();	
		}
	}
	// shortestRegion ���� �� ��ȯ
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
	private boolean containsKey(Region.Name region) { // null�� ����??
		return tMap.containsKey(region);
	}

}
	

