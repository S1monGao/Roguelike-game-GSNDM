package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;
import java.util.List;

public class Goons extends Actor{
	/*The Goons are similar to Grunt, by doing the same follow-behiour but can do twice damage as Grunt, which is 10
	 * And 10% chance to insult player
	 * 
	 */
	
	
	public Goons(String name, Actor player) {
		super(name, 'G', 5, 50);
		addBehaviour(new FollowBehaviour(player));
			this.addItemToInventory(Key.newInventoryItem("key", 'K'));
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
  /*Goons have the same follow-behaviour as grunt and it can 
   * 
   */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(Math.random()<=0.1)
			display.println(name + " says: I'm gonna catch you.");
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
			else {

				for(Action action1:actions) {
					if(action1 instanceof DropItemAction||action1 instanceof Opendoor) {
						actions.remove(action1);
					}
				}
				
			}
				
		}
		
		return super.playTurn(actions,  map,  display);
	}
	
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "punches");
	}

}



