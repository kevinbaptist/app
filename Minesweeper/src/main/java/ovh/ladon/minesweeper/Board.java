package ovh.ladon.minesweeper;

import ovh.ladon.minesweeper.exception.InvalidCellBoardException;

public class Board {
	private Cell[][] grid;

	public Board(int totalColumns, int totalRows) {
		if (totalColumns <= 0 || totalRows <= 0) {
			throw new InvalidCellBoardException("Rows and columns must be a > 0");
		}

		this.grid = new Cell[totalRows][totalColumns];

		this.fillBoard();
	}

	public Cell getCell(Position position) {
		return null;
	}

	public Cell getCell(int column, int row) {
		if (!isValidRow(row) || !isValidColumn(column)) {
			throw new InvalidCellBoardException("Trying to access an invalid cell");
		}
		return grid[row][column];
	}

	public int getTotalColumns() {
		return this.grid[0].length;
	}

	public int getTotalRows() {
		return this.grid.length;
	}

	private boolean isValidRow(int row) {
		return row >= 0 && row < getTotalRows();
	}

	private boolean isValidColumn(int column) {
		return column >= 0 && column < getTotalColumns();
	}

	private void fillBoard() {
		for (int column = 0; column < getTotalColumns(); column++) {
			for (int row = 0; row < getTotalRows(); row++) {
				this.grid[row][column] = new Cell(column, row);
			}
		}
	}
}
