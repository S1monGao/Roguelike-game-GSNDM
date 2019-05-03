package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

import extended.*;


public class Grunt extends Enemy {

	// Grunts have 50 hitpoints and are always represented with a g
	
	public Grunt(String name, Actor player) {
		super(name, 'g', 5, 50);
		addBehaviour(new FollowBehaviour(player));
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	public void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	
}
