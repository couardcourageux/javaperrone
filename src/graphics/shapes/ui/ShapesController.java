package graphics.shapes.ui;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.TreeMap;

import graphics.ui.Controller;
import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.View;

public class ShapesController extends Controller{
	private SCollection model;
	private Point lastPositionMouse;

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
	            System.out.println("\nEst ce que la prochaine figure est selectionn�e?");
	            System.out.println(s);
	            System.out.println(selectAtt.isSelected());
	            System.out.println("voila la reponse :D\n");
            } else {
            	System.out.println("SelectionAttributes non defini?");
            }
        }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Point mousePosition = e.getPoint();
		Shape clickedShape = getElementClicked(mousePosition);
		unselectOthers(clickedShape);
		if(clickedShape==null) {
			System.out.println("ya r ici bro");
		} else {
			System.out.println(clickedShape);
		}
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

		Shape clickedShape = getElementClicked(mousePosition);

		if(clickedShape!=null) {
			Point loc = clickedShape.getLoc();
			clickedShape.translate(xDif, yDif);
			View view = getView();
			view.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e){
		setLastPositionMouse(null);
	}
}
