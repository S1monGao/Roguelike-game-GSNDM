package edu.monash.fit2099.engine;

/**
 * Class that represents a route from one Location to another.
 */
public class Exit {
	
	private String name;
	private Location destination;
	private String hotKey;

	/**
	 *
	 * @param name name of the exit
	 * @param destination Location of the endpoint of the exit
	 * @param hotKey key to use in the menu to represent the Action to go to this Location
	 */
	public Exit(String name, Location destination, String hotKey) {
		this.name = name;
		this.destination = destination;
		this.hotKey = hotKey;
	}

	public String getName() {
		return name;
	}

	public Location getDestination() {
		return destination;
	}
	
	public String getHotKey() {
		return hotKey;
	}
}
