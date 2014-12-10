package com.sample.gameoflife;

public class Life {
	private final int MAXROW = 5;
	private final int MAXCOL = 10;
	int[][] board = new int[MAXROW + 2][MAXCOL + 2];

	public Life() {
		for (int i = 0; i < MAXROW + 2; i++) {
			for (int j = 0; j < MAXCOL + 2; j++) {
				board[i][j] = 0;
			}
		}
	}

	public void initialize() {
		System.out.println("Initialized");
		// TODO: User should input the coordinates of living cells
		// before the execution of the algorithm
		board = new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 }, 
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 ,0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 ,0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 }
		};
	}

	public void print() {
		for (int i = 1; i <= MAXROW; i++) {
			for (int j = 1; j <= MAXCOL; j++) {
				if (board[i][j] == 1) {
					System.out.print("* ");
				} else {
					System.out.print(" ");
				}
				//System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public void update() {
		int[][] newBoard = new int[MAXROW + 2][MAXCOL + 2];
		for(int row = 1 ; row <= MAXROW ; row++){
			for(int col = 1 ; col <= MAXCOL ; col++){
				switch (countNeighbours(row, col)) {
				case 2:
					newBoard[row][col] = board[row][col];	//Status remain same
					break;
				case 3: 
					newBoard[row][col] = 1; //cell is alive
					break;
				default:
					newBoard[row][col] = 0;	//cell is dead
					break;
				}
			}
		}
		
		for(int row = 1 ; row <= MAXROW ; row++){
			for(int col = 1 ; col <= MAXCOL ; col++){
				board[row][col] = newBoard[row][col];
			}
		}
	}

	private int countNeighbours(int row, int col) {
		int count = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				count += board[i][j]; // Increase count if neighbor is alive.
			}
		}
		count -= board[row][col]; // Cell is not it's own neighbor

		return count;
	}
}
