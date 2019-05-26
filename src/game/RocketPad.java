package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.GameMap;

public class RocketPad extends Item{
	//can build rocket on it
	public RocketPad(GameMap moon) {
		super("pad",'O');
		this.allowableActions.clear();
		this.getAllowableActions().add(new BuildRocketAction(moon));
	}
	
	
	

}
