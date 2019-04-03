package ch.items.enums;

public enum SubSection {

	BLOCKS,
	COLORED,
	WOOD,
	MOBS_DROPS,
	REDSTONE,
	SHEARS,
	ORES,
	ARMORS,
	TOOLS,
	SILK_TOUCH,
	FOOD,
	VEGETAL,
	OTHER,
	UNDER_WATER_TEMPLE,
	LUCK;

	@Override
	public final String toString() {
		return (this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase()).replace("_", " ");
	}

}
