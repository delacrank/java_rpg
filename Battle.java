package rpg;

import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class Battle {

    public void fight(Player p, Monster m) {
	System.out.println("You have taken " + m.getDmg());
	p.loseHealth(m.getDmg());
	m.loseHealth(p.getDmg());
	if(p.getHealth() <= 0) {
	    System.out.println("You have died");
	    System.exit(0);
	}
	System.out.println("Remaining hp " + p.getHealth());
	System.out.println("Remaining monster hp " + m.getHealth());		     
    }

    public void flee(Player p, Monster m) {
	System.out.println("You have taken " + m.getDmg());
	p.loseHealth(m.getDmg());
	if(p.getHealth() <= 0) {
	    System.out.println("You have died");
	    System.exit(0);
	}
	System.out.println("Remaining hp " + p.getHealth());
    }
    
    public void battleMenu(Player p, Monster m) {
	if(p.getLevel() > 1) {
	    m.setName("Orge");
	    m.setDmg(10);
	    m.setMaxHealth(150);
	    m.resetHealth();
	}
	int action = 0;
	System.out.println();
	System.out.println("   Battle menu   ");
	System.out.println("-----------------");
	System.out.println();
	boolean success = false;
	boolean flee = false;
        Random rand = new Random();
	System.out.println("You have encountered a wild " + m.getName());
			   
	while(true) {
	    try {
		Thread.sleep(750);
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException ex) {}
	    System.out.println("====================\n" +
                               p.getName() + "\n" +
			       "DMG: " + p.getDmg() + "\n" +
			       "HP: " + p.getMaxHealth() + " / " + p.getHealth() + "\n" +
			       "====================\n");
			       
	    System.out.println("\t\t\t\t\t\tChoose an option: \n" + 
	    "\t\t\t\t\t\t1) Fight \n" +
	    "\t\t\t\t\t\t2) Use item \n" +
	    "\t\t\t\t\t\t3) Flee");

	    System.out.println("====================\n" +
                               m.getName() + "\n" +
			       "DMG: " + m.getDmg() + "\n" +
			       "HP: " + m.getMaxHealth() + " / " +  m.getHealth() + "\n" +
			       "====================\n");
	    Scanner sc = new Scanner(System.in);
	    while(!sc.hasNextInt()) {
		System.out.println("Thats not a number.");
		sc.next();
	    }
	    action = sc.nextInt();
	    switch(action) {
	       case 1:
		   fight(p, m);
		   if(m.getHealth() <= 0)
		       success = true;
		   break;
	       case 2:
		   p.usePot();
		   break;
	       case 3:
		   int run = rand.nextInt(2);
		   if(run == 1) {
		       flee(p, m);		     		       		     
		       break;
		   } else {
		       flee = true;
		       break;
		   }
	       default:
		   System.out.println("invalid input");
		   break;
	    }
	    if(success) {
		try {
		    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (IOException | InterruptedException ex) {}
		System.out.println( "====================\n" +
				    "Gained " + m.getXp() +  " XP\n" +
				    "Gained " + m.getMoney() + " Gold\n" +
				    "Gained " + m.getItem() + " Item(s)\n");
		p.addMoney(m.getMoney());
		p.addInv(m.getItem());
		p.addXp(m.getXp());
		p.checkLevel(p.getXp());
		m.resetHealth();
		try {
		    Thread.sleep(1500);
		} catch (InterruptedException ex) {}
		break;
	    }
	    if(flee) {
		m.resetHealth();
		break;
	    }
	}
    }
}

    
	
