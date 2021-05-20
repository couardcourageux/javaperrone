package graphics.shapes.ui;


import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.attributes.ColorAttributes;

public class AddRectangle extends Add_prompt {
	
	public JTextField jt_h, jt_w;
	private Point pt;
	private JPanel jp, jp_f, jp_s;
	
	public JColorChooser jc;
	
	public AddRectangle(SCollection collection, ShapesView sview, Point p) {
		this.pt = p;
		this.collection = collection;
		this.sview = sview;
		
		
		this.jf  = new JFrame();
		this.jf.setSize(400, 200);
		this.jf.setTitle("Add a rectangle");
		this.jf.setVisible(true);
		
		
		this.jt_h = new JTextField(8);
		this.jt_h.setText("10");
		this.jt_w = new JTextField(8);
		this.jt_w.setText("10");
		
		this.jp = new JPanel();
		this.jp_f = new JPanel();
		this.jp_s = new JPanel();
		
		this.jc = new JColorChooser();
		
		this.valid = new JButton("OK");
		this.canc = new JButton("cancel");
		
		this.filled = new JCheckBox("filled");
		this.filled.setSelected(true);
        this.strocked = new JCheckBox("Strocked");
        
        this.jp.add(new JLabel("height:"));
        this.jp.add(jt_h);
        this.jp.add(new JLabel("width:"));
        this.jp.add(jt_w);
        
        this.jp.add(filled);
        this.jp.add(strocked);
        this.jp_f.add(jc);
        this.jp_s.add(valid);
        this.jp_s.add(this.canc);
        
        this.jf.add(jp, BorderLayout.NORTH);
        this.jf.add(jp_f, BorderLayout.CENTER);
        this.jf.add(jp_s, BorderLayout.SOUTH);
        this.valid.addActionListener(this);
        this.canc.addActionListener(this);
        
        this.controller = defaultController(collection);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.valid) {
			SRectangle r = new SRectangle(this.pt, Integer.parseInt(jt_w.getText()), Integer.parseInt(jt_h.getText()));
			
			r.addAttributes(new ColorAttributes(filled.isSelected(), strocked.isSelected(), jc.getColor(), jc.getColor()));
			this.collection.add(r);
			
			this.jf.setVisible(false);
			this.sview.invalidate();
		}
		else if (e.getSource() == this.canc) {
			this.jf.setVisible(false);
		}
	}

}

