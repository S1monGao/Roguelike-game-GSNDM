package game;

import edu.monash.fit2099.engine.Item;

public class WaterGun extends Item{
	//water gun as an item
	private boolean filled = false;

	/**
	 * @param name
	 */
	public WaterGun(String name) {
		super(name, 'W');
	}

	/**
	 * 
	 */
	public void fill() {
		filled = true;
	}
	
	/**
	 * 
	 */
	public void shoot() {
		filled = false;
	}
	
	/**
	 * @return
	 */
	public boolean isFilled() {
		return filled;
	}
	
	
	
}
