package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class FontAttributes extends Attributes {
	
	public static final String ID = "FONTS";
	public Font font;
	public Color fontColor;
	
	public FontAttributes() {
		this(Font.decode(Font.SANS_SERIF), Color.BLACK);
	}

	public FontAttributes(Font font, Color fontColor) {
		this.font = font;
		this.fontColor = fontColor;
	}
	
	public Rectangle getBounds(String text) {
		JFrame frame = new JFrame("bin");
		Graphics g = (Graphics) frame;
		FontMetrics metrics = 
		int hgt = metrics.getHeight();
		int wdt = metrics.stringWidth(text);
		Rectangle r = new Rectangle(0, 0, wdt+2, hgt+2);
		return r;
		
	}
	
	@Override
	public String getID() {
		return this.ID;
	}
}
