package ch.items.enums;

public enum SectionsType {

	OVER_WORLD,
	NETHER,
	END,
	OTHER;

	@Override
	public final String toString() {
		return (this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase()).replace("_", " ");
	}

}
