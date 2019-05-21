package game;

import java.util.Arrays;

import java.util.List;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		NewWorld world = new NewWorld(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(),new Door(),new Crater(),new PoolOfWater());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				"...~~~~................",
				"...~~~~................",
				"...~~~~................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		

        List<String> moonMap = Arrays.asList(
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo",
                "ooooooooooooo");
        GameMap moon = new GameMap(groundFactory, moonMap);
        world.addMap(moon);
		
        PlayerUpdated player = new PlayerUpdated("Player", '@', 1, 100, gameMap, moon);
		world.addPlayer(player, gameMap, 2, 2);
		//setup the actors
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);
		Q Q = new Q("Q",player);
		gameMap.addActor(Q, 7, 7);
		Goons goons1 = new Goons("Simon", player);
		gameMap.addActor(goons1,  1, 1);
		Goons goons2 = new Goons("Red", player);
		gameMap.addActor(goons2,  10, 8);
		DoctorMaybe doc = new DoctorMaybe("DoctorMaybe",player);
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
        
        Item dispenser =new Item("Oxygen dispenser", '&');
        dispenser.getAllowableActions().add(new ProduceTank());
        gameMap.addItem(dispenser, 22, 8);
        
        
		
		
		Ninja ninja = new Ninja("Ninja",player);
		gameMap.addActor(ninja, 9, 9);
		
		RocketonMoon rocket2 = new RocketonMoon("Rocket", gameMap);
        moon.addItem(rocket2, 7, 2);

        Grunt grunt3 = new Grunt("Mongo2", player);
		moon.addActor(grunt3, 0, 0);
		grunt3.addSkill(TravelinSpaceSkill.SPACETRAVELLER);
		
        Goons goons3 = new Goons("Simon2", player);
		moon.addActor(goons3,  1, 1);
		goons3.addSkill(TravelinSpaceSkill.SPACETRAVELLER);
		
        Ninja ninja1 = new Ninja("Ninja2",player);
        moon.addActor(ninja1, 9, 9);
        ninja1.addSkill(TravelinSpaceSkill.SPACETRAVELLER);
        
        moon.addItem(new WaterGun("watergun"), 12, 6);
        
        YugoMaxx finboss = new YugoMaxx("yugomaxx",player);
        moon.addActor(finboss, 12, 1);
        
        player.addItemToInventory(new Item("Sleeping yugomaxx", 'y'));
        
		world.run();
	}
}
