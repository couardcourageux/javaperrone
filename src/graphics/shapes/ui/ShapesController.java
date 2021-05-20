package graphics.shapes.ui;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import graphics.shapes.SText;
import graphics.ui.Controller;
import graphics.shapes.SCollection;
import graphics.shapes.SPolygon;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.DrawableAttribute;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.View;

import javax.swing.*;

public class ShapesController extends Controller{
	private SCollection model;
	private Point lastPositionMouse;
	private boolean drawPoly = false;
	private SPolygon polyInProgress;

	public final static String LABEL_ENTER_SCALE_FACTOR = "Salut toi";


	public ShapesController(Object model) {
		super(model);
		this.model = (SCollection) model;
		}
	
	public Shape getElementClicked(Point p) {
		Iterator<Shape> iterator = this.model.iterator();
        while (iterator.hasNext()) {
            Shape s = iterator.next();
            if (s.getBounds().contains(p)) {
                return s;
            }
        }
        return null;
	}
	
	public SCollection getSelection() {
		SCollection selection = new SCollection();
		Iterator<Shape> iterator = this.model.iterator();
        while (iterator.hasNext()) {
        	Shape s = iterator.next();
        	SelectionAttributes selectAtt = (SelectionAttributes)s.getAttributes("SELECTION");
        	if (selectAtt != null) {
        		if (selectAtt.isSelected()) {
        			selection.add(s);
        		}
        	}
            
        }
        return selection;
	}
		
	public void startDrawing() {
		drawPoly = true;
		polyInProgress = new SPolygon();
	}
	public void unselectOthers(Shape selected){
		Iterator<Shape> iterator = this.model.iterator();
        while (iterator.hasNext()) {
            Shape s = iterator.next();
            SelectionAttributes selectAtt = (SelectionAttributes)s.getAttributes("SELECTION");
            if (selectAtt != null) {
	            if (s == selected) {
	                selectAtt.select();
	            } else {
	            	selectAtt.unselect();
	            }
            }
        }
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point mousePosition = e.getPoint();
		if(!drawPoly) {
			Shape clickedShape = getElementClicked(mousePosition);
	
			if(!e.isShiftDown())
				unselectOthers(clickedShape);
			else if (clickedShape != null) {
				SelectionAttributes sa = (SelectionAttributes) clickedShape.getAttributes(SelectionAttributes.ID);
				sa.toggleSelection();
			}
	
			unselectOthers(clickedShape);
	
	
			if(clickedShape != null){
				System.out.println(clickedShape);
			}
	
			if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 && clickedShape instanceof SText){
				String result = JOptionPane.showInputDialog(LABEL_ENTER_SCALE_FACTOR);
				((SText) clickedShape).setText(result);
			}
		}
		else {
			if(e.getClickCount() != 2) {
				polyInProgress.poly.addPoint(mousePosition.x, mousePosition.y);
			} else {
				drawPoly = false;
				polyInProgress.addAttributes(new ColorAttributes(true,true,Color.RED,Color.BLUE));
				polyInProgress.addAttributes(new SelectionAttributes());
				polyInProgress.addAttributes(new DrawableAttribute());
				this.model.add(polyInProgress);
			}
		}

		this.getView().repaint();
	}

	public Point getLastPositionMouse(){
		return this.lastPositionMouse;
	}

	public void setLastPositionMouse(Point mousePosition){
		this.lastPositionMouse = mousePosition;
	}

	@Override
	public void mouseDragged(MouseEvent e){
		Point mousePosition = e.getPoint();
		Point lastPosition = getLastPositionMouse();
		setLastPositionMouse(mousePosition);

		if(lastPosition == null) {
			lastPosition = getLastPositionMouse();
		}

		int xDif = mousePosition.x - lastPosition.x;
		int yDif = mousePosition.y - lastPosition.y;

		SCollection allShape = (SCollection) this.getModel();
		for(Shape s:allShape.getShapes()){
			SelectionAttributes sa = (SelectionAttributes) s.getAttributes(SelectionAttributes.ID);
			if(sa.isSelected()) {
				Point loc = s.getLoc();
				s.translate(xDif, yDif);
			}
		}

		this.getView().repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e){
		setLastPositionMouse(null);
	}
	@Override
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_S) {
			this.model.clear();
			System.out.println("cleared");
			View view = getView();
			view.repaint();
		}

		if (e.getKeyCode() == 8) {
			SCollection allShapes = (SCollection) this.getModel();
			for(Shape s : allShapes.getShapes()){
				SelectionAttributes sa = (SelectionAttributes) s.getAttributes(SelectionAttributes.ID);
				if(sa.isSelected()){
					allShapes.getShapes().remove(s);
				}
			}
			this.getView().repaint();
		}
	}

}
