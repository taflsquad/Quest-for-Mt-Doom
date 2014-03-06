package questForMtDoom;

public abstract class MobCharacter implements Character {
	
	private String name;
	private String theme;
	private int level;
	private Dice dice;
	 
	
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
	
	//Konstruktør//
	public MobCharacter() {
		
	}

	
	@Override
	public int roll() {
		
		return 0;
	}

}
