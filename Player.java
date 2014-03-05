package questForMtDoom;

public abstract class Player implements Character {
	private String name;
	private int position;
	private Dice dice;

	public Player(String name) {
		this.name = name;
		position = 0;
	}

	@Override
	public int roll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
