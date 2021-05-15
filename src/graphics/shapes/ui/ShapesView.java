package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import graphics.ui.View;
import graphics.ui.Controller;
import graphics.shapes.SRectangle;
import graphics.shapes.SCollection;
import graphics.shapes.ui.ShapesController;

import graphics.shapes.ui.ShapeDraftman;


public class ShapesView extends View
{
	
	private ShapeDraftman draftman;
	public ShapesView(Object model) {
		super(model);
		this.draftman = new ShapeDraftman();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Object model = this.getModel();
		if (model==null) return;
		
		this.draftman.setGraphics((Graphics2D)g);
		
		SCollection nRect = (SCollection) model;
		nRect.accept(this.draftman);
		
		
	}
	
	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}
}
