package questForMtDoom.game;

public abstract class DefaultSquare implements Square {
	private int position;
	private String[] stories;

	public DefaultSquare(int position) {
		this.position = position;
		stories = initStories();
	}

	public int getPosition() {
		return position;
	}
	
	public String[] getStories() {
		return stories;
	}

	public String[] initStories() {
		return new String[] {"Square " + this.position + " has no history! How sad...",
				"This is where a story had been presented, but \n"
				+ "square " + this.position + " just wasn't that interesting",
				"You arrive at... in a... it's... just square " + this.position + "?"};
	}

	@Override
	public void moveHere(Player p) {
		p.setPosition(this.position);
		System.out.println(stories[(int) (Math.random()*stories.length)]);
	}

	@Override
	public int compareTo(Square o) {
		return this.position - ((DefaultSquare) o).getPosition();
	}

}
