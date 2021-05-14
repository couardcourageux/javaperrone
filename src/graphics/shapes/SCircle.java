package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;


public class SCircle extends Shape {
	
	private int radius;
	private Point loc;
	
	public SCircle(int radius) {
		this.loc = new Point(0, 0);
		this.radius = radius;
	}
	
	public SCircle(Point loc, int radius) {
		this.loc = loc;
		this.radius = radius;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(loc.x - radius, loc.y - radius, 2* radius, 2* radius);
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitCircle(this);
	}

}
