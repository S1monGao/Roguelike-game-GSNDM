package game;

import java.util.*;


import edu.monash.fit2099.engine.*;


public class Q extends Actor{

	public Q(String name, Actor player) {
		super(name, 'Q', 5, 99999999);
		
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions();
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null && !(action instanceof AttackAction))
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
	
}
