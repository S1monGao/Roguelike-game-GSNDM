package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

public class PlayerUpdated extends Player{
	private int oxygen = 1;
	private int stunnedRound = 0;
	private GameMap earth;
	private GameMap moon;

	public PlayerUpdated(String name, char displayChar, int priority, int hitPoints,GameMap earth,GameMap moon) {
		super(name, displayChar, priority, hitPoints);
		this.earth = earth;
		this.moon = moon;
		// Initiate player with stun feature
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
	
	public void addoxygen() {
		this.oxygen += 10;
	}
	public void moveninMoon() {
		this.oxygen -= 1;
	}
	public boolean checkOxygen() {
		
		if(this.oxygen>0) 
			return true;
		else
			return false;	
	}
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if (this.checkOxygen()&& map == moon)
			this.moveninMoon();
		else if(map == moon){
			return new MoveActorAction(earth.at(22, 10),"to earth!");
		}
		if (this.isStunned()) {
			this.minusRound();
			return showMenu(new Actions(new SkipTurnAction()), display);
		}
		
		return showMenu(actions, display);
	}
	
@Override 
protected IntrinsicWeapon getIntrinsicWeapon() {
	return new IntrinsicWeapon(999, "punches");
}

	
	
}

