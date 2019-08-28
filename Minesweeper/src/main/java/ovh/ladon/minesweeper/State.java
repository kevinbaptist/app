package ovh.ladon.minesweeper;

public enum State {
	ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, DOUBT, EXPLOSION, BLANK;

	public static State valueOf(int number) {
		if (number > 8) {
			throw new IllegalArgumentException("Invalid number of mines");
		}
		return State.values()[number];
	}
}
