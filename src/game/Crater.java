package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

public class Crater extends Ground {
//crater on moon requires space suit to move around
	public Crater() {
		super('o');
	}
	
	@Override
	public boolean canActorEnter(Actor a) {
		return a.hasSkill(TravelinSpaceSkill.SPACETRAVELLER);
	}
}
