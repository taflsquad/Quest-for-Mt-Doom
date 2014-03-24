package questForMtDoom.game;

public interface Square extends Comparable<Square> {
	public void moveHere(Player p);

	public void setRegion(Region region);
}
