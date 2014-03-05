package questForMtDoom;

public abstract class Player implements Character {
	private String name;
	private int position;
	private Dice dice;

	public Player(String name) {
		this.name = name;
		position = 0;
		dice = new Dice();
	}

	public String getName() {
		return name;
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

	@Override
	public int roll() {
		int value = 0;
		for (int i = 0; i < dice.getRolls(); i++)
			value += (int)(Math.random()*dice.getSides())+1;
		return value;
	}

}
