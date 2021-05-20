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
	
	private final String RESIZE = "resize objects";
	private final String UNSELECT = "unselect all objects";
	private final String POLYGON = "create a new polygon";
	
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
	
	protected void addButton(JToolBar toolbar, String name, String command, String descrip) {
		JButton btn_size = makeButton( name, command, descrip);
		toolbar.add(btn_size);
		toolbar.add(Box.createVerticalStrut(5));
		toolbar.add(Box.createHorizontalStrut(5));
	}
	
	protected void addButtons(JToolBar toolbar) {
		this.addButton(toolbar, "resize", RESIZE, "resize a shape object");
		this.addButton(toolbar, "unselect all", UNSELECT, "unselect all objects");
		this.addButton(toolbar, "polygon", POLYGON, "create a new polygon");
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals(RESIZE)) {
			ShapesController controller = (ShapesController) this.sview.defaultController(this.model);
			SCollection selection = controller.getSelection();
			
			ShapesController rs_controller = (ShapesController) this.sview.defaultController(selection);
			
			Resizer resizer = new Resizer(selection, this.sview, rs_controller);
		}
		else if (cmd.equals(POLYGON)) {
			System.out.println("on clic c'est deja ca");
			ShapesController controller = (ShapesController) this.sview.getController();
			controller.startDrawing();
		}
		
	}
	
	/*@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("au moins ca clic");
		Point mousePosition = e.getPoint();
		if(drawPoly) {
			if(e.getClickCount() != 2) {
				System.out.println("un point de plus pour le poly");
				polyInProgress.poly.addPoint(mousePosition.x, mousePosition.y);
			} else {
				System.out.println("fin du poly");
				drawPoly = false;
				polyInProgress.addAttributes(new ColorAttributes(true,true,Color.RED,Color.BLUE));
				polyInProgress.addAttributes(new SelectionAttributes());
				polyInProgress.addAttributes(new DrawableAttribute());
				this.model.add(polyInProgress);
				this.sview.repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	*/
	

}
