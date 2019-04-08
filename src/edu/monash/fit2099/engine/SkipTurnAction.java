package edu.monash.fit2099.engine;

/**
 * Special Action used when the player doesn't want to do anything this turn.
 */
public class SkipTurnAction extends Action {

	public SkipTurnAction() {
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " does nothing";
	}
	
	@Override
	public String hotKey() {
		return "5";
	}
}
