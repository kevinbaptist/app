package ovh.ladon.minesweeper;

import ovh.ladon.minesweeper.exception.InvalidCellBoardException;

import java.util.Random;

public class Board {
    private Cell[][] grid;
    private int totalMines;
    private Random generate;
    private boolean firstMove;

    public Board(int totalColumns, int totalRows, int totalMines) {
        if (totalColumns <= 0 || totalRows <= 0 || totalMines <= 0) {
            throw new InvalidCellBoardException("Rows, columns and total mines must be a > 0");
        }
        if (totalColumns * totalRows <= totalMines) {
            throw new InvalidCellBoardException("There are too many mines for the board! Maximum allowed: " + (totalColumns * totalRows - 1));
        }
        this.totalMines = totalMines;
        this.generate = new Random();
        this.firstMove = true;
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

    public boolean hasMine(int column, int row) {
        return getCell(column, row).hasMine();
    }

    public State getState(int column, int row) {
        return getCell(column, row).getState();
    }

    /**
     * Mines are set after user has selected first cell, therefore the first move will never trigger a mine.
     *
     * @param exceptColumn column triggered by user
     * @param exceptRow    row triggered by user
     */
    public void putMines(int exceptColumn, int exceptRow) {
        for (int i = 0; i < totalMines; i++) {
            int column = 0;
            int row = 0;
            do {
                column = generate.nextInt(getTotalColumns());
                row = generate.nextInt(getTotalRows());
            } while (hasMine(column, row) || (column == exceptColumn && row == exceptRow));
            getCell(column, row).turnMineOn();
        }
    }

    public void revealCell(int column, int row) {
        Cell cell = getCell(column, row);
        if (cell.isBlank()) {
            if (firstMove) {
                firstMove = false;
                putMines(column, row);
            }
			int minesAround = countMinesAround(column, row);
			cell.changeState(minesAround);
			revealNeighborCell(cell);
        }
    }

    public void revealNeighborCell(Cell cell) {
        for (int x = Math.max(0, cell.getX() - 1); x < Math.min(getTotalColumns(), cell.getX() + 2); x++) {
            for (int y = Math.max(0, cell.getY() - 1); y < Math.min(getTotalRows(), cell.getY() + 2); y++) {
                if (countMinesAround(cell.getX(), cell.getY()) == 0) {
                    revealCell(x, y);
                }
            }
        }
    }

    private int countMinesAround(int column, int row) {
        int count = 0;
        for (int x = Math.max(0, column - 1); x < Math.min(getTotalColumns(), column + 2); x++) {
            for (int y = Math.max(0, row - 1); y < Math.min(getTotalRows(), row + 2); y++) {
				Cell cell = getCell(x, y);
				if (cell.hasMine()) {
					count++;
                }
            }
        }
        return count - (getCell(column, row).hasMine()? 1 : 0);
    }

}
