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
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.DrawableAttribute;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class AddText extends Add_prompt {
	
	public JTextField jt_t;
	private Point pt;
	private JPanel jp, jp_f, jp_s;
	
	public JColorChooser jc;
	
	public AddText(SCollection collection, ShapesView sview, Point p) {
		this.pt = p;
		this.collection = collection;
		this.sview = sview;
		
		
		this.jf  = new JFrame();
		this.jf.setSize(800, 400);
		this.jf.setTitle("Add a rectangle");
		this.jf.setVisible(true);
		
		
		this.jt_t = new JTextField(64);
		this.jt_t.setText("write here");
		
		this.jp = new JPanel();
		this.jp_f = new JPanel();
		this.jp_s = new JPanel();
		
		this.jc = new JColorChooser();
		
		this.valid = new JButton("OK");
		this.canc = new JButton("cancel");
		
		this.filled = new JCheckBox("filled");
        this.strocked = new JCheckBox("Strocked");
        this.strocked.setSelected(true);
        
        this.jp.add(new JLabel("Content:"));
        this.jp.add(jt_t);
        
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
			SText t = new SText(this.pt, jt_t.getText());
			
			t.addAttributes(new ColorAttributes(filled.isSelected(), strocked.isSelected(), jc.getColor(), jc.getColor()));
			t.addAttributes(new SelectionAttributes());
			t.addAttributes(new FontAttributes());
			t.addAttributes(new DrawableAttribute());
			this.collection.add(t);
			
			this.jf.setVisible(false);
			this.sview.invalidate();
			this.sview.repaint();
			this.jf.dispose();
		}
		else if (e.getSource() == this.canc) {
			this.jf.setVisible(false);
		}
	}

}