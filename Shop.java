package rpg;

import java.util.Scanner;
import java.io.IOException;

public class Shop {

    public void display(Player p) {
        int option = 0;
	boolean leave = false;
	while(true) {
	    try {
		Thread.sleep(1000);
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException ex) {}
	    System.out.println();
	    System.out.println("   Welcome to the Shop   ");
	    System.out.println("-------------------------");
            System.out.println("1) Small Potion: 20 hp, 30g\n" +
			       "2) Leave shop \n");
	    Scanner sc = new Scanner(System.in);
	    while(!sc.hasNextInt()) {
		System.out.println("Thats not a number.");
		sc.next();
	    }
	    option = sc.nextInt();
	    
	    switch(option) {
	        case 1:
		    if(p.getMoney() >= 20) {
			System.out.println("You have purchased a small pot.");
			p.removeMoney(20);
			p.addInv("small pot");
		    } else {
			System.out.println("You don't have enough money");
		    }
		    break;
                 case 2:
		    System.out.println("You have left the shop");
		    leave = true;
		    break;
    	         default:
	       	    System.out.println("invalid input");
		    break;
	    }
	    if(leave)
		break;
	}
    }
}

		
	    
