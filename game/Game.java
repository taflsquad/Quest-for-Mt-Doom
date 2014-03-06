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

	public static List<DefaultSquare> generateBoard(int size) {

		List<DefaultSquare> board = new ArrayList<DefaultSquare>();
		List<Integer> position = new ArrayList<Integer>();
		
		for (int i = 1; i < size; i++)
			position.add(i);
		
		Collections.shuffle(position);
		
		board.add(new HomeSquare(0)); 
		for(int p : position) {
			board.add(new EmptySquare(p));
		}
		
		Collections.sort(board);
		
		return board;
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
		List<DefaultSquare> board = generateBoard(40);	// generate board
		
		int move, dice, turn;
		move = dice = turn = 0;
		String action = "";
		
		/*
		 * Initiate gameplay loop. Main loop that checks for win.
		 */
		do {
			
			write("\n\n" + players.get(turn).getName() + "'s turn. Press <ENTER>"
					+ " to roll dice.\n");
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
