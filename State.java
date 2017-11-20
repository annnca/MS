package da;

import java.util.Scanner;

import da.FSM.states;

public class State {
	public Transition transition;
	
	public State() {
		transition = new Transition();
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void nextState(){
		
		transition.insertCoin(FSM.coin);
		
		if(FSM.sumOfMoney < FSM.type){
			FSM.currentState = FSM.hm.get(FSM.sumOfMoney);
		}
		else {
			chooseRestart();
		}
	}

	public void chooseRestart(){
			System.out.println("Take your rest of "+ (-FSM.type + FSM.sumOfMoney) + " bani.");
			
			System.out.println("Do you want something else ? y/n");
			String choice = scanner.next();
			
			if(choice.equals("y")){
				FSM.currentState = states._0bani;
				FSM.sumOfMoney = 0;
				System.out.println("What baton do you want ?15/20/25");
				FSM.type = scanner.nextInt();
			} else {
				System.out.println("OK.Bye!");
				FSM.currentState = states.end;
			}
	}
}

