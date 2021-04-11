package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;


public class SText extends Shape {
	
	private String text;
	private Point loc;
	
	public SText(String text){
		this.loc = new Point(0, 0);
		this.text = text;
	}
	
	public SText(Point loc, String text) {
		this.loc = loc;
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public Point getLoc() {
		return this.loc;
	}
	
	@Override
	public void setLoc(Point loc) {
		this.loc = loc;
	}
	
	@Override
	public void translate(int dx, int dy) {
		this.loc.translate(dx,  dy);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(loc.x, loc.y, radius, radius);
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitText(this);
	}

}