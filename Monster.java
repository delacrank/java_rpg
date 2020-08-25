package rpg;

public class Monster {

    private String name;
    private int dmg;
    private String item;
    private int money;
    private int health;
    private int maxHealth;
    private int xp;
    
    Monster() {
	this.name = "";
	this.dmg = 0;
	this.item = "";
	this.money = 0;
	this.health = 0;
	this.maxHealth = 0;
	this.xp = 0;
    }

    Monster(String name, int dmg, String item, int money, int health, int maxHealth, int xp) {
	this.name = name;
	this.dmg = dmg;
	this.item = item;
	this.money = money;
	this.health = health;
	this.maxHealth = maxHealth;
	this.xp = xp;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getDmg() {
	return this.dmg;
    }

    public void setDmg(int dmg) {
	this.dmg = dmg;
    }

    public String getItem() {
	return this.item;
    }

    public void setItem(String item) {
	this.item = item;
    }

    public int getMoney() {
	return this.money;
    }
    
    public void setMoney(int money) {
	this.money = money;
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

    public int getMaxHealth() {
	return this.maxHealth;
    }

    public void setMaxHealth(int health) {
	this.maxHealth = health;
    }
   
    public void resetHealth() {
	this.health = this.maxHealth;
    }

    public int getXp() {
	return this.xp;
    }
}
	
