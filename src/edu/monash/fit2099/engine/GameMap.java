package edu.monash.fit2099.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

/**
 * Class representing one map within the system.
 *
 * The system can have multiple maps, and Actors can move between them.  Only the map that the player is
 * currently on will be displayed, but Actors on all maps will be queried on each turn for their moves --
 * that is, time does not stop when the player leaves a map.
 */
public class GameMap {

	protected Range heights;
	protected Range widths;
	protected Location[][] map;
	protected ActorLocations actorLocations;
	protected GroundFactory groundFactory;

	/**
	 * Constructor.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param groundChar Symbol that will represent empty Ground in this map
	 * @param width width of the GameMap, in characters
	 * @param height height of the GameMap, in characters
	 */
	public GameMap(GroundFactory groundFactory, char groundChar, int width, int height) {
		Objects.requireNonNull(groundFactory);
		if (groundChar <= 0 || width <= 0 || height <= 0)
			throw new IllegalArgumentException();

		this.groundFactory = groundFactory;
		initMap(width, height);

		for (int x : widths) {
			for (int y : heights) {
				map[x][y].setGround(groundFactory.newGround(groundChar));
			}
		}
	}

	/**
	 * Constructor that reads a map from file.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param mapFile Name of a file containing an ASCII representation of a level
	 * @throws IOException when file I/O fails
	 */
	public GameMap(GroundFactory groundFactory, String mapFile) throws IOException {
		Objects.requireNonNull(groundFactory);
		Objects.requireNonNull(mapFile);

		this.groundFactory = groundFactory;
		List<String> lines = Files.readAllLines(Paths.get(mapFile));
		createMapFromStrings(groundFactory, lines);
	}

	/**
	 * Constructor that creates a map from a sequence of ASCII strings.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param lines List of Strings representing rows of the map
	 */
	public GameMap(GroundFactory groundFactory, List<String> lines) {
		Objects.requireNonNull(groundFactory);
		Objects.requireNonNull(lines);

		this.groundFactory = groundFactory;
		createMapFromStrings(groundFactory, lines);
	}

	/**
	 * Create a map from a sequence of ASCII strings.
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param lines List of Strings representing rows of the map
	 */
	private void createMapFromStrings(GroundFactory groundFactory, List<String> lines) {
		int width = lines.get(0).length();
		int height = lines.size();
		initMap(width, height);

		for (int x : widths) {
			for (int y : heights) {
				char groundChar = lines.get(y).charAt(x);
				map[x][y].setGround(groundFactory.newGround(groundChar));
			}
		}
	}

	/**
	 * Initialize the map.
	 *
	 * @param width width of the map, in characters
	 * @param height height of the map, in characters
	 */
	protected void initMap(int width, int height) {
		widths = new Range(0, width);
		heights = new Range(0, height);
		map = new Location[width][height]; // Note the ordering. 0, 0 is the top left.
											// First arg is across, second down
		for (int x : widths) {
			for (int y : heights) {
				map[x][y] = makeNewLocation(x, y);
			}
		}

		for (int x1 : widths) {
			for (int y1 : heights) {
				Location here = map[x1][y1];

				if (y1 > heights.min())
					here.addExit(new Exit("North", map[x1][y1 - 1], "8"));
				if (x1 < widths.max())
					here.addExit(new Exit("East", map[x1 + 1][y1], "6"));
				if (y1 < heights.max())
					here.addExit(new Exit("South", map[x1][y1 + 1], "2"));
				if (x1 > widths.min())
					here.addExit(new Exit("West", map[x1 - 1][y1], "4"));
			}
		}
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	protected Location makeNewLocation(int x, int y) {
		return new Location(this, x, y);
	}

	public Location at(int x, int y) {
		return map[x][y];
	}

	/**
	 * draw Actors, then locations. Need to print in rows because that's the way the
	 * console works.
	 * 
	 * @param display Display that will draw the state of the game
	 */
	public void draw(Display display) {
		for (int y : heights) {
			for (int x : widths) {
				display.print(map[x][y]);
			}
			display.endLine();
		}
	}

	/**
	 * Set the Ground type at the given Location
	 * @param ground Ground type to set
	 * @param location Location to alter
	 */
	public void add(Ground ground, Location location) {
		location.setGround(ground);
	}

	/**
	 * Set the Ground type in a rectangle
	 * @param groundChar
	 * @param xs
	 * @param ys
	 */
	public void add(char groundChar, Range xs, Range ys) {
		for (int x : xs) {
			for (int y : ys) {
				add(groundFactory.newGround(groundChar), at(x, y));
			}
		}
	}

	public Ground groundAt(Location location) {
		Objects.requireNonNull(location);
		return location.getGround();
	}

	public void setActorLocations(ActorLocations actorLocations) {
		Objects.requireNonNull(actorLocations);
		if (this.actorLocations != null)
			throw new IllegalArgumentException("Cannot be set twice");

		this.actorLocations = actorLocations;
	}

	public void addActor(Actor actor, int x, int y) {
		Objects.requireNonNull(actor);
		actorLocations.add(actor, at(x, y));
	}

	public void removeActor(Actor actor) {
		Objects.requireNonNull(actor);
		actorLocations.remove(actor);
	}

	public void moveActor(Actor actor, Location newLocation) {
		Objects.requireNonNull(actor);
		actorLocations.move(actor, newLocation);
	}
	
	public Location locationOf(Actor actor) {
		return actorLocations.locationOf(actor);
	}

	public boolean isAnActorAt(Location location) {
		return actorLocations.isAnActorAt(location);
	}
	
	public Actor actorAt(Location location) {
		return actorLocations.actorAt(location);
	}
	
	public void addItem(Item item, int x, int y) {
		Objects.requireNonNull(item);
		at(x, y).addItem(item);
	}
}
