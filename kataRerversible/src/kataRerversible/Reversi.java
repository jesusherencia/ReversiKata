package kataRerversible;

import org.omg.CORBA.StringValueHelper;

public class Reversi {
	char[][] grid;
	char beyondEdge;
	int width, height;
	char currentPlayer;
	char possibleMove;
	char vacant;
	char white, black;

	public Reversi(String[] input) {
		vacant = '.';
		possibleMove = 'O';
		beyondEdge = 'X';
		white = 'W';
		black = 'B';
		loadGrid(input);
		trouverPositionPlayer();
	}

	public void loadGrid(String[] input) {
		this.height = input.length - 1;
		this.width = input[0].length();
		grid = new char[height][width];
		this.currentPlayer = input[input.length - 1].toCharArray()[0];
		for (int i = 1; i <= height; i++) {
			this.grid[i - 1] = input[i - 1].toCharArray();
		}
	}

	public void trouverPositionsSolution(int x, int y) {
		if (isAvailable(x - 1, y - 1) && caMarche(x, y, x - 1, y - 1)) {
			setMarque(x - 1, y - 1);
		}
		if (isAvailable(x - 1, y) && caMarche(x, y, x - 1, y)) {
			setMarque(x - 1, y);
		}
		if (isAvailable(x - 1, y + 1) && caMarche(x, y, x - 1, y + 1)) {
			setMarque(x - 1, y + 1);
		}
		if (isAvailable(x, y - 1) && caMarche(x, y, x, y - 1)) {
			setMarque(x, y - 1);
		}
		if (isAvailable(x, y + 1) && caMarche(x, y, x, y + 1)) {
			setMarque(x, y + 1);
		}
		if (isAvailable(x + 1, y - 1) && caMarche(x, y, x + 1, y - 1)) {
			setMarque(x + 1, y - 1);
		}
		if (isAvailable(x + 1, y) && caMarche(x, y, x + 1, y)) {
			setMarque(x + 1, y);
		}
		if (isAvailable(x - 1, y - 1) && caMarche(x, y, x + 1, y + 1)) {
			setMarque(x + 1, y + 1);
		}

	}

	public boolean caMarche(int a, int b, int x, int y) {
		int x1 = 2 * a - x;
		int y1 = 2 * b - y;
		if (grid[x1][y1] == this.currentPlayer) {
			return true;
		}
		return false;
	}

	public void trouverPositionPlayer() {
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if (grid[i - 1][j - 1] == joueurContraire()) {
					trouverPositionsSolution(i - 1, j - 1);
				}
			}
		}

	}

	private char joueurContraire() {
		if (this.currentPlayer == 'B')
			return 'W';
		if (this.currentPlayer == 'W')
			return 'B';
		return '.';
	}

	public String[] afficherResultat() {

		String[] result = new String[height + 1];
		int i = 0;
		for (i = 1; i <= height; i++) {
			result[i - 1] = String.copyValueOf(this.grid[i - 1]);
			System.out.println(result[i - 1]);
		}
		result[this.height] = String.valueOf(this.currentPlayer);
		return result;

	}
	
	// Methodes outiles
	public boolean isAvailable(int x, int y) {
		try {
			if (grid[x][y] == '.')
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setMarque(int x, int y) {
		grid[x][y] = 'O';

	}

}
