package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;

public class RocketonMoon extends Item{

	public RocketonMoon (String name,GameMap gameMap) {
		super(name, '^');
		this.allowableActions.clear();
		this.getAllowableActions().add(new MoveActorAction(gameMap.at(22, 10), "to Earth!"));
	}

}