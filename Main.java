package da;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        SodaMachine sodaMachine = new SodaMachine();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Sum entered: ");
        
        String action = scan.nextLine();
        String currentValue = sodaMachine.transition(action);
        
        while(!action.equals("q"))
        {
            System.out.println("1.Enter money(5/10)");
            System.out.println("2. Buy soda (A/ B/ C)");
            
            action = scan.nextLine();
            
            if(action.equals("1"))
            {
                System.out.println("How much do you want to enter : ");
                action = scan.nextLine();
                
                currentValue = sodaMachine.transition(action);

            } else if(action.equals("2"))
            {
                System.out.println("What soda do you want? ");
                
                action = scan.nextLine();
                
                currentValue = sodaMachine.transition(action);
            } else {
                System.out.println("Operation failed");
            }
            if(currentValue == null)
            {
                System.out.println("Operation failed");
            }else if(currentValue.equals("0"))
            {
                return;
            }
        }
    }
}




