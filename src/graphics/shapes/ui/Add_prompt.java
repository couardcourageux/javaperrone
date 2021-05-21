package graphics.shapes.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import graphics.shapes.SCollection;
import graphics.ui.Controller;

public abstract class Add_prompt extends JFrame implements  ActionListener {

	
	protected final int INT_FIELD_SIZE = 4;
	protected final String INT_FIELD_DEFAULT = "10";
	protected final int STRING_FIELD_SIZE = 32;
	
	protected final String VALID_VAL = "OK";
	protected final String CANC_VAL = "cancel";
	
	protected final String FILLED_VAL = "filled";
	protected final String STROCKED_VAL = "Strocked";
	
	protected final Boolean FILLED_DEFAULT = true;
	protected final Boolean STROCKED_DEFAULT = true;
	
	protected final int PROMPT_DEFAULT_SIZE_X = 800;
	protected final int PROMPT_DEFAULT_SIZE_Y = 800;
	
	public JButton valid, canc;
	public JCheckBox filled, strocked;
	protected JFrame jf;
	protected ShapesView sview;
	protected Controller controller;
	protected SCollection collection;
	
	
	
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
