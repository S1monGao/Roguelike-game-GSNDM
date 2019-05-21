package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Goons extends Actor{
	/*The Goons are similar to Grunt, by doing the same follow-behiour but can do twice damage as Grunt, which is 10
	 * And 10% chance to insult player
	 * 
	 */
	private ArrayList<String> insultingList = new ArrayList<String>();
	private PlayerUpdated player;
	

	public Goons(String name, PlayerUpdated player) {
		super(name, 'G', 5, 50);
		addBehaviour(new FollowBehaviour(player));
		this.addItemToInventory(Key.newInventoryItem("key", 'K'));
		insultingList.add(" says: I'm gonna catch you.");
		insultingList.add(" says: I'm gonna kill you.");
		insultingList.add(" says: You are so stupid!");
		insultingList.add(" says: You are so silly!");
		this.player = player;
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
		if(player.getCurrentMap()==map) {
			if(Math.random()<=0.1)
				display.println(name +this.insultingList.get(new Random().nextInt(insultingList.size())));
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
		}
		
		return super.playTurn(actions, map, display);
	}
	
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "pokes");
	}

}



