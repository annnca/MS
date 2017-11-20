package da;

public class Transition {
	
	public void insertCoin(int coin){
		FSM.sumOfMoney = FSM.sumOfMoney + coin;
		System.out.println("You have entered "+ FSM.sumOfMoney + "bani.");
	}
}
