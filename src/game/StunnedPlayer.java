package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

public class StunnedPlayer extends Player{

	private int stunnedRound = 2;
	private Actor oldPlayer1;
	
	public StunnedPlayer(Actor oldPlayer) {
		super("player", '@', 1, 50);
		this.oldPlayer1 = oldPlayer;
		// TODO Auto-generated constructor stub
	}

	public int getStunnedRound() {
		return stunnedRound;
	}
	
	
	public void minusRound() {
		stunnedRound -= 1;
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if (!this.isStunned()) {
			map.removeActor(this);
			map.addActor(oldPlayer1, map.locationOf(this).x(), map.locationOf(this).y());
		}
		this.minusRound();
		return new SkipTurnAction();
	}
	
	public boolean isStunned() {
		return stunnedRound > 0;
	}
	
}
