package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import java.awt.Graphics2D;
import java.awt.Point;

public class FontAttributes extends Attributes {
	
	public static final String ID = "FONTS";
	public Font font;
	public Color fontColor;
	
	public static final Graphics2D DEFAULT_GRAPHICS = (Graphics2D)  new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
	
	public FontAttributes() {
		this(Font.decode(Font.SANS_SERIF), Color.BLACK);
	}

	public FontAttributes(Font font, Color fontColor) {
		this.font = font;
		this.fontColor = fontColor;
	}
	
	public Rectangle getBounds(String text, Point loc) {
		BufferedImage off_Image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = off_Image.createGraphics();
        FontMetrics m = g2.getFontMetrics(this.font);
        return new Rectangle(loc.x, loc.y-m.getHeight(), m.stringWidth(text), m.getHeight());
	}
	
	public void resize(float ratio) {
		float newSize = ratio * this.font.getSize2D();
		this.font = this.font.deriveFont(newSize);
	}
	
	@Override
	public String getID() {
		return FontAttributes.ID;
	}
}
