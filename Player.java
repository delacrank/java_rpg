package rpg;

import java.util.ArrayList;
import java.io.IOException;

public class Player {
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    private int money;
    private int dmg;
    private int xp;
    
    private ArrayList<String> inv;

    Player() {
	this.name = "";
	this.level = 0;
	this.maxHealth = 0;
	this.health = 0;
	this.money = 0;
	this.dmg = 0;
	this.xp = 0;
	this.inv = new ArrayList<String>();
    }

    Player(String name, int level, int maxHealth, int health, int money, int dmg, int xp, ArrayList<String> inv) {
	this.level = level;
	this.name = name;
	this.maxHealth = maxHealth;
	this.health = health;
	this.money = money;
	this.dmg = dmg;
	this.xp = xp;
	this.inv = new ArrayList<String>();
	for(String i : inv)
	    this.inv.add(i);
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getLevel() {
	return this.level;
    }

    public void checkLevel(int xp) {
	if(xp >= 100 && this.level == 1) {
	    try {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException ex) {}
	    this.level += 1;
	    this.dmg += 5;
	    this.maxHealth += 30;
	    this.health = this.maxHealth;
	    System.out.println("====================\n" +
			       "Level up: " + this.level + "\n" +
			       "+5 DMG: " + this.dmg + "\n" +
			       "+30 Max Health: " + this.maxHealth + "\n" +
			       "====================\n");
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException ex) {}
	} else if (xp >= 200 && this.level == 2) { 
	    try {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException ex) {}
	    this.level += 1;
	    this.dmg += 10;
	    this.maxHealth += 30;
            this.health = this.maxHealth;
	    System.out.println("====================\n" +
			       "Level up: " + this.level + "\n" +
			       "+10 DMG: " + this.dmg + "\n" +
			       "+30 Max Health: " + this.maxHealth + "\n" +
			       "====================\n");
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException ex) {}
	} else if (xp >= 400 && this.level == 3) {
	    try {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException ex) {}
	    this.level += 1;
	    this.dmg += 15;
	    this.maxHealth += 45;
	    System.out.println("====================\n" +
			       "Level up: " + this.level + "\n" +
			       "+15 DMG: " + this.dmg + "\n" +
			       "+45 Max Health: " + this.maxHealth + "\n" +
			       "====================\n");	 
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException ex) {}
	} else {

	}
    }	    	
    
    public int getHealth() {
	return this.health;
    }

    public void setHealth(int health) {
	this.health = health;
    }

    public void loseHealth(int health) {
	this.health -= health;
    }
    
    public void setMoney(int money) {
	this.money = money;
    }
    
    public int getMoney() {
	return this.money;
    }

    public void addMoney(int money) {
	System.out.println("Picked up " + money + " money");
	this.money += money;
    }

    public void removeMoney(int money) {
	if((this.money - money) >= 0) {
	    this.money -= money;
	} else {
	    System.out.println("Not enough money");
	}
    }

    public int getDmg() {
	return this.dmg = dmg;
    }

    public void setDmg(int dmg) {
	this.dmg = dmg;
    }

    public int getMaxHealth() {
	return this.maxHealth;
    }

    public void getInv() {
	for(String i :  inv)
	    System.out.println(i);
    }

    public void addInv(String s) {
	this.inv.add(s);
	System.out.println(s + " added to inventory");
    }

    public void dropInv(String s) {
	if(this.inv.contains(s)) {
            this.inv.remove(s);
	} else {
	    System.out.println(s + " not in inventory");
        }
    }

    public void getStats() {
	try {
	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} catch (IOException | InterruptedException ex) {}
	System.out.println("====================\n" +
			   "Name: " + this.name +
			   "\nLevel: " + this.level +
			   "\nXp: " + this.xp +
			   "\nDMG: " + this.dmg +
			   "\nHealth: " + this.health +			  
			   "\nMax Health: " + this.maxHealth +
			   "\nMoney: " + this.money +
			   "\n====================\n");
	try {
	    Thread.sleep(1700);
	} catch (InterruptedException ex) {}
    }

    public void usePot() {
	if(inv.contains("small pot")) {
	    System.out.println("You used a small potion");
	    if(this.health <= this.maxHealth - 30) {
	        this.health += 30;
	    } else {
		this.health = this.maxHealth;
	    }
	    inv.remove("small pot");
	    System.out.println("Health: " + this.health);
	} else {
	    System.out.println("You don't have any small potions");
	}
    }

    public int getXp() {
	return this.xp;
    }

    public void addXp(int xp) {
	this.xp += xp;
    }
	
}
