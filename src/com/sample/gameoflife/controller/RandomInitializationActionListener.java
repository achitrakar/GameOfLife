package com.sample.gameoflife.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.sample.gameoflife.model.GameOfLifeModel;
import com.sample.gameoflife.model.ShapeCollection;
import com.sample.gameoflife.view.GameOfLifeFrame;

public class RandomInitializationActionListener implements ActionListener {

	private GameOfLifeFrame frame;

	private GameOfLifeModel model;

	private Random random;

	final int METHODS_QUANTITY = 10;

	public RandomInitializationActionListener(GameOfLifeFrame frame, GameOfLifeModel model) {
		this.frame = frame;
		this.model = model;
		this.random = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		model.clearGrid();
		frame.getControlPanel().getStartButton().setEnabled(true);
		frame.getControlPanel().getClearButton().setEnabled(true);

		switch (ShapeCollection.getShapeCollection().get(frame.getControlPanel().getComboBox().getSelectedItem())) {
		case "-1":
			model.clearGrid();
			frame.getControlPanel().getStartButton().setEnabled(false);
			frame.getControlPanel().getClearButton().setEnabled(false);
			break;
		case "0":
			model.clearGrid();
			initRandom();
			break;
		case "1":
			model.clearGrid();
			initVirus();
			break;
		case "2":
			model.clearGrid();
			initCheshireCat();
			break;
		case "3":
			model.clearGrid();
			initPentomino();
			break;
		case "4":
			model.clearGrid();
			initShape(ShapeCollection.getTumbler());
			break;
		case "5":
			model.clearGrid();
			initHarverster();
			break;
		case "6":
			model.clearGrid();
			initShape(ShapeCollection.getGlider());
			break;
		case "7":
			model.clearGrid();
			initShape(ShapeCollection.getGliderGun());
			break;
		case "8":
			model.clearGrid();
			initShape(ShapeCollection.getSmallExploder());
			break;
		case "9":
			model.clearGrid();
			initShape(ShapeCollection.getLightweightSpaceship());
			break;
		case "10":
			model.clearGrid();
			initShape(ShapeCollection.getTenCellRow());
			break;
		default:
			model.clearGrid();
			break;
		}
		frame.repaintGridPanel();
	}

	private void initHarverster() {
		int x, y;
		for (x = 70, y = 5; x >= 10 && y <= 70; x--, y++) {
			model.setCell(x, y);
		}

		for (y = 65; y <= 67; y++) {
			for (x = 6; x <= 9; x++) {
				model.setCell(x, y);
			}
		}
		model.resetCell(7, 67);
	}

	private void initRandom() {
		int size = model.getGridWidth();
		int count = size * size / 5;
		for (int k = 1; k <= count; k++) {
			int i = random.nextInt(size);
			int j = random.nextInt(size);
			if (i == 0)
				i = 1;
			if (j == 0)
				j = 1;
			model.setCell(i, j);
		}
	}

	private void initVirus() {
		int xCounter = 0, yCounter = 0;
		for (int x = 10; x < 30; x++) {
			yCounter = 0;
			for (int y = 10; y < 27; y++) {
				if (yCounter < 2) {
					model.setCell(x, y);
					yCounter++;
				} else {
					yCounter = 0;
				}
			}
			if (xCounter < 1) {
				xCounter++;
			} else {
				x++;
				xCounter = 0;
			}
		}
		model.setCell(19, 18); // midpoint of diagonal
	}

	private void initPentomino() {
		model.setCell(50, 50);
		model.setCell(51, 50);
		model.setCell(49, 51);
		model.setCell(50, 51);
		model.setCell(50, 52);
	}

	private void initCheshireCat() {
		model.setCell(50, 50);
		model.setCell(53, 50);

		for (int i = 50; i <= 53; i++) {
			model.setCell(i, 51);
			model.setCell(i, 55);
		}

		model.setCell(51, 53);
		model.setCell(52, 53);

		for (int i = 52; i <= 54; i++) {
			model.setCell(49, i);
			model.setCell(54, i);
		}
	}

	private void initShape(int[][] point) {
		for (int[] is : point) {
			model.setCell(is[0] + 15, is[1] + 15);
		}
	}
}