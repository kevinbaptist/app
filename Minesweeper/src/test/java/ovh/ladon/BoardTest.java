package ovh.ladon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ovh.ladon.minesweeper.Board;
import ovh.ladon.minesweeper.Cell;
import ovh.ladon.minesweeper.State;
import ovh.ladon.minesweeper.exception.InvalidCellBoardException;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
	private Board board;
	private final int TOTAL_COLUMNS = 3;
	private final int TOTAL_ROWS = 3;
	private final int TOTAL_MINES = 8;

	@BeforeEach
	void setUp() {
		this.board = new Board(TOTAL_COLUMNS, TOTAL_ROWS, TOTAL_MINES);
	}

	@Test
	void givenCellOutOfBoard_WhenGettingCell_weGetAnException() {
		assertThrows(InvalidCellBoardException.class, ()-> this.board.getCell(11, 11));
	}

	@Test
	void givenInvalidCell_WhenGettingCell_weGetAnException() {
		assertThrows(InvalidCellBoardException.class, ()-> this.board.getCell(-1, -1));
	}

	@Test
	void givenNumberColumn_whenRetrieve_weGetValidColumnNumber() {
		assertEquals(board.getTotalColumns(), TOTAL_COLUMNS);
	}

	@Test
	void givenNumberRow_whenRetrieve_weGetValidRowNumber() {
		assertEquals(board.getTotalRows(), TOTAL_ROWS);
	}

	@Test
	void givenNgeativeNumberOfRows_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(1, -5, 2));
	}

	@Test
	void given0NumberOfRows_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(1, 0, 2));
	}

	@Test
	void givenNgeativeNumberOfColumns_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(-1, 5, 2));
	}

	@Test
	void given0NumberOfColumns_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(0, 10, 2));
	}

	@Test
	void givenNegativeNumberOfMines_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(5, 10, -3));
	}
	@Test
	void givenZeroNumberOfMines_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(5, 10, 0));
	}

	@Test
	void givenInvalidNumberOfMines_whenInstantiateBoard_weGetException() {
		assertThrows(InvalidCellBoardException.class, ()-> new Board(3, 3, 9));
	}

	@Test
	void whenBoardIsIntantiate_thenAllCellsAreBlank() {
		for (int column = 0; column < TOTAL_COLUMNS; column++) {
			for (int row = 0; row < TOTAL_ROWS; row++) {
				final Cell cell = this.board.getCell(column, row);
				assertEquals(cell.getState(), State.BLANK);
			}
		}
	}

	@Test
	void whenUserMakesFirstMove_thenAllMinesAreSetted() {
		this.board.putMines(1, 1);
		for (int column = 0; column < this.board.getTotalColumns(); column++) {
			for (int row = 0; row < this.board.getTotalRows(); row++) {
				if (column == 1 && row == 1) {
					assertFalse(this.board.getCell(column, row).hasMine());
				} else {
					assertTrue(this.board.getCell(column, row).hasMine());
				}
			}
		}
	}

	@Test
	void whenUserMakesMove_thenCellAreRevealed() {
		this.board.revealCell(1, 1);
		for (int column = 0; column < this.board.getTotalColumns(); column++) {
			for (int row = 0; row < this.board.getTotalRows(); row++) {
				if (column == 1 && row == 1) {
					assertFalse(this.board.getCell(column, row).hasMine());
				} else {
					assertTrue(this.board.getCell(column, row).hasMine());
				}
			}
		}
		assertEquals(this.board.getCell(1, 1).getState(), State.EIGHT);
	}
}
