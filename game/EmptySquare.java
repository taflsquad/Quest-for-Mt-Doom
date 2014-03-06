package questForMtDoom.game;

public class EmptySquare extends DefaultSquare {

	public EmptySquare(int position) {
		super(position);
	}

	@Override
	public void moveHere(Player p) {
		super.moveHere(p);

		System.out.println(p.getName() + " reached square "	+ this.getPosition()
				+ " safely.");
	}

}
