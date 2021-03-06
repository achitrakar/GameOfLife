package com.sample.gameoflife.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.sample.gameoflife.model.GameOfLifeModel;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = -8035892195317835189L;

	private GameOfLifeModel model;

	public GridPanel(GameOfLifeModel model) {
		this.model = model;
		this.setPreferredSize(model.getPreferredSize());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		model.draw(g);
	}
}