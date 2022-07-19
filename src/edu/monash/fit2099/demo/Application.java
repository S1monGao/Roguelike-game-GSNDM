package edu.monash.fit2099.demo;

import edu.monash.fit2099.engine.*;
import game.FollowBehaviour;

import java.util.Arrays;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(),
                new Crater());
        
//      initialize earth and mars map
        List<String> earth = Arrays.asList(
                ".............",
                "......######.",
                "......+....+.",
                "......######.",
                ".............");
        GameMap earthMap = new GameMap(groundFactory, earth);
        world.addMap(earthMap);

        List<String> mars = Arrays.asList(
                "ooooooooooooo",
                "oooooooo...oo",
                "oooooo....ooo",
                "oooooooo..ooo",
                "ooo..oooooooo",
                "ooooooooooooo");
        GameMap marsMap = new GameMap(groundFactory, mars);
        world.addMap(marsMap);
//      initialize Item on the maps
        Item rocket = Item.newFurniture("Rocket", '^');
        rocket.getAllowableActions().add(new MoveActorAction(marsMap.at(7, 2), "to Mars!"));
        earthMap.addItem(rocket, 1, 1);

        Item rocketToEarth = Item.newFurniture("RocketTE", '^');
        rocketToEarth.getAllowableActions().add(new MoveActorAction(earthMap.at(1, 1), "to Earth!"));
        marsMap.addItem(rocketToEarth, 7, 2);

        Item spaceSuit = new Item("space suit", '[');
        spaceSuit.addSkill(DemoSkills.SPACETRAVELLER);
        earthMap.addItem(spaceSuit, 0, 1);

        Item stick = new WeaponItem("stick", '/', 10, "pokes");
        earthMap.addItem(stick, 8, 2);

        Actor player = new Player("The Player", '@', 1, 100);
        world.addPlayer(player, earthMap, 3, 2);
//      initialize other Actors i.e. Bugs
        Bug bug1 = new Bug("Spider1");
        bug1.addItemToInventory(Item.newInventoryItem("rock", '*'));
        bug1.actionFactories.add(new SpitBehaviour(player));
        bug1.actionFactories.add(new FollowBehaviour(player));
        earthMap.addActor(bug1, 0, 2);

        Bug bug2 = new Bug("Spider2");
        earthMap.addActor(bug2, 0, 3);
        
        Bug bug3 = new Bug("Spider3");
        earthMap.addActor(bug3, 0, 4);

        world.run();
    }

}
