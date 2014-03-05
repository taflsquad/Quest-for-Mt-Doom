package questForMtDoom;

public abstract class DefaultSquare implements Square {
	private int position;

	public DefaultSquare(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public int compareTo(Square o) {
		return this.position - ((DefaultSquare) o).getPosition();
	}

}
