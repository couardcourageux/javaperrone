package graphics.shapes.ui;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;


public class ShapeDraftman implements ShapeVisitor {

		private static final ColorAttributes DEFAULT_COLOR_ATTRIBUTES = new ColorAttributes();
		Graphics2D g2d;
		
		public void setGraphics(Graphics2D graphics) {
			this.g2d = graphics;
		}
		
		public void visitRectangle(SRectangle rect) {
			Rectangle r = rect.getBounds();
			
			ColorAttributes ca = (ColorAttributes) rect.getAttributes(ColorAttributes.ID);
			if (ca == null) ca = DEFAULT_COLOR_ATTRIBUTES;
			
			
			if (ca.filled) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.fillRect(r.x,  r.y,  r.width, r.height);
			}
			
			if (ca.stroked) {
				this.g2d.setColor(ca.strokedColor);
				this.g2d.drawRect(r.x,  r.y,  r.width, r.height);
			}
			
			
		}
		
		public void visitCircle(SCircle circle) {
			Rectangle r = circle.getBounds();
			
			ColorAttributes ca = (ColorAttributes) circle.getAttributes(ColorAttributes.ID);
			if (ca == null) ca = DEFAULT_COLOR_ATTRIBUTES;
			
			if (ca.filled) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.fillOval(r.x, r.y, r.width, r.height);
			}
			
			if (ca.stroked) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.drawOval(r.x, r.y, r.width, r.height);
			}
		}

		@Override
		public void visitText(SText text) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void visitCollection(SCollection collection) {
			
		}
}
