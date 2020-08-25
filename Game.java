package rpg;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Game {

    public static int menu() {
	try {
	    Thread.sleep(1000);
	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} catch (IOException | InterruptedException ex) {}
	int action = 0;
	System.out.println();
	System.out.println("Choose an option: \n" +
			   "------------------\n" +
	"1) Fight \n" +
	"2) Shop \n" +
        "3) Inventory \n" +
        "4) Stats \n" +			   
	"5) Quit\n");
	Scanner sc = new Scanner(System.in);
	while(!sc.hasNextInt()) {
	    System.out.println("Thats not a number.");
	    sc.next();
	}
	action = sc.nextInt();	
	
	return action;
    }

    public static void stats(Player p) {
        System.out.println("HP: " + p.getHealth()
	+ "     Money: " + p.getMoney());
    }

    public static void inventory(Player p) {
       p.getInv();
    }

    public static void space(int i) {
       if( i < 0 || i > 10) {
           System.out.println();
       } else {
           for(int x = 0; x <= i; x++) 
	     System.out.println();
       }
    }


    public static void main(String[] args) {
        space(2);
	System.out.println("   Welcome to my RPG   ");
	space(4);
	ArrayList<String> al = new ArrayList<String>();
	Player p = new Player("Junior", 1, 99, 99, 50, 4, 0, al);
	Monster m = new Monster("Toad", 3, "stone", 10, 30, 30, 20);
	
	while(true) {	    
	    int action = menu();
	    switch(action) {
 	       case 1:
	       	   System.out.println("You selected batte");
		   Battle b = new Battle();
		   b.battleMenu(p, m);
		   break;
	       case 2:
		   Shop s = new Shop();
		   s.display(p);
		   break;
	       case 3:
	           p.getInv();
		   break;
       	       case 4:
	           p.getStats();
		   break;
       	       case 5:
	           System.out.println("You have exited the game");
		   System.exit(0);
	       default:
	       	   System.out.println("invalid input");
		   break;
	     }
	     
	}
    }
}
