package questForMtDoom.game;

public class MobCharacter{
	
	private String name;
	private String theme;
	private int level;
	private Dice dice;
	 
	//Constructor//
		public MobCharacter(String name, int level) {
			this.name = name;
			theme = "";
			this.level = level;
			dice = new Dice();
		}
	
	//Getters and setters ------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	//---------------------------------------
	
	

	

}
