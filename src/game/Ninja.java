package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.SkipTurnAction;

public class Ninja extends Actor{
	
	private Actor player;

	public Ninja(String name, Actor player) {
		super(name, 'N', 5, 5);
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
		
		if(Math.random()<=0.5) {
			display.println(player + " got stunned by " + this);
			player.playTurn(new Actions(new SkipTurnAction()), map, display);
		}
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}

}
