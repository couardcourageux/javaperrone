package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;

public abstract class Shape {
	private Map<String, Attributes> attributes = new TreeMap<>();
	private Point loc;
	
	
	
	public void addAttributes(Attributes attributes) {
		this.attributes.put(attributes.getID(), attributes);
	}
	
	public Attributes getAttributes(String id) {
		return this.attributes.get(id);
	}
	
	public Point getLoc() {	
		return this.loc;
	}
	public void setLoc(Point loc) {
		this.loc = loc;
	}
	public void translate(int dx, int dy) {
		this.loc.translate(dx, dy);
	}
	
	
	public abstract Rectangle getBounds();
	public abstract void accept(ShapeVisitor visitor);
}
