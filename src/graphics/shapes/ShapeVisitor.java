package graphics.shapes;


public interface ShapeVisitor {

	void visitRectangle(SRectangle sRectangle);
	
	void visitCircle(SCircle circle);
	
	void visitText(SText text);

}
