package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	
	public Rectangle getBounds(String text) {
		FontRenderContext frc= DEFAULT_GRAPHICS.getFontRenderContext();
		return font.getStringBounds(text, frc).getBounds();
	}
	
	@Override
	public String getID() {
		return this.ID;
	}
}
