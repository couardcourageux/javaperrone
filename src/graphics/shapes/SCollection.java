package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SCollection extends Shape {
	
	private Point loc;
	private List<Shape> collection = new ArrayList<>();
	
	public Iterator<Shape> iterator() {
		return this.collection.iterator();
	}
	
	public void add(Shape shape) {
		this.collection.add(shape);
	}

	
	@Override
    public Point getLoc() {
        // TODO Auto-generated method stub
        return this.loc;
    }

    @Override
    public void setLoc(Point p) {
        this.loc = p;
    }

    @Override
    public void translate(int x, int y) {
        Iterator<Shape> it = this.iterator();
        while (it.hasNext()) {
            it.next().translate(x, y);
        }
    }
	
	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle(-1, -1);
        Iterator<Shape> it = this.iterator();
        while (it.hasNext()) {
            r.add(it.next().getBounds());
        }
        return r;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCollection(this);
	}

	public void clear() {
		this.collection.clear();
		
	}

}
