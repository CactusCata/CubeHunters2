package ch.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ch.items.enums.Material;
import ch.items.enums.RecuperationType;
import ch.items.enums.SectionsType;
import ch.items.enums.SubSection;
import ch.system.ListItem;

public class TextBuilder {

	private static StringBuilder message = new StringBuilder();
	private static final Map<SectionsType, Integer> sectionsTypesMap = new HashMap<>();
	private static final Map<RecuperationType, Integer> recuperationTypeMap = new HashMap<>();
	private static final Map<SubSection, Integer> subSectionType = new HashMap<>();

	static {

		int j = SectionsType.values().length;
		for (int i = 0; i < j; i++)
			sectionsTypesMap.put(SectionsType.values()[i], i);

		j = RecuperationType.values().length;
		for (int i = 0; i < j; i++)
			recuperationTypeMap.put(RecuperationType.values()[i], i);

		j = SubSection.values().length;
		for (int i = 0; i < j; i++)
			subSectionType.put(SubSection.values()[i], i);

	}

	public static void build() {

		Set<Material> requied = ListItem.getMapItems().keySet();

		List<List<Material>> items = Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());

		for (Material mats : requied)
			for (SectionsType sectionTypes : SectionsType.values())
				if (mats.getSectionType() == sectionTypes) {
					int i = sectionsTypesMap.get(sectionTypes);
					items.get(i).add(mats);
					break;
				}

		for (List<Material> list : items) {
			organizeRecuperationType(list);
		}

		System.out.println(message);
	}

	private static void organizeRecuperationType(List<Material> section) {

		if (section.size() == 0)
			return;

		final List<List<Material>> items = Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>());

		message.append("      ---=== " + section.get(0).getSectionType().toString() + " ===---\n\n\n");

		for (Material mats : section)
			for (RecuperationType sectionTypes : RecuperationType.values())
				if (mats.getRecuperationType() == sectionTypes) {
					int i = recuperationTypeMap.get(sectionTypes);
					items.get(i).add(mats);
					break;
				}

		for (List<Material> list : items)
			organizeSubSection(list);

	}

	private static void organizeSubSection(List<Material> materials) {

		if (materials.size() == 0)
			return;

		final List<List<Material>> items = Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>(), new ArrayList<>());

		message.append("\n       --=[{" + materials.get(0).getRecuperationType().toString() + "}]=--\n\n");

		for (Material mats : materials)
			for (SubSection sectionTypes : SubSection.values())
				if (mats.getSubsection() == sectionTypes) {
					items.get(subSectionType.get(sectionTypes)).add(mats);
					break;
				}

		for (List<Material> list : items)
			addText(list);

	}

	private static void addText(List<Material> list) {

		if (list.size() == 0)
			return;

		message.append("\n   {" + list.get(0).getSubsection().toString() + "}\n\n");
		for (Material materials : list)
			message.append(ListItem.getMapItems().get(materials).getInformationText() + "\n");

	}

}
