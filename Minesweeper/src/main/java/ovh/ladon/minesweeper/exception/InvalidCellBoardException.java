package ovh.ladon.minesweeper.exception;

public class InvalidCellBoardException extends RuntimeException {
	public InvalidCellBoardException() {
	}

	public InvalidCellBoardException(String message) {
		super(message);
	}
}
