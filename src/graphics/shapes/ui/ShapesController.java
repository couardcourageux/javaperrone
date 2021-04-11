package graphics.shapes.ui;
import java.awt.event.MouseEvent;

import graphics.ui.Controller;

public class ShapesController extends Controller{
	
	public ShapesController(Object model) {
		super(model);
		}

	
	public void mouseClicker(MouseEvent e) {
		System.out.println("mouse click");
	}
}
