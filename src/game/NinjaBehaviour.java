package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.SkipTurnAction;

public class NinjaBehaviour implements ActionFactory{
	
	private Actor target;

	public NinjaBehaviour(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		
		// create the behavior for ninja
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = distance(here, there);
		if(currentDistance <=5) {
			for (Exit exit : here.getExits()) {
				Location destination = exit.getDestination();
				if (destination.canActorEnter(actor)) {
					int newDistance = distance(destination, there);
					if (newDistance >= currentDistance+1) {
						return new MoveActorAction(destination, exit.getName());
					}
				}
			}
		}

		return new SkipTurnAction();
	}

		// Manhattan distance.
		private int distance(Location a, Location b) {
			return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
		}
	

}
