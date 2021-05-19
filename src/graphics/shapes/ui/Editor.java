package graphics.shapes.ui;

//import graphics.shapes.SCircle;
//import graphics.shapes.SCollection;
import graphics.shapes.*;

import graphics.shapes.attributes.*;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Editor extends JFrame
{
	ShapesView sview;
//	SCollection model;
	SCollection model;
	
	ToolBar toolbar;
	
	public Editor()
	{	
		super("Shapes Editor");

		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});
		
		this.buildModel();
		this.setLayout(new BorderLayout());
		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(300,300));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);
		
		
		this.toolbar = new ToolBar(this.sview, this.model);
        this.getContentPane().add(this.toolbar, java.awt.BorderLayout.PAGE_END);
        this.sview.setToolbar(toolbar);
		
	}

	
	private void buildModel()
	{		
		this.model = new SCollection();
		this.model.addAttributes(new SelectionAttributes());
		
		SRectangle r = new SRectangle(new Point(200,200),20,30);
		r.addAttributes(new ColorAttributes(true,false,Color.BLUE,Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		this.model.add(r);
		
		SCircle c = new SCircle(new Point(100,100),10);
		c.addAttributes(new ColorAttributes(false,true,Color.BLUE,Color.BLUE));
		c.addAttributes(new SelectionAttributes());
		this.model.add(c);
		
		SText t= new SText(new Point(100,100),"hello");
		t.addAttributes(new ColorAttributes(true,true,Color.YELLOW,Color.BLUE));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		this.model.add(t);
		
		SCollection sc = new SCollection();
		sc.addAttributes(new SelectionAttributes());
		r= new SRectangle(new Point(20,30),30,30);
		r.addAttributes(new ColorAttributes(true,false,Color.MAGENTA,Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		sc.add(r);
		c = new SCircle(new Point(150,100),30);
		c.addAttributes(new ColorAttributes(false,true,Color.BLUE,Color.DARK_GRAY));
		c.addAttributes(new SelectionAttributes());
		sc.add(c);
		this.model.add(sc);
		
		SPolygon p= new SPolygon(new int[] {160, 180, 190, 200, 220, 205,210, 190,165,175},new int[] {160, 160, 140, 160, 160, 175, 190,180,190,175,},10);
		p.addAttributes(new ColorAttributes(true,true,Color.YELLOW,Color.BLUE));
		p.addAttributes(new SelectionAttributes());
		this.model.add(p);
	}
	
	public static void main(String[] args)
	{
		Editor self = new Editor();
		self.pack();
		self.setVisible(true);
	}
}
