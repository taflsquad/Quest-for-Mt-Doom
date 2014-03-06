package questForMtDoom.game;

/**
 * 
 * @author Nicolas
 *
 * ResetSquare sends the user back to the initial square. This could either be
 * the initial square or just the initial act square.
 *
 */

public class ResetSquare extends DefaultSquare {

	public ResetSquare(int position) {
		super(position);
	}

	@Override
	public void moveHere(Player p) {
		p.setPosition(0);
		System.out.println(getStories()[(int) (Math.random()*getStories().length)]);
	}

	@Override
	public String[] initStories() {
		return new String[] {"Your home gem malfunctioned and accidently"
				+ " teleported you back to your last visited tavern."};
	}

}
