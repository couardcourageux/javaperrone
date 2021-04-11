package graphics.shapes;


import java.awt.Point;
import java.awt.Rectangle;


public class SRectangle extends Shape {
	private Rectangle rect;
	
	public SRectangle(int width, int height) {
		this.rect = new Rectangle(0, 0, width, height);
	}
	
	public SRectangle(Point loc, int width, int heigth) {
		this.rect = new Rectangle(loc.x, loc.y, width, heigth);
	}
	

	@Override
	public Point getLoc() {
		return this.rect.getLocation();
	}
	
	@Override
	public void setLoc(Point loc) {
		this.rect.setLocation(loc);
	}
	
	@Override
	public void translate(int dx, int dy) {
		this.rect.translate(dx, dy);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.rect);
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitRectangle(this);
	}
}
