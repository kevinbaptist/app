package ovh.ladon.minesweeper;

public class TextualRepresentation {
    private Board board;

    public TextualRepresentation(Board board) {
        this.board = board;
        represent();
    }

    public void represent() {
        System.out.print("    ");
        for (int row = 0; row < board.getTotalRows(); row++) {
            System.out.print(row + " ");
        }
        System.out.println();
        System.out.print("    ");
        for (int row = 0; row < board.getTotalRows(); row++) {
            System.out.print("| ");
        }
        System.out.println();
        for (int column = 0; column < board.getTotalColumns(); column++) {
            System.out.print(column + " - ");

            for (int row = 0; row < board.getTotalRows(); row++) {
                Cell cell = board.getCell(column, row);
                represent(cell);
            }
            System.out.println();
        }
    }

    private void represent(Cell cell) {
        switch (cell.getState()) {
            case BLANK:
                System.out.print("X ");
                break;
            case ZERO:
            case ONE:
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
                System.out.print(cell.getState().ordinal() + " ");
                break;
            case EXPLOSION:
                System.out.print("* ");
                break;
        }
    }
}
