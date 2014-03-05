package questForMtDoom;

public abstract class DefaultPlayer implements Character {
	private String name;
	private int position;
	private Dice dice;

	public DefaultPlayer(String name) {
		this.name = name;
		position = 0;
	}

	@Override
	public int roll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
