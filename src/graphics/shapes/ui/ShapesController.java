package graphics.shapes.ui;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.ui.Controller;
import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapesController extends Controller{
	private SCollection model;
	
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
	            System.out.println("\nEst ce que la prochaine figure est selectionnée?");
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
}
