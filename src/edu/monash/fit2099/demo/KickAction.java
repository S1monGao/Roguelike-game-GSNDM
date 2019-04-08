package edu.monash.fit2099.demo;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.*;

public class KickAction extends Action {

	private Actor actor;
	private Actor subject;
	private Random rand = new Random();

	public KickAction(Actor actor, Actor subject) {
		this.actor = actor;
		this.subject = subject;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (rand.nextBoolean()) {
			return subject + " evades the clumsy kick.";
		} else {
			map.removeActor(subject);
			return actor + " squashes " + subject + " like a bug.";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " kicks " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}
}
