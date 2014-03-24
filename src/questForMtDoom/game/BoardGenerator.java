package questForMtDoom.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardGenerator {
	private List<Square> board;
	private int size;

	public BoardGenerator(int size) {
		this.size = size;
		board = generateBoard(board, size);
	}
	
	public int getSize() {
		return size;
	}
	
	public void movePlayer(int newPosition, Player p){
		board.get(newPosition).moveHere(p);
	}

	/**
	 * 
	 * @param size
	 * @return List of board
	 * 
	 * This method creates the board. It randomises each and every square
	 * and then it adds the regions. Regions are always FOREST at start
	 * and LAVA in the end, with random regions in the middle.
	 */

	public static List<Square> generateBoard(List<Square> board, int size){
		/*
		 * Init and declare all required lists to generate positions,
		 * regions and later sorting positions in correct order.
		 */
		board = new ArrayList<Square>();
		List<Integer> position = new ArrayList<Integer>();
		List<Region> regions = new ArrayList<Region>();
		List<Region> regionOrder = regionList(5);
		
		/*
		 * This is where the randomised regionOrder is used to create a list as 
		 * large as the board itself with all the regions. In the same loop,
		 * positions are being saved in a positions array.
		 */
		for (Region r: regionOrder)
			for (int a = 0; a < size/regionOrder.size(); a++){
				regions.add(r);
				position.add(position.size());
			}
		
		// to make room for the home square, position 0 is removed.
		position.remove(0);
		
		// this will now make a list of 99 unique numbers in a random order
		Collections.shuffle(position);
		
		/*
		 * As if the random position order wasn't enough, the order the squares
		 * are added is random too. Now random squares are added up with
		 * random positions. Square 0 is reserved for the home square.
		 */
		board.add(new HomeSquare(0)); 
		for(int p : position) {
			board.add((Math.random()<0.1) ? 
					new ResetSquare(p) : new MobSquare(p));
			//board.add(new HomeSquare(p));
		}
		
		// Now the entire board is sorted by square positions.
		Collections.sort(board);
		
		//write("Board size: " + board.size());
		//write(" Regions size: " + regions.size() + "\n\n");
		
		/*
		 * This is where the regions are added to the list. The entire board
		 * runs though the regions list, adding one region at a time.
		 */
		for(Square d: board){
			d.setRegion(regions.get(0));
			regions.remove(0);
		}
		
		return board;
	}
	
	/**
	 * 
	 * @param amountRegions
	 * @return random sorted region list
	 * 
	 * The regionList generates a list with as many regions as the method int 
	 * is set to. The method mixes up all available regions from the Region
	 * enum and cuts down the list to match the size.
	 * The unique thing with this method is that it ensures the first Region is
	 * FOREST and the last Region is LAVA, with the middle Regions being mixed.
	 */
	public static List<Region> regionList(int amountRegions) {
		List<Region> regionOrder = new ArrayList<Region>();
		// Get all regions except FOREST and LAVA
		for (Region r: Region.values())
			if(r != Region.FOREST && r != Region.LAVA)
				regionOrder.add(r);
		
		Collections.shuffle(regionOrder);
		
		while(regionOrder.size() > amountRegions-2)
			regionOrder.remove(0);
		// Add start region
		regionOrder.add(0, Region.FOREST);
		// Add end region
		regionOrder.add(Region.LAVA);
		return regionOrder;
	}
}
