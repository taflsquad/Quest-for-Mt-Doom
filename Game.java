package questForMtDoom;

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
			/*
			if (Collections.frequency(daBoard, new DefaultSquare(0)) < 0.6*size)
				daBoard.add(new DefaultSquare(p));
			*/
		}
		
		Collections.sort(board);
		
		return board;
	}
	
	public static String action(Scanner in){
		return in.nextLine();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Human player = new Human("Bjarne");

		List<DefaultSquare> board = generateBoard(20);
		
		int move, dice;
		move = dice = 0;
		
		do {
			
			write(player.getName() + "'s turn. Press <ENTER> to roll dice.\n");
			try {action(in);} catch (Exception e) {
				write("Shutting down...\n");
			}
			dice = player.roll();
			move = dice + player.getPosition();
			write(player.getName() + " rolled " + dice + ".\n");
			
			if (move < board.size()) {
				write(player.getName() + " sets off to towards square " + move + ".\n");
				board.get(move).moveHere(player);
			}
				
			
		} while (move < board.size());
		
		write(player.getName() + " has reached Mt. Doom and slayed the beast!");

		in.close();
	}

}
