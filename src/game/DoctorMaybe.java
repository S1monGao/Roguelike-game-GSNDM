package game;


import edu.monash.fit2099.engine.*;

public class DoctorMaybe extends Actor{
	
	private PlayerUpdated player;

	public DoctorMaybe(String name,PlayerUpdated player) {
		super(name, 'D', (int)2.5, 25);
		this.player = player;
		this.addItemToInventory(RocketEngine.newInventoryItem("rocketEngine", 'E'));
	}
	

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(player.getCurrentMap()==map) {
			for (Action action:actions) {
				if(action != null&&(action instanceof AttackAction))
					return action;
			}
		}
		
		return new SkipTurnAction();
		
	}
	
	
}
