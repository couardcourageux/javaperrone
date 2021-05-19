package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Polygon;

public class SPolygon extends Shape{

	private Point loc;
	public Polygon poly;
	
	public SPolygon(int[] x, int[] y, int nbrPoints) {
		this.loc = new Point(x[0], y[0]);
		this.poly = new Polygon(x,y,nbrPoints);

	}
	
	public SPolygon() {
		this.loc = new Point(0,0);
		this.poly = new Polygon();
	}
	
	@Override
	public Point getLoc() {
        return loc;

    }

    @Override
    public void setLoc(Point p) {
        this.loc = p;
    }

    @Override
    public void translate(int x, int y) {

        this.loc.translate(x, y);
        for(int i = 0; i< this.poly.npoints; i++) {
        	this.poly.xpoints[i]+=x;
        	this.poly.ypoints[i]+=y;
        }
    }
	
	@Override
	public Rectangle getBounds() {
		int maxX = 0;
		for(int i = 0; i< this.poly.npoints; i++) {
			if (this.poly.xpoints[i] > maxX) maxX = this.poly.xpoints[i];
		}
		int maxY = 0;
		for(int i = 0; i< this.poly.npoints; i++) {
			if (this.poly.ypoints[i] > maxY) maxY = this.poly.ypoints[i];
		}
		int minX = 10000;
		for(int i = 0; i< this.poly.npoints; i++) {
			if (this.poly.xpoints[i] < minX) minX = this.poly.xpoints[i];
		}
		int minY = 10000;
		for(int i = 0; i< this.poly.npoints; i++) {
			if (this.poly.ypoints[i] < minY) minY = this.poly.ypoints[i];
		}
		return new Rectangle(minX, minY, maxX-minX, maxY-minY);
	}
	
	@Override
	public void resize(float ratio) {
		
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitPolygon(this);
	}
}