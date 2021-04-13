package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SCollection extends Shape {
	
	private Point loc;
	private List<Shape> collection = new ArrayList<>();
	
	public Iterator iterator() {
		return this.collection.iterator();
	}
	
	public void add(Shape shape) {
		this.collection.add(shape);
	}

	@Override
	public Rectangle getBounds() {
		float x=-1;
		float y = -1;
		float dx = -1;
		float dy = -1;
		
		Iterator shapes = this.iterator();
		while (shapes.hasNext()){
			Shape shape = (Shape) shapes.next();
			x = Math.min(x, shape.getLoc().x);
			y = Math.min(y, shape.getLoc().y);
			dx = Math.max(dx, shape.getBounds().width);
			dy = Math.max(dy,  shape.getBounds().height);
		}
		
		x = Math.min(0, ((int) x) - 1);
		y = Math.min(0, ((int) y) - 1);
		dx = ((int) dx) + 1;
		dy = ((int) dy) + 1;
		
		Rectangle bounds = new Rectangle((int) x, (int) y, (int) dx, (int) dy);
		return bounds;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
