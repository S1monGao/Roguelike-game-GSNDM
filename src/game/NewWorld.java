package game;


import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

public class NewWorld extends World{

	private Actor player;

	public NewWorld(Display display) {
		super(display);
	}
	
	/**
	 * Add the player to a map.
	 *
	 * The player is special: we only display the map that the player is on.
	 * 
	 * @param player the player to add
	 * @param map the map where the player is to be added
	 * @param y y coordinate of the player
	 * @param x x coordinate of the player
	 */
	@Override
	public void addPlayer(Actor player, GameMap map, int y, int x) {
		this.player = (PlayerUpdated) player;
		super.addPlayer(player, map, y, x);
	}
	
	
	/**
	 * Return a string that can be displayed when the game ends.
	 *
	 * @return the string "Game Over"
	 */
	protected String endGameMessage() {
		// Not a bad idea, but not in keeping with the current theme.
		// return "It's game over, man.";
		if(!this.player.isConscious()) {
			return "Player loses !\nGame Over";
		}

		return "";
	}



	
}
