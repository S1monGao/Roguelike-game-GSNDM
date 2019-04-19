package edu.monash.fit2099.engine;

/**
 * Action to allow items to be picked up.
 */
public class PickUpItemAction extends Action {

	private Item item;

	/**
	 * Constructor.
	 *
	 * @param item the item to pick up
	 */
	PickUpItemAction(Item item) {
		this.item = item;
	}

	/**
	 * Add the item to the actor's inventory.
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		map.locationOf(actor).removeItem(item);
		actor.addItemToInventory(item);
		item.getAllowableActions().remove(this);
		item.getAllowableActions().add(new DropItemAction(item));
		return menuDescription(actor);
	}

	/**
	 * Returns a string describing the action suitable for displaying in the menu.
	 *
	 * @see Action#menuDescription(Actor)
	 * @param actor The actor performing the action.
	 * @return a string, e.g. "Player picks up the rock"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " picks up the " + item;
	}

	/**
	 * Returns the empty string, as no hotkey is permanently assigned to pickup.
	 * @return the empty string
	 */
	@Override
	public String hotKey() {
		return "";
	}
}
