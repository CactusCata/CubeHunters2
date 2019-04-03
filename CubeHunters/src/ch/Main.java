package ch;

import ch.items.enums.Material;
import ch.system.ListItem;
import ch.text.TextBuilder;

public final class Main {

	public static final void main(String[] args) {

		for (final Material materials : Material.values())
			ListItem.addItem(materials);

		TextBuilder.build();

	}

}
