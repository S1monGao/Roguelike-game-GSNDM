package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;




public class Grunt extends Actor {
	
	private PlayerUpdated player;

	// Grunts have 50 hitpoints and are always represented with a g
	public Grunt(String name, PlayerUpdated player) {
		super(name, 'g', 5, 50);
		addBehaviour(new FollowBehaviour(player));
		this.player = player;
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(player.getCurrentMap()==map) {
			for (ActionFactory factory : actionFactories) {
				Action action = factory.getAction(this, map);
				if(action != null)
					return action;
				else {
					for(Action action1:actions) {
						if(!(action1 instanceof MoveActorAction||action1 instanceof AttackAction)) {
							actions.remove(action1);
						}
					}
				}
			}
			
			return super.playTurn(actions, map, display);
		
		}
		
		return super.playTurn(actions, map, display);
	}
}
