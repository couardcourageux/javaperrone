package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {

	
	public static String ID = "SELECTION";
	
	private Boolean selected;
	
	
	public SelectionAttributes() {
		this.selected = false;
	}
	
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void select() {
		this.selected = true;
	}
	
	public void unselect() {
		this.selected = false;
	}
	
	public void toggleSelection() {
		this.selected = !this.selected;
	}

	@Override
	public String getID() {
		return SelectionAttributes.ID;
	}

}
