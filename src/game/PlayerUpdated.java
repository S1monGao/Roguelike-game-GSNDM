package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

public class PlayerUpdated extends Player{
	
	private int stunnedRound = 0;

	public PlayerUpdated(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
		// TODO Auto-generated constructor stub
	}

	public int getStunnedRound() {
		return stunnedRound;
	}
	
	public void addRound(int num) {
		if (!this.isStunned())
			stunnedRound += num;
	}
	
	public void minusRound() {
		stunnedRound --;
	}
	
	public boolean isStunned() {
		return stunnedRound > 0;
	}
	
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if (this.isStunned()) {
			this.minusRound();
			return new SkipTurnAction();
		}
		return showMenu(actions, display);
	}
}
