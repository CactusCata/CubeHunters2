package ch.system;

import ch.items.enums.Material;

public class SubInformation {

	private int itemCreatedNumber;
	private final int numberCreated;
	private final Material forWhatItem;

	public SubInformation(Material forWhatItem, int numberCreated) {
		this.forWhatItem = forWhatItem;
		this.numberCreated = numberCreated;
		add();
	}

	public void add() {
		this.itemCreatedNumber += this.numberCreated;
	}

	public String getText() {
		return "x" + this.itemCreatedNumber + " {" + this.forWhatItem.getRecuperationType() + "} \""
				+ this.forWhatItem.toString() + "\" "
				+ (this.itemCreatedNumber != 1 ? "x" + ListItem.getMapItems().get(forWhatItem).getTotalAmount() : "");
	}

}
