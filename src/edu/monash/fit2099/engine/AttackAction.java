package edu.monash.fit2099.engine;

import java.util.Random;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	private Actor actor;
	private Actor subject;
	private Random rand = new Random();

	public AttackAction(Actor actor, Actor subject) {
		this.actor = actor;
		this.subject = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (rand.nextBoolean()) {
			return actor + " misses " + subject + ".";
		}

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + subject + " for " + damage + " damage.";

		subject.hurt(damage);
		if (!subject.isConscious()) {

			Item sleepingActor = new Item("Sleeping " + subject, '%');
			map.locationOf(subject).addItem(sleepingActor);
			for (Item item : subject.getInventory()) {
				new DropItemAction(item).execute(subject, map);
			}
			map.removeActor(subject);
			result += System.lineSeparator() + subject + " is knocked out.";
		}

		return result;

	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
