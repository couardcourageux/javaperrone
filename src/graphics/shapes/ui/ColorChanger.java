package graphics.shapes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import graphics.shapes.SCollection;
import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.ui.ColorChanger;

public class ColorChanger extends JPanel implements ChangeListener {
	protected JColorChooser jcc;
	private SCollection selection;
	private ShapesView sview;
	private Color newColor;
	
	public ColorChanger(SCollection selection, ShapesView sview, ShapesController rs_controller) {
		this.selection = selection;
    	this.sview = sview;
        jcc = new JColorChooser(); 
        jcc.getSelectionModel().addChangeListener(this);        
        JFrame frame = new JFrame("ColorChanger");
        frame.add(jcc);
        frame.pack();
        frame.setVisible(true);
        this.selection = selection;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		Color color = jcc.getColor();
		for(graphics.shapes.Shape s : this.selection.getShapes()) {
			newColor = color;
			((graphics.shapes.Shape) s).addAttributes(new ColorAttributes(true, true, color, color));
			
		}
		
		
		sview.repaint();
		
		
	}
	
}
