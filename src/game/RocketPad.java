package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

public class RocketPad extends Item{

	public RocketPad(GameMap moon) {
		super("pad",'O');
		this.allowableActions.clear();
		this.getAllowableActions().add(new BuildRocketAction(moon));
	}
	
	
	

}
