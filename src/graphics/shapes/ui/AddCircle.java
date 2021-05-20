package graphics.shapes.ui;

import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphics.shapes.SCollection;

public class AddCircle extends Add_prompt {
	
	public JTextField jt_r;
	private Point pt;
	private JPanel jp, jp_f, jp_s;
	
	public JColorChooser jc;
	
	public AddCircle(SCollection collection, ShapesView sview, Point p) {
		this.pt = p;
		this.collection = collection;
		
		this.jf  = new JFrame();
		this.jf.setSize(400, 200);
		this.jf.setTitle("Add a circle");
		this.jf.setVisible(true);
		
		this.jp = new JPanel();
		this.jp_f = new JPanel();
		this.jp_s = new JPanel();
		
		this.valid = new JButton("OK");
		this.canc = new JButton("cancel");
		
		this.filled = new JCheckBox("filled");
		this.filled.setSelected(true);
        this.strocked = new JCheckBox("Strocked");
	}

}
