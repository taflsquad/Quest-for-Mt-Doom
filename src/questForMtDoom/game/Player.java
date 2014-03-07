package questForMtDoom.game;

public abstract class Player implements Character {
	private String name;
	private String classType;
	private int position;
	private Dice dice;
	private int lastTavern;

	public Player(String name, String classType) {
		this.name = name;
		this.classType = classType;
		position = 0;
		dice = new Dice();
	}

	public String getName() {
		return name;
	}

	public String getClassType() {
		return classType;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Dice getDice() {
		return dice;
	}

	public int getLastTavern() {
		return lastTavern;
	}

	public void setLastTavern(int lastSafeHouse) {
		this.lastTavern = lastSafeHouse;
	}

	@Override
	public int roll() {
		int value = 0;
		for (int i = 0; i < dice.getRolls(); i++)
			value += (int)(Math.random()*dice.getSides())+1;
		return value;
	}

}
