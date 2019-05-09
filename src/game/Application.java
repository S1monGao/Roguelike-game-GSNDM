package game;

import java.util.Arrays;

import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(),new Door(),new RocketPad());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				"......................O");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		Grunt grunt = new Grunt("Mongo", player);
		//gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		////gameMap.addActor(grunt2,  10, 10);
		Q Q = new Q("Q",player);
		gameMap.addActor(Q, 2, 1);
		//Grunt grunt2 = new Grunt("Norbert", player);
		//gameMap.addActor(grunt2,  10, 10);
		Goons goons1 = new Goons("Simon", player);
		gameMap.addActor(goons1,  1, 1);
		//Goons goons2 = new Goons("Red", player);
		//gameMap.addActor(goons2,  10, 8);
		DoctorMaybe doc = new DoctorMaybe("DoctorMaybe");
		gameMap.addActor(doc, 5, 2);
		RocketPlan rocketplan = new RocketPlan();
		gameMap.addItem(rocketplan,1,1);//16,3
		
		Ninja ninja = new Ninja("ninja",player);
		gameMap.addActor(ninja, 9, 9);
		player.addItemToInventory(rocketplan);
		player.addItemToInventory(new RocketEngine());
		player.addItemToInventory(new RocketBody());
		
		world.run();
	}
}
