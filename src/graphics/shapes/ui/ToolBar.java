package graphics.shapes.ui;
import graphics.shapes.*;

import graphics.shapes.ui.ShapesView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

public class ToolBar extends JPanel implements ActionListener {
	ShapesView sview;
	SCollection model;
	
	private final String RESIZE = "riendutout";
	
	public ToolBar(ShapesView view, SCollection model) {
		super(new BorderLayout());
		this.sview = view;
		this.model = model;
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
	
	protected void addButtons(JToolBar toolbar) {
		JButton btn_size = makeButton("resize", RESIZE, "resize a shape object" );
		toolbar.add(btn_size);
		toolbar.add(Box.createVerticalStrut(5));
		toolbar.add(Box.createHorizontalStrut(5));
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
	}
	
	

}
