package graphics.shapes;


import java.awt.Color;
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
    public void setLoc(Point p) {
        // TODO Auto-generated method stub
        this.rect.setLocation(p);
    }

    @Override
    public void translate(int x, int y) {
        this.rect.translate(x, y);
    }
	
	@Override
	public Rectangle getBounds() {
		return this.rect.getBounds();
	}
	
	public Rectangle getRect() {
        return this.rect;
    }
	
	
	@Override
	public void resize(float ratio) {
		int w =(int) (ratio * (float)this.getRect().width);
		int h = (int) (ratio * (float)this.getRect().height);
		Point loc = this.getLoc();
		this.rect = new Rectangle(loc.x, loc.y, w, h);
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitRectangle(this);
	}

	
}
