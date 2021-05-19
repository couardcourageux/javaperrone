package graphics.shapes.attributes;

public class DrawableAttribute extends Attributes {
	public static final String ID = "DRAWABLE";
	private boolean drawn;
	
	public DrawableAttribute() {
		this.drawn = true ;
	}
	public void setDrawn(boolean b) {
		this.drawn = b;
	}
	public boolean getDrawn() {
		return this.drawn;
	}
	public String getID() {
		return DrawableAttribute.ID;
	}

}
