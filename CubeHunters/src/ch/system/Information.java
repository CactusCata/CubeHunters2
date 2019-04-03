package ch.system;

import java.util.HashMap;
import java.util.Map;

import ch.items.enums.Material;

public class Information {

	private int totalAmount;
	private final Material item;
	private Map<Material, SubInformation> mapSubInformation = new HashMap<>();

	public Information(Material item) {
		this.item = item;
		this.totalAmount++;
	}

	public Information(Material item, Material forWhatItem) {
		this(item);
		add(item, forWhatItem);
	}

	public void add(Material item, Material forWhatItem) {
		
		this.totalAmount++;
		if (this.mapSubInformation.get(forWhatItem) == null) {
			this.mapSubInformation.put(forWhatItem, new SubInformation(forWhatItem, forWhatItem.getItemsCreated()));
		} else {
			this.mapSubInformation.get(forWhatItem).add();
		}
		
	}
	
	public int getTotalAmount() {
		return this.totalAmount;
	}

	public void add(Material item) {
		this.totalAmount++;
	}

	public String getInformationText() {
		StringBuilder build = new StringBuilder(this.item.toString() + " x" + this.totalAmount + " --> [GIVE]");
		for (Material items : this.mapSubInformation.keySet()) {
			build.append(" + [" + this.mapSubInformation.get(items).getText() + "]");
		}
		return build.toString();
	}

}
