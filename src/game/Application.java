package game;

import java.util.Arrays;

import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(),new Door());
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
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		

        List<String> moonMap = Arrays.asList(
                ".............",
                ".............",
                ".............",
                ".............",
                ".............",
                ".............");
        GameMap moon = new GameMap(groundFactory, moonMap);
        world.addMap(moon);
		
		Actor player = new PlayerUpdated("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		//setup the actors
		Grunt grunt = new Grunt("Mongo", player);
		//gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		//gameMap.addActor(grunt2,  10, 10);
		Q Q = new Q("Q",player);
		gameMap.addActor(Q, 7, 7);
		Goons goons1 = new Goons("Simon", player);
		//gameMap.addActor(goons1,  1, 1);
		Goons goons2 = new Goons("Red", player);
		//gameMap.addActor(goons2,  10, 8);
		DoctorMaybe doc = new DoctorMaybe("DoctorMaybe");
		gameMap.addActor(doc, 5, 2);
		RocketPlan rocketplan = new RocketPlan();
		gameMap.addItem(rocketplan,16,3);
		RocketPad pad = new RocketPad(moon);
		gameMap.addItem(pad, 22, 10);
		player.addItemToInventory(new RocketBody());
		player.addItemToInventory(new RocketEngine());
		
		
		Ninja ninja = new Ninja("Ninja",player);
		//gameMap.addActor(ninja, 9, 9);
		
		Item rocket2 = Item.newFurniture("Rocket", '^');
        rocket2.getAllowableActions().add(new MoveActorAction(gameMap.at(23, 10), "to Earth!"));
        moon.addItem(rocket2, 7, 2);

		world.run();
	}
}
