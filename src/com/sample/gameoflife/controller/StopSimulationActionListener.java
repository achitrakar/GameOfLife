package com.sample.gameoflife.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sample.gameoflife.view.GameOfLifeFrame;

public class StopSimulationActionListener implements ActionListener {

	private GameOfLifeFrame frame;

	private StartSimulationActionListener listener;

	public StopSimulationActionListener(GameOfLifeFrame frame) {
		this.frame = frame;
	}

	public void setListener(StartSimulationActionListener listener) {
		this.listener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		listener.stopSimulation();

		frame.getControlPanel().getStopButton().setEnabled(false);
		frame.getControlPanel().getClearButton().setEnabled(true);
	}

}