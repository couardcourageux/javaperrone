package graphics.shapes.ui;
import graphics.shapes.*;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.DrawableAttribute;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.shapes.ui.ShapesView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

public class ToolBar extends JPanel implements ActionListener{
	ShapesView sview;
	SCollection model;
	ShapesController controller;
	
	private final String RESIZE = "resize objects";
	private final String UNSELECT = "unselect all objects";
	
	private final String CIRCLE = "new circle";
	private final String TEXT = "new text";
	private final String RECTANGLE = "new rectangle";
	private final String POLYGON = "create a new polygon";
	
	private final int DEFAULT_POS_X = 100;
	private final int DEFAULT_POS_Y = 100;
	
	
	public ToolBar(ShapesView view, SCollection model) {
		super(new BorderLayout());
		this.sview = view;
		this.model = model;
		this.controller =  (ShapesController) this.sview.defaultController(this.model);
		
		JToolBar toolBar = new JToolBar("toolbar", JToolBar.HORIZONTAL);
		toolBar.setBackground(Color.DARK_GRAY);
		addButtons(toolBar);
		add(toolBar, BorderLayout.PAGE_START);
		toolBar.setFloatable(false);
		TitledBorder border = BorderFactory.createTitledBorder("barre d'outils");
		border.setTitleColor(Color.white);
		toolBar.setBorder(border);	
	}
	
	protected JButton makeButton(String name, String command, String toolTip) {
		JButton button = new JButton(name);
		button.setActionCommand(command);
		button.setToolTipText(toolTip);
		button.addActionListener(this);
		button.setFocusable(false);
		button.setVisible(true);
		return button;
	}
	
	protected void addButton(JToolBar toolbar, String name, String command, String descrip) {
		JButton btn_size = makeButton( name, command, descrip);
		toolbar.add(btn_size);
		toolbar.add(Box.createVerticalStrut(5));
		toolbar.add(Box.createHorizontalStrut(5));
	}
	
	protected void addButtons(JToolBar toolbar) {
		this.addButton(toolbar, RESIZE, RESIZE, RESIZE);
		
		this.addButton(toolbar, CIRCLE, CIRCLE, CIRCLE);
		this.addButton(toolbar, TEXT, TEXT, TEXT);
		this.addButton(toolbar, RECTANGLE, RECTANGLE, RECTANGLE);

		this.addButton(toolbar, POLYGON, POLYGON, POLYGON);
		

	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals(RESIZE)) {
			
			SCollection selection = this.controller.getSelection();
			
			ShapesController rs_controller = (ShapesController) this.sview.defaultController(selection);
			
			Resizer resizer = new Resizer(selection, this.sview, rs_controller);
		}
		else if (cmd.equals(POLYGON)) {
			ShapesController controller = (ShapesController) this.sview.getController();
			controller.startDrawing();
		}
		
		if (cmd.equals(CIRCLE)) {
			AddCircle add = new AddCircle(this.model, this.sview, new Point(DEFAULT_POS_X, DEFAULT_POS_Y));
		}
		if (cmd.equals(TEXT)) {
			AddText add = new AddText(this.model, this.sview, new Point(DEFAULT_POS_X, DEFAULT_POS_Y));
		}
		if (cmd.equals(RECTANGLE)) {
			AddRectangle add = new AddRectangle(this.model, this.sview, new Point(DEFAULT_POS_X, DEFAULT_POS_Y));
		}
		
		
		
	}

	

}
