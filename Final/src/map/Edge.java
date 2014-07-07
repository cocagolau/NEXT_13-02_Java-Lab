package map;

public class Edge {
	private Region.Name[] regions = new Region.Name[2];
	private int distance;
	private boolean used;
	
	//private constructor
	private Edge (Region.Name region1, Region.Name region2, int distance) {
		this.regions[0] = region1;
		this.regions[1] = region2;
		this.distance = distance;		
		init();
	}
	
	//factory
	public static Edge create(Region.Name region1, Region.Name region2, int distance) {
		return new Edge (region1, region2, distance);
	}

	public void init() {
		used = false;
	}
	public void setUsed() {
		used = true;
	}
	public boolean isUsed() {
		return used;
	}
	public int getDistance() {
		return distance;
	}

	public Region.Name getOppositeRegionName(Region.Name name) {
		// 존재시, 반대 지역 반환
		if (this.hasRegion(name)) {
			if (regions[0].equals(name))
				return regions[1];
			else
				return regions[0];
		}
		return null;   // 없으면 null
	}
	
	
	// 존재여부 확인
	private boolean hasRegion(Region.Name name) {
		if (regions[0].equals(name) || regions[1].equals(name))
			return true;
		return false;
	}
	public Region.Name[] getRegions() {
		return regions;
	}

}
