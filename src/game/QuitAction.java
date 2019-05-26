package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitAction extends Action{
//allowing player to quit the game at any time
	@Override
	public String execute(Actor actor, GameMap map) {
		System.out.println("Player quits the game");
		System.exit(0);
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " quit the game";
	}

	@Override
	public String hotKey() {
		return "quit";
	}

}
