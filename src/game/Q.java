package game;

import edu.monash.fit2099.engine.*;


public class Q extends Actor{

	private PlayerUpdated player;
	
	public Q(String name, PlayerUpdated player) {
		super(name, 'Q', 5, 99999999);
		this.player=player;
	}
	
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions npcActions = new Actions(new Talks(otherActor,this));
		npcActions.add(new ExchangePlan(otherActor, this));
		return npcActions;
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(player.getCurrentMap()==map) {
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
		return new SkipTurnAction();
	}
}
