package ch.items.enums;

public enum RecuperationType {

	FURNACE,
	CRAFTING,
	WATER,
	LAVA,
	COW,
	CHICKEN,
	MINE,
	DUNGEON,
	USE,
	FISHING,
	MINE_SILK_TOUCH,
	DROP_MOB,
	MISCELLANEOUS,
	MINE_SHEARS;

	@Override
	public final String toString() {
		return (this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase()).replace("_", " ");
	}
	
}
