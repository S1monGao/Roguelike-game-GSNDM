package game;

import java.util.*;


import edu.monash.fit2099.engine.*;


public class Q extends Actor{

	public Q(String name, Actor player) {
		super(name, 'Q', 5, 99999999);
		
	}
	
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions npcActions = new Actions(new Talks(otherActor,this));
		npcActions.add(new ExchangePlan(otherActor, this));
		return npcActions;
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (Action action : actions) {
			if(action != null && (action instanceof MoveActorAction))
				return action;
			else {
				for(Action action1:actions) {
					if(action1 instanceof AttackAction || action1 instanceof PickUpItemAction) {
						actions.remove(action1);
					}
				}
				
			}
		}
		
		return super.playTurn(actions,  map,  display);
	}
	
}