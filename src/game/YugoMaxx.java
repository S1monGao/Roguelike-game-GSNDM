package game;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.IntrinsicWeapon;

public class YugoMaxx extends Actor{

	private boolean exoskeleton = true;
	
	public YugoMaxx(String name) {
		super(name, 'Y', 5, 50);
		// TODO Auto-generated constructor stub
	}
	
	public boolean exoskeleton() {
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

	
}
