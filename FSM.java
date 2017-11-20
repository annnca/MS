package da;

import java.util.HashMap;
import java.util.Scanner;

public class FSM {
	public enum states{
		_0bani,
		_5bani,
		_10bani,
		_15bani,
		_20bani,
		_25bani,
		end
	}
	public static HashMap<Integer,states> hm = new HashMap<Integer,states>();  
	
	public static int sumOfMoney = 0;
	public static int type;
	public static int coin;
	public static Scanner scanner = new Scanner(System.in);
	public static states currentState = states._0bani;
	
	public static void populateHM(){
		hm.put(0, states._0bani);
		hm.put(5, states._5bani);
		hm.put(10, states._10bani);
		hm.put(15, states._15bani);
		hm.put(20, states._20bani);
		hm.put(25, states._25bani);
		hm.put(1, states.end);
	}
	public static void main(String[] args) {
		populateHM();
		
		System.out.println("What baton do you want ? -> 15/20/25");
		type = scanner.nextInt();
	 
		State state = new State();
	 
		while(currentState != states.end){
		 
		 System.out.println("Enter a coin! 5/10");
		 coin = scanner.nextInt();
		 
		 switch(currentState){
			 case _0bani:
				 state.nextState();
				 break;
			 case _5bani:
				 state.nextState();
				 break;
			 case _10bani:
				 state.nextState();
				 break;
			 case _15bani:
				 state.nextState();
				 break;
			 case _20bani:
				 state.nextState();
				 break;
			 default:
				 break;
		 }
		}
	}
}