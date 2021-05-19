package graphics.shapes.ui;

import graphics.shapes.Shape;
import graphics.shapes.attributes.*;


import java.awt.*;

import graphics.shapes.*;
import java.util.Iterator;

public class ShapeDraftman implements ShapeVisitor {

		private static final ColorAttributes DEFAULT_COLOR_ATTRIBUTES = new ColorAttributes();
		private static final SelectionAttributes DEFAULT_SELECT_ATTRIBUTES = new SelectionAttributes();
		private Graphics2D g2d;
		
		public void setGraphics(Graphics2D graphics) {
			this.g2d = graphics;
		}
		
		@Override
		public void visitRectangle(SRectangle rect) {
			Rectangle r = rect.getRect();
			
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
			
			SelectionAttributes sa = (SelectionAttributes) rect.getAttributes(SelectionAttributes.ID);
			if (sa == null) sa = DEFAULT_SELECT_ATTRIBUTES;

			if (sa.isSelected()){
				this.g2d.setColor(Color.BLACK);
				this.g2d.drawRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.drawRect(r.x + r.width, r.y + r.height, 7, 7);
				this.g2d.setColor(Color.PINK);
				this.g2d.fillRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.fillRect(r.x + r.width, r.y + r.height, 7, 7);

			}
		}
		
		@Override
		public void visitCircle(SCircle circle) {
			Rectangle r = circle.getBounds();
			
			ColorAttributes ca = (ColorAttributes) circle.getAttributes(ColorAttributes.ID);
			if (ca == null) ca = DEFAULT_COLOR_ATTRIBUTES;
			
			if (ca.filled) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.fillOval(r.x, r.y, r.width, r.height);
			}
			
			if (ca.stroked) {
				this.g2d.setColor(ca.strokedColor);
				this.g2d.drawOval(r.x, r.y, r.width, r.height);
			}
			
			SelectionAttributes sa = (SelectionAttributes) circle.getAttributes(SelectionAttributes.ID);
			if (sa == null) sa = DEFAULT_SELECT_ATTRIBUTES;
			if (sa.isSelected()){
				this.g2d.setColor(Color.BLACK);
				this.g2d.drawRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.drawRect(r.x + r.width, r.y + r.height, 7, 7);
				this.g2d.setColor(Color.PINK);
				this.g2d.fillRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.fillRect(r.x + r.width, r.y + r.height, 7, 7);

			}
		}

		@Override
		public void visitText(SText text) {
			ColorAttributes ca = (ColorAttributes) text.getAttributes(ColorAttributes.ID);
			FontAttributes fa = (FontAttributes) text.getAttributes(FontAttributes.ID);
			
			if (fa != null) {
				this.g2d.setFont(fa.font);
			}
			Rectangle r = text.getBounds();
			
			if (ca == null) ca = DEFAULT_COLOR_ATTRIBUTES;
			
			if (ca.filled) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.fillRect(text.getBounds().x, text.getBounds().y, r.width, r.height);
			}
			
			if (ca.stroked) {
				this.g2d.setColor(ca.strokedColor);
				this.g2d.drawRect(r.x,  r.y,  r.width, r.height);
			}
			
			this.g2d.setColor(fa.fontColor);
			this.g2d.drawString(text.getText(), text.getLoc().x, text.getLoc().y);
			
			SelectionAttributes sa = (SelectionAttributes) text.getAttributes(SelectionAttributes.ID);
			if (sa == null) sa = DEFAULT_SELECT_ATTRIBUTES;

			if (sa.isSelected()){
				this.g2d.setColor(Color.BLACK);
				this.g2d.drawRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.drawRect(r.x + r.width, r.y + r.height, 7, 7);
				this.g2d.setColor(Color.PINK);
				this.g2d.fillRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.fillRect(r.x + r.width, r.y + r.height, 7, 7);

			}
		}
		
		@Override
		public void visitCollection(SCollection collection) {
			Iterator<Shape> it = collection.iterator();
			while (it.hasNext()) {
				it.next().accept(this);
			}
			SelectionAttributes sa = (SelectionAttributes) collection.getAttributes(SelectionAttributes.ID);
			if (sa == null) sa = DEFAULT_SELECT_ATTRIBUTES;

			if (sa.isSelected()){
				Rectangle r = collection.getBounds();
				this.g2d.setColor(Color.BLACK);
				this.g2d.drawRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.drawRect(r.x + r.width, r.y + r.height, 7, 7);
				this.g2d.setColor(Color.PINK);
				this.g2d.fillRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.fillRect(r.x + r.width, r.y + r.height, 7, 7);

			}
			
		}
		public void visitPolygon(SPolygon polygon) {

			ColorAttributes ca = (ColorAttributes) polygon.getAttributes(ColorAttributes.ID);
			if (ca == null) ca = DEFAULT_COLOR_ATTRIBUTES;
			
			if (ca.filled) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.fill(polygon.poly);
			}
			
			if (ca.stroked) {
				this.g2d.setColor(ca.filledColor);
				this.g2d.draw(polygon.poly);
			}
			
			SelectionAttributes sa = (SelectionAttributes) polygon.getAttributes(SelectionAttributes.ID);
			if (sa == null) sa = DEFAULT_SELECT_ATTRIBUTES;

			if (sa.isSelected()){
				Rectangle r = polygon.getBounds();
				this.g2d.setColor(Color.BLACK);
				this.g2d.drawRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.drawRect(r.x + r.width, r.y + r.height, 7, 7);
				this.g2d.setColor(Color.PINK);
				this.g2d.fillRect(r.x - 10, r.y - 10, 7, 7);
				this.g2d.fillRect(r.x + r.width, r.y + r.height, 7, 7);

			}
		}
}
