


package football.world.cup;

import java.util.Scanner;


public class Menu {
    
    public static String display()
    {
        System.out.println("************************Menu*************************");
        System.out.println("A.  Play Preliminary Stage");
        System.out.println("B.  Play Final");
        System.out.println("C.  Display Teams ");
        System.out.println("D.  Display Players ");
        System.out.println("E.  Display Cup Result ");
        System.out.println("X.  Close");
        
        System.out.print("Enter your choice : ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        choice.trim();
        choice.toUpperCase();
        
        return choice;
        
    }

}
