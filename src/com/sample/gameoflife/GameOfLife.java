package com.sample.gameoflife;

import javax.swing.SwingUtilities;

import com.sample.gameoflife.model.GameOfLifeModel;
import com.sample.gameoflife.view.GameOfLifeFrame;

public class GameOfLife implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GameOfLife());
	}

	@Override
	public void run() {
		new GameOfLifeFrame(new GameOfLifeModel());
	}

}
