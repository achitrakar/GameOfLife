package com.sample.gameoflife.controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sample.gameoflife.model.GameOfLifeModel;

public class GenerationDelayChangeListener implements ChangeListener {

	private GameOfLifeModel model;

	public GenerationDelayChangeListener(GameOfLifeModel model) {
		this.model = model;
	}

	@Override
	public void stateChanged(ChangeEvent event) {
		JSlider source = (JSlider) event.getSource();
		if (!source.getValueIsAdjusting()) {
			model.setGenerationDelay(100L * source.getValue());
		}
	}

}