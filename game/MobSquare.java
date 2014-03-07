package questForMtDoom.game;

import java.util.Scanner;

public class MobSquare extends DefaultSquare {

	public static MobCharacter GenerateCreep(){
		int levelGenerate = (int) (Math.random() * 2 + 1);
		int typeGenerate = (int) (Math.random() * 5);
		
		String typeName[] = {"Goblin","Orc","Elf","Spider","Dire Wolf"};
		String typePick = typeName[typeGenerate];
		
		MobCharacter creep = new MobCharacter(typePick, levelGenerate); 
		return creep;
		
	}
	
	@Override
	public String[] initStories() {
		
		return new String[] {"SI","SD"};
	}

	public MobSquare(int position) {
		super(position);
	}

	@Override
	public void moveHere(Player p) {
		
		
			 
		
		Scanner inn = new Scanner(System.in);
		super.moveHere(p);
		MobCharacter creep = GenerateCreep();

		System.out.println(p.getName() + " reached square "	+ this.getPosition());
		System.out.println("A wild " + creep.getName() + " appeard!");
		System.out.println(creep.getName() + " Level: " + creep.getLevel());
		int creepPoint = 0;
		int playerPoint = 0;
		
		while (creepPoint != 3 && playerPoint != 3){
			System.out.println("--------------------------");
			System.out.println("Press enter to attack or space to cast spell");
			String input = inn.nextLine();
				
				if (input.isEmpty()){
					int playerRoll = p.roll();
					int creepRoll = ((int) (Math.random()*6+1)*creep.getLevel());
					System.out.println(p.getName() + " rolled: " + playerRoll);
					System.out.println("The " + creep.getName() + " rolled: " + creepRoll);
						if (playerRoll > creepRoll){
							System.out.println("\n" + "You striked the " + creep.getName() + " !");
							playerPoint = playerPoint + 1;
						}else if (creepRoll >= playerRoll){
							System.out.println("\n" + "The " + creep.getName() + " attacked you!");
							creepPoint = creepPoint + 1;
						}
					
				}
			
			
			
		}
		if (playerPoint == 3){
			System.out.println(p.getName() + " are the victor!");
		}else{
			System.out.println("You lost the fight");
		}
		
	}

}
