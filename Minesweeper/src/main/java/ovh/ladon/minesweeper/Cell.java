package ovh.ladon.minesweeper;

public class Cell {
	private Position position;
	private State state;
	private boolean hasMine;

	public Cell(int column, int row) {
		this.position = new Position(column, row);
		hasMine = false;
		state = State.BLANK;
	}

	public Position getPosition() {
		return position;
	}

	public int getX() {
		return position.getColumn();
	}

	public int getY() {
		return position.getRow();
	}

	public State getState() {
		return state;
	}

	public boolean hasMine() {
		return hasMine;
	}

	public void turnMineOn() {
		this.hasMine = true;
	}

	public boolean isBlank() {
		return this.state == State.BLANK;
	}

	public void changeState(int minesAround) {
		this.state = State.valueOf(minesAround);
	}
}
