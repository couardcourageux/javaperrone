package graphics.shapes.ui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;

public class Resizer extends JFrame implements ActionListener {
	 	public JTextField jt_r;
	    public JButton valid, canc;
	    private Point pt; 
	    
	    private JFrame jf;
	    private JPanel jp, disc;
	    private SCollection selection;
	    private Controller controller;
	    private ShapesView sview;
	    
	    
	    public Resizer(SCollection selection, ShapesView sview, ShapesController controller) {
	    	this.selection = selection;
	    	this.sview = sview;
	    	
	    	this.jf = new JFrame();
	        this.jf.setSize(400, 200);
	        this.jf.setVisible(true);
	        this.jp = new JPanel();
	        this.disc = new JPanel();
	        
	        this.jt_r = new JTextField(20);
	        this.jt_r.setText("100");
	        
	        this.valid = new JButton("OK");
	        this.canc = new JButton("Cancel");

	        this.jp.add(new JLabel("Ratio:"));
	        this.jp.add(jt_r);
	        
	        this.disc.add(new JLabel("Polygons are note resizable"));
	        
	        this.jf.setLayout(new GridLayout(6, 0));
	        
	        this.jf.add(jp);
	        this.jf.add(this.valid);
	        this.jf.add(this.canc);
	        
	        this.jf.add(this.disc);
	        
	        this.valid.addActionListener(this);
	        this.canc.addActionListener(this);
	        
	        this.controller = controller;
	    }
	    
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == this.valid) {
	    		float ratio = ((float) Integer.parseInt(this.jt_r.getText())) /100;
	    		this.selection.resize(ratio);
	    		
	    		this.sview.invalidate();
	            this.jf.setVisible(false);
	            this.jf.dispose();
	    	}
	    	
	    	else if (e.getSource() == this.canc) {
	            this.jf.setVisible(false);
	            this.jf.dispose();
	    	}
	    }
}
