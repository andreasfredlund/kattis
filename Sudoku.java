import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Sudoku {

	private int sudoku[][];
	private int count; // kanske går att räkna olika unika lösningar

	public Sudoku(int sudoku[][]) {
		this.sudoku = sudoku;
		this.count = count;
	}

	/*
	 * Checks if the Sudoku is valid and if there are multiple solutions
	 */
	private boolean validPuzzle() {

		int countDigits = 0;
		boolean initial = true;
		for (int l = 0; l < 9; l++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[l][j] != 0) {
					countDigits++;
					if (!validNumber(l, j, sudoku[l][j])) {
						initial = false;
					}
				}
			}
		}

		if (!initial) {
			System.out.println("Find another job");
			return false;
		} else if (countDigits < 17) { // Its proven that a sudoku with <17 known number has multiple solutions.
			System.out.println("Non-unique");
			return false;
		} else {
			return true;
		}
	}

	/*
	 * method that tries to solve the sudoku with the backTrack method
	 */
	private void solvePuzzle() {

		if (validPuzzle()) {

			boolean isSolved = backTrack();
			// System.out.println(count);

			if (!isSolved) {
				System.out.println("Find another job");
			}

			else {
				System.out.println(count);
				for (int l = 0; l < 9; l++) {
					for (int j = 0; j < 9; j++) {
						if (j == 8) {
							System.out.println(sudoku[l][j]);
						} else {
							System.out.print(sudoku[l][j] + " ");
						}
					}
				}
			}
		}
	}

	private boolean backTrack() {
	
		boolean isZeros = false;
		int row = 0;
		int col = 0;

		for (int l = 0; l < 9 && !isZeros; l++) { // row
			for (int j = 0; j < 9 && !isZeros; j++) { // column
				if (sudoku[l][j] == 0) {
					isZeros = true;
					row = l; // we found a zero - saves the indices
					col = j;
				}
			}
		}

		if (!isZeros) { // if there are no zeros left
			count++;
			// här jag ska köra en till rekursion som kollar alternativa lösningar.
			/*
			 if (backTrack(number+1))
			 */
			return true;
		}

		/*
		boolean first = true;
		if (!first) {
			number = 1;
		}
		*/
		for (int m = 0; m < 2; m++) {
		
		for (int n = 1; n <= 9; n++) {
			
			if (validNumber(row, col, n)) {
				sudoku[row][col] = n;
				
		
				if (backTrack()) { // the recursion

					return true; // vill fortsätta loopa och kolla om det finns andra lösningar.
				}
				sudoku[row][col] = 0;
			}
		}
		}

		return false;
	}

	/*
	 * method that checks if an inserted number is following the rules
	 */
	private boolean validNumber(int j, int i, int n) {
		int k;
		for (k = 0; k < 9; k++) {
			if (sudoku[j][k] == n && i != k) { // checks row
				return false;
			}
			if (sudoku[k][i] == n && j != k) { // checks column
				return false;
			}
		}

		int row = j / 3 * 3;
		int col = i / 3 * 3;

		for (k = row; k < (row + 3); k++) { // checks box;
			for (int c = col; c < (col + 3); c++) {
				if (sudoku[k][c] == n && k != i && k != j) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new File("textfil.txt"));
		// Scanner scan = new Scanner(System.in);
		while (scan.hasNextInt()) {
			int[][] table = new int[9][9];

			for (int k = 0; k < 9; k++) {
				for (int i = 0; i < 9; i++) {
					table[k][i] = scan.nextInt();
				}
			}

			new Sudoku(table).solvePuzzle();
			System.out.println();
		}
		scan.close();
	}
}
