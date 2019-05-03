package extended;

import edu.monash.fit2099.engine.*;
import game.ActionFactory;

import java.util.ArrayList;
	import java.util.List;
/**
 * @author mad scientist
 *
 */
public abstract class Enemy extends Actor {

	// Grunts have 50 hitpoints and are always represented with a g
	public Enemy(String name, Actor player) {
		super(name, ' ', 5, 50);
	}


	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	public void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}


	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
}


