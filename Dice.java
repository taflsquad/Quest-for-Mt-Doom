package questForMtDoom;

public class Dice {
	private int rolls;
	private int sides;
	
	/**
	 * Standard constructor for Dice will give two dice with 6 sides each
	 */
	public Dice() {
		this.rolls = 2;
		this.sides = 6;
	}

	public int getRolls() {
		return rolls;
	}

	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
}
