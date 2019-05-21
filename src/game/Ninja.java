package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.PickUpItemAction;
import edu.monash.fit2099.engine.SkipTurnAction;

public class Ninja extends Actor{
	
	private PlayerUpdated player;

	public Ninja(String name, PlayerUpdated player) {
		super(name, 'N', 4, 15);
		// TODO Auto-generated constructor stub
		addBehaviour(new NinjaBehaviour(player));
		this.player = player;
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(player.getCurrentMap()==map) {
			if(Math.random()<=0.5 && (this.distance(map.locationOf(this),map.locationOf(player))<=5)) {
				display.println(player + " got stunned by " + this);
				((PlayerUpdated) player).addRound(2);
	
			}
			
			for (ActionFactory factory : actionFactories) {
				Action action = factory.getAction(this, map);
				if(action != null)
					return action;
				else {
					for(Action action1:actions) {
						if(action1 instanceof PickUpItemAction) {
							actions.remove(action1);
						}
					}
				}	
			}
		}
		return new SkipTurnAction();
	}
	
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}

	
}
