package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.SkipTurnAction;

public class PlayerUpdated extends Player{
	private int oxygen = 10;
	private int stunnedRound = 0;
	private int buildRound = 0;
	private GameMap earth;
	private GameMap moon;
	private GameMap currentMap;
	private boolean quit;

	/**
	 * @param name
	 * @param displayChar
	 * @param priority
	 * @param hitPoints
	 * @param earth
	 * @param moon
	 */
	public PlayerUpdated(String name, char displayChar, int priority, int hitPoints,GameMap earth,GameMap moon) {
		super(name, displayChar, priority, hitPoints);
		this.earth = earth;
		this.moon = moon;
		// Initiate player with stun feature
	}

	/**
	 * @return
	 */
	public int getStunnedRound() {
		return stunnedRound;
	}
	
	/**
	 * @param num
	 */
	public void addRound(int num) {
		if (!this.isStunned())
			stunnedRound += num;
	}
	
	/**
	 * 
	 */
	public void minusRound() {
		stunnedRound --;
	}
	
	/**
	 * @return
	 */
	public boolean isStunned() {
		return stunnedRound > 0;
	}
	
	/**
	 * 
	 */
	public void addoxygen() {
		this.oxygen += 10;
	}
	/**
	 * 
	 */
	public void moveninMoon() {
		this.oxygen -= 1;
	}
	/**
	 * @return
	 */
	public boolean checkOxygen() {
		
		if(this.oxygen>0) 
			return true;
		else
			return false;	
	}
	
	/**
	 * @return
	 */
	public int getBuildRound() {
		return buildRound;
	}
	
	/**
	 * 
	 */
	public void addBuildRound() {
		buildRound += 2;
	}
	
	/**
	 * @param map
	 */
	public void buildTank(GameMap map) {
		if(buildRound==0) {
			Item tank = Item.newFurniture("tank", 'T');
			tank.getAllowableActions().add(new CosumeTank());
			map.addItem(tank,map.locationOf(this).x(),map.locationOf(this).y());
		}
	}
	
	/**
	 * @return
	 */
	public GameMap getCurrentMap() {
		return currentMap;
	}
	
	public Action playTurn(Actions actions, GameMap map, Display display) {
		currentMap = map;
		this.win(display);
		if (this.checkOxygen()&& map == moon) {
			this.moveninMoon();
		}
		else if(map == moon){
			return new MoveActorAction(earth.at(22, 10),"to earth!(Run out of Oxygen.)");
		}
		
		if (this.isStunned()) {
			this.minusRound();
			return showMenu(new Actions(new SkipTurnAction()), display);
		}
		
		if (buildRound>0) {
			buildRound -= 1;
			buildTank(map);
			return showMenu(actions, display);	
		}

		
		return showMenu(actions, display);
		
	}
	
	/**
	 * @param display
	 * @return
	 */
	public boolean win(Display display) {
		if (currentMap == earth) {
			for(Item item:this.getInventory()) {
				if(item.toString()=="Sleeping yugomaxx") {
					display.println("Player Wins !\nGame Over");
					System.exit(0);
					return true;
				}
			}
		}
		return false;
	}
	

	public boolean isQuitZera() {
		return quit;
	}
	

	
	@Override
	protected Action showMenu(Actions actions, Display display) {
		actions.add(new QuitAction());
		return super.showMenu(actions, display);
	}
}

