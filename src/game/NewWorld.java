package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

public class NewWorld extends World{

	private Display display;
	private List<GameMap> maps = new ArrayList<GameMap>();
	private ActorLocations actorLocations = new ActorLocations();
	private Actor player; // We only draw the particular map this actor is on.


	/**
	 *
	 * @param display
	 */
	public NewWorld(Display display) {
		super(display);
	}
	/**
	 * Run the game.
	 *
	 * On each iteration the gameloop does the following:
	 *  - displays the player's map
	 *  - processes the actions of every Actor in the game, regardless of map
	 *
	 * We could either only process the actors on the current map, which would make
	 * time stop on the other maps, or we could process all the actors.  We chose to
	 * process all the actors.
	 *
	 * @throws IllegalStateException if the player doesn't exist
	 */
	@Override
	public void run() {
		if(player == null)
			throw new IllegalStateException();
		
		while (stillRunning()) {
			GameMap playersMap = actorLocations.locationOf(player).map();
			playersMap.draw(display);
			for (Actor actor : actorLocations) {
				processActorTurn(actor);
			}
		}
		display.println(endGameMessage());
	}

	
}
