package ch.system;

import java.util.HashMap;
import java.util.Map;

import ch.items.enums.Material;

public class ListItem {

	private static Map<Material, Information> mapItems = new HashMap<>();

	public static void addItem(Material item) {

		if (mapItems.get(item) == null) {
			mapItems.put(item, new Information(item));
		} else {
			mapItems.get(item).add(item);
		}
		
		for(Material items : item.getDecraftableItems())
			addItem(items, item);

	}
	
	public static void addItem(Material item, Material forWhatItem){
		
		if (mapItems.get(item) == null) {
			mapItems.put(item, new Information(item, forWhatItem));
		} else {
			mapItems.get(item).add(item, forWhatItem);
		}
		
		for(Material items : item.getDecraftableItems())
			addItem(items, item);
		
	}

	public static Map<Material, Information> getMapItems() {
		return mapItems;
	}

}
