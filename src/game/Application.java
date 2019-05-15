package game;

import java.util.Arrays;

import java.util.List;

import edu.monash.fit2099.demo.DemoSkills;
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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(),new Door(),new Crater());
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
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo.",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo");
        GameMap moon = new GameMap(groundFactory, moonMap);
        world.addMap(moon);
		
		Actor player = new PlayerUpdated("Player", '@', 1, 100, gameMap, moon);
		world.addPlayer(player, gameMap, 2, 2);
		//setup the actors
		Grunt grunt = new Grunt("Mongo", player);
		//gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		//gameMap.addActor(grunt2,  10, 10);
		Q Q = new Q("Q",player);
		//gameMap.addActor(Q, 7, 7);
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
		
        Item spaceSuit = new Item("space suit", '[');
        spaceSuit.addSkill(TravelinSpaceSkill.SPACETRAVELLER);
        gameMap.addItem(spaceSuit, 22, 9);
        
        Item dispenser =Item.newFurniture("Oxygen dispenser", '&');
        gameMap.addItem(dispenser, 22, 8);
        
        
		
		
		Ninja ninja = new Ninja("Ninja",player);
		//gameMap.addActor(ninja, 9, 9);
		
		RocketonMoon rocket2 = new RocketonMoon("Rocket", gameMap);
        moon.addItem(rocket2, 7, 2);

        Grunt grunt3 = new Grunt("Mongo", player);
		//moon.addActor(grunt3, 0, 0);
        Goons goons3 = new Goons("Simon", player);
		//moon.addActor(goons3,  1, 1);
        
        Ninja ninja1 = new Ninja("Ninja",player);
		//moon.addActor(ninja1, 9, 9);
        
        
		world.run();
	}
}
