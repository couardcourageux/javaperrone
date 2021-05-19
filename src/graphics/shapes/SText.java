package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.attributes.FontAttributes;


public class SText extends Shape {
	
	
	private static final FontAttributes DEFAULT_FONT_ATTRIBUTES = new FontAttributes();
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
        return loc;
    }

    @Override
    public void setLoc(Point p) {
        this.loc.setLocation(p);
    }

    @Override
    public void translate(int x, int y) {
        this.loc.translate(x, y);
    }
	
	
	@Override
	public Rectangle getBounds() {
		FontAttributes font = (FontAttributes) this.getAttributes("FONTS");
		if (font == null) font = DEFAULT_FONT_ATTRIBUTES;
		
		return font.getBounds(this.text, this.loc);
	}
	
	@Override
	public void resize(float ratio) {
		FontAttributes font = (FontAttributes) this.getAttributes("FONTS");
		if (font == null) font = DEFAULT_FONT_ATTRIBUTES;
		
		font.resize(ratio);
		this.addAttributes(font);
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitText(this);
	}

}