package da;

import java.util.HashMap;

public class SodaMachine extends StateMachine {


    public SodaMachine()
    {
        list = getActionResultHashMap();
        currentState ="0";
    }


    String transition(String action)
    {
        super.transition(action);
        System.out.println("Current state " + currentState);
        return currentState;
    }

    private static HashMap<String ,HashMap<String,String>> stateChangeHashMap = new HashMap<String,HashMap<String,String>>();
    private static HashMap<String , String> nextStateAfterActionAddedHashMap;

    private HashMap<String, HashMap<String,String>> getActionResultHashMap()
    {
        addState("0","5","5");
        addState("0","10","10");
        addState("5","5","10");
        addState("5","10","15");
        addState("10","5","15");
        addState("15","5","20");
        addState("15","10","25");
        addState("20","5","25");
        addState("10","A","0");
        addState("15","A","5");
        addState("15","B","0");
        addState("20","C","0");
        addState("25","C","5");
        return stateChangeHashMap;

    }

    public void addState(String currentState , String action , String nextState)
    {
        nextStateAfterActionAddedHashMap = stateChangeHashMap.get(currentState);
        
        if(nextStateAfterActionAddedHashMap == null)
        {
            nextStateAfterActionAddedHashMap = new HashMap<String, String>();
            stateChangeHashMap.put(currentState, nextStateAfterActionAddedHashMap);
        }
        
        nextStateAfterActionAddedHashMap.put(action, nextState);

    }
}
