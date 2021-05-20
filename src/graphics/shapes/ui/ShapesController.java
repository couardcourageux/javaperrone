package graphics.shapes.ui;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.TreeMap;

import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.ui.Controller;
import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.View;

import javax.swing.*;

public class ShapesController extends Controller{
	private SCollection model;
	private Point lastPositionMouse;

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
		if (e.getKeyChar() == 's') {
			this.model.clear();
			System.out.println("cleared");
			View view = getView();
			view.repaint();
		}
		if (e.getKeyChar() == 'd') {
			SCollection toClear = new SCollection();
			Iterator<Shape> iterator = this.model.iterator();
	        while (iterator.hasNext()) {
	        	Shape s = iterator.next();
	        	SelectionAttributes sa = (SelectionAttributes) s.getAttributes(SelectionAttributes.ID);
	        	if(sa.isSelected()) {
	        		toClear.add(s);
	        	}
	        }
	        toClear.clear();
			View view = getView();
			view.repaint();
		}
/*		if (e.getKeyChar() == 't') {
			System.out.println("t comme test");
			Iterator<Shape> iterator = this.model.iterator();
	        while (iterator.hasNext()) {
	        	Shape s = iterator.next();
	        	System.out.println(s);
	        	System.out.println(s.getBounds().x);
	        	System.out.println(s.getBounds().y);
	        	System.out.println(s.getBounds().width);
	        	System.out.println(s.getBounds().height);
	        	System.out.println("fin forme");
	        }
		}*/
	}

}
