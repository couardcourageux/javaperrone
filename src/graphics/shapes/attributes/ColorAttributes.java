package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes {
	
	public static final String ID = "COLORS";
	public boolean filled;
	public boolean stroked;
	public Color filledColor;
	public Color strokedColor; 
	
	public ColorAttributes() {
		this(false, true, Color.BLACK, Color.BLACK);
	}
	
	public ColorAttributes(boolean filled, boolean stroked, Color filledColor, Color strokedColor) {
		this.filled = filled;
		this.stroked = stroked;
		this.filledColor = filledColor;
		this.strokedColor = strokedColor;
	}

	@Override
	public String getID() {
		return this.ID + this.filled;
	}
}
