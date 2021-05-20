package graphics.shapes.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import graphics.shapes.SCollection;
import graphics.ui.Controller;

public abstract class Add_prompt extends JFrame implements  ActionListener {

	
	public JButton valid, canc;
	private JFrame jf;
	private ShapesView sview;
	private Controller controller;
	private SCollection collection;
	
	protected Controller defaultController(Object model) {
		return new Controller(model);
	}
	
	public void setModel(SCollection collection) {
		this.collection = collection;
	}
	
	public void setView(ShapesView sview) {
		this.sview = sview;
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent e);
		

}
