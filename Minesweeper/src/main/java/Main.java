import ovh.ladon.minesweeper.Board;
import ovh.ladon.minesweeper.TextualRepresentation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(5, 5, 4);
		TextualRepresentation textualRepresentation = new TextualRepresentation(board);
		do {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.print("Position (example: 3,4): ");
			try {
				String read = br.readLine();
				String[] partes = read.split(",");
				int row = Integer.parseInt(partes[0]);
				int column = Integer.parseInt(partes[1]);

				board.revealCell(column, row);
				textualRepresentation.represent();

			}catch (Exception ex){
				System.out.println("Something went wrong");
			}
		}while (!board.hasGameFinished());

		if (board.hasLost()) {
			System.out.println("You lose");
		} else {
			System.out.println("Congratulations! You have won!!!");
		}
	}
}
