
  package questForMtDoom.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static void write(String s) {
		System.out.print(s);
	}
	
	public static void write(int n) {
		System.out.print(n);
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
	public static List<DefaultSquare> generateBoard(int size) {
		/*
		 * Init and declare all required lists to generate positions,
		 * regions and later sorting positions in correct order.
		 */
		List<DefaultSquare> board = new ArrayList<DefaultSquare>();
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
		for(DefaultSquare d: board){
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

	public static List<Player> fetchPlayers(Scanner in) {
		List<Player> players = new ArrayList<Player>();
		write("Welcome bold heroes, the quest that \nlies before you"
				+ "will be full of dangers.\n");
		write("Tell me, what are your names? [Ex. Joe Sue Xaviera]\n");
		String[] names = in.nextLine().split(" ");
		for (int i = 0; i<names.length;i++) {
			/*
			 * All players are Warriors until further notice.
			 */
			players.add(new Human(names[i], "Warrior")); 
		}
		return players;
	}
	
	public static String action(Scanner in){
		return in.nextLine();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<Player> players = fetchPlayers(in);	// generate players
		// OBS! Board size must be at least 60 and divisible by 20
		List<DefaultSquare> board = generateBoard(100);	// generate board
		
		int move, dice, turn;
		move = dice = turn = 0;
		String action = "";
		
		/*
		 * Initiate gameplay loop. Main loop that checks for win.
		 */
		do {
			
			write("\n\n" + players.get(turn).getName() + "'s turn. You are "
					+ "currently at square " + players.get(turn).getPosition() 
					+ "\nPress <ENTER>" + " to roll dice.\n");
			try {
				action = action(in);
			} catch (Exception e) {
				write("Shutting down...\n");
			}
			if (action.isEmpty()) {
				dice = players.get(turn).roll();
				move = dice + players.get(turn).getPosition();
				write(players.get(turn).getName() + " rolled " + dice + ".\n");
				
				if (move < board.size()) {
					write(players.get(turn).getName() + " sets off to towards"
							+ " square " + move + ".\n");
					board.get(move).moveHere(players.get(turn));
					turn = (turn<(players.size()-1)) ? ++turn : 0;
				}
			}
			
			
		} while (move < board.size());
		
		write(players.get(turn).getName() + " has reached Mt. Doom and slayed"
				+ " the beast!");

		in.close();
	}

}
