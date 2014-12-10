package com.sample.gameoflife.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sample.gameoflife.model.GameOfLifeModel;
import com.sample.gameoflife.view.GameOfLifeFrame;

public class ClearSimulationActionListener implements ActionListener {

	private GameOfLifeFrame frame;

	private GameOfLifeModel model;

	public ClearSimulationActionListener(GameOfLifeFrame frame, GameOfLifeModel model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		model.clearGrid();
		frame.setGenerationTextField();
		frame.repaintGridPanel();
		frame.getControlPanel().getComboBox().setEnabled(true);
		frame.getControlPanel().getStartButton().setEnabled(false);
		frame.getControlPanel().getClearButton().setEnabled(false);
	}

}