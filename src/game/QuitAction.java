package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitAction extends Action{

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		System.out.println("Player quits the game");
		System.exit(0);
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " quit the game";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "quit";
	}

}
