package questForMtDoom.game;

public enum Region {
	
	FOREST(1),
	DESERT(2),
	ARCTIC(3),
	HAUNTED(4),
	TUNDRA(5),
	JUNGLE(6),
	LAVA(7);
	
	private final int regionID;

	private Region(int regionID) {
		this.regionID = regionID;
	}

	public int getRegionID() {
		return regionID;
	}

}
