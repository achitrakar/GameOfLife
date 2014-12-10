package com.sample.gameoflife.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GameOfLifeModel {
	private static final int GRID_WIDTH = 75;
	private static final int CELL_WIDTH = 6;

	private int[][] board;

	private volatile long generationCount;
	private volatile long generationDelay;

	public GameOfLifeModel() {
		this.board = new int[GRID_WIDTH + 2][GRID_WIDTH + 2];
		this.generationDelay = 100L;
		clearGrid();
	}

	public void clearGrid() {
		this.generationCount = 0;
		for (int i = 0; i < GRID_WIDTH + 2; i++) {
			for (int j = 0; j < GRID_WIDTH + 2; j++) {
				resetCell(i, j);
			}
		}
	}

	public void setCell(int i, int j) {
		board[i][j] = 1;
	}

	public void resetCell(int i, int j) {
		board[i][j] = 0;
	}

	public void update() {
		this.generationCount++;
		int[][] newBoard = new int[GRID_WIDTH + 2][GRID_WIDTH + 2];
		for (int row = 1; row <= GRID_WIDTH; row++) {
			for (int col = 1; col <= GRID_WIDTH; col++) {
				switch (countNeighbours(row, col)) {
				case 2:
					newBoard[row][col] = board[row][col]; // Status remain same
					break;
				case 3:
					newBoard[row][col] = 1; // cell is alive
					break;
				default:
					newBoard[row][col] = 0; // cell is dead
					break;
				}
			}
		}

		for (int row = 1; row <= GRID_WIDTH; row++) {
			for (int col = 1; col <= GRID_WIDTH; col++) {
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

	public Dimension getPreferredSize() {
		int x = (GRID_WIDTH * (CELL_WIDTH + 1)) + 1;
		return new Dimension(x, x);
	}

	public int getGridWidth() {
		return GRID_WIDTH;
	}

	public long getGenerationCount() {
		return generationCount;
	}

	public long getGenerationDelay() {
		return generationDelay;
	}

	public synchronized void setGenerationDelay(long generationDelay) {
		this.generationDelay = generationDelay;
	}

	public void draw(Graphics g) {
		int x = 1;
		for (int i = 1; i <= GRID_WIDTH; i++) {
			int y = 1;
			for (int j = 1; j <= GRID_WIDTH; j++) {
				drawGridLines(g, x, i, y, j);
				drawCell(g, x, i, y, j);
				y += CELL_WIDTH + 1;
			}
			x += CELL_WIDTH + 1;
		}
	}

	private void drawGridLines(Graphics g, int x, int i, int y, int j) {
		g.setColor(Color.WHITE);
		if (i == 1) {
			g.drawLine(0, y - 1, 0, y + CELL_WIDTH - 1);
		}
		if (j == 1) {
			g.drawLine(x - 1, 0, x + CELL_WIDTH - 1, 0);
		}
		g.drawLine(x, y + CELL_WIDTH, x + CELL_WIDTH, y + CELL_WIDTH);
		g.drawLine(x + CELL_WIDTH, y, x + CELL_WIDTH, y + CELL_WIDTH);
	}

	private void drawCell(Graphics g, int x, int i, int y, int j) {
		if (board[i][j] == 1) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, CELL_WIDTH, CELL_WIDTH);
		}
	}
}
