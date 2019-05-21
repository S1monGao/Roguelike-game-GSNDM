package game;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.AttackAction;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.IntrinsicWeapon;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.SkipTurnAction;

public class YugoMaxx extends Actor{

	private boolean exoskeleton = true;
	private PlayerUpdated player;
	
	public YugoMaxx(String name,PlayerUpdated player) {
		super(name, 'Y', 5, 50);
        this.addSkill(TravelinSpaceSkill.SPACETRAVELLER);
        this.player = player;
	}
	
	public boolean getExoskeleton() {
		return exoskeleton;
	}

	public void breakExoskeleton() {
		this.exoskeleton = false;
	}
	
	@Override
	/**
	 * Creates and returns an intrinsic weapon.
	 *
     * By default, the Actor 'punches' for 5 damage.  Override this method to create an Actor with
     * more interesting descriptions and/or damage.
     * 
     * Yugo Maxx's attack makes 10 damages
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "punches");
	}
	
    /**
     * Returns a collection of the Actions containing no action that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return A collection of Actions.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		if(this.getExoskeleton()) {
			return new Actions(new SquirtingAction(otherActor,this));
		}
		return new Actions(new AttackAction(otherActor, this));
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		if(player.getCurrentMap()==map) {
			for(Action action1:actions) {
				if(!(action1 instanceof MoveActorAction||action1 instanceof AttackAction)) {
					actions.remove(action1);
				}
			}
			return super.playTurn(actions, map, display);
		}
		return new SkipTurnAction();
	}
	
}
