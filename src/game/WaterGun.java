package game;

import edu.monash.fit2099.engine.Item;

public class WaterGun extends Item{
	
	private boolean filled = false;

	public WaterGun(String name) {
		super(name, 'W');
		// TODO Auto-generated constructor stub
		
	}

	public void fill() {
		filled = true;
	}
	
}
