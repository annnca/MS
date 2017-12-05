package da;

import java.util.HashMap;

public class StateMachine {
   
	String currentState;
    
    HashMap<String, HashMap<String, String>> list;

    StateMachine() {
    	
    }

    String transition(String action)
    {
        String value = list.get(currentState).get(action);
        
        if(value != null)
        {
            currentState = value;
        }

        return currentState;
    }
}
