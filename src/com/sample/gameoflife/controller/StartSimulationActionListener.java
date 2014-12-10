package com.sample.gameoflife.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.sample.gameoflife.model.GameOfLifeModel;
import com.sample.gameoflife.view.GameOfLifeFrame;

public class StartSimulationActionListener implements ActionListener {

	private GameOfLifeFrame frame;

	private GameOfLifeModel model;

	private RunSimulation runSimulation;

	public StartSimulationActionListener(GameOfLifeFrame frame, GameOfLifeModel model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		runSimulation = new RunSimulation();
		new Thread(runSimulation).start();
		frame.getControlPanel().getStartButton().setEnabled(false);
		frame.getControlPanel().getStopButton().setEnabled(true);
		frame.getControlPanel().getComboBox().setEnabled(false);
		frame.getControlPanel().getClearButton().setEnabled(false);
	}

	public void stopSimulation() {
		runSimulation.stopRunning();
		runSimulation = null;
	}

	class RunSimulation implements Runnable {

		private volatile boolean running;

		@Override
		public void run() {
			this.running = true;
			while (running) {
				sleep();
				model.update();
				repaint();
			}
		}

		private void repaint() {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setGenerationTextField();
					frame.repaintGridPanel();
				}
			});
		}

		private void sleep() {
			try {
				Thread.sleep(model.getGenerationDelay());
			} catch (InterruptedException e) {
			}
		}

		public synchronized void stopRunning() {
			this.running = false;
		}

	}

}