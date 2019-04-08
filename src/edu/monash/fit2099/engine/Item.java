package edu.monash.fit2099.engine;


public class Item implements Printable, Skilled {

	protected String name;
	protected char displayChar;
	protected Actions allowableActions;
	protected Skills skills = new Skills();

	public Item(String name, char displayChar) {
		this.name = name;
		this.displayChar = displayChar;
		
		allowableActions = new Actions(new PickUpItemAction(this));
	}
	
	public static Item newFurniture(String name, char displayChar)
	{
		Item item = new Item(name, displayChar);
		item.allowableActions.clear();
		return item;
	}

	@Override
	public char getDisplayChar() {
		return displayChar;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public Actions getAllowableActions() {
		return allowableActions;
	}
	
	public Weapon asWeapon() {
		return this instanceof Weapon ? (Weapon)this : null;
	}

	public boolean hasSkill(Enum skill) {
		return skills.hasSkill(skill);
	}

	public void addSkill(Enum skill) {
		skills.addSkill(skill);
	}

	public void removeSkill(Enum skill) {
		skills.removeSkill(skill);
	}
}
