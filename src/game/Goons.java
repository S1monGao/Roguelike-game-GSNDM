package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;
import java.util.List;

public class Goons extends Actor{
	
	
	public Goons(String name, Actor player) {
		super(name, 'G', 5, 50);
		addBehaviour(new FollowBehaviour(player));
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(Math.random()<=0.1)
			display.println(name + " says gsndm Éµ±Æ·¶Ë¾»ú");
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
	
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "punches");
	}

}



