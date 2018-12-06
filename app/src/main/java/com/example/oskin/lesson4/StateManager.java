package com.example.oskin.lesson4;

class StateManager {
    private static final StateManager ourInstance = new StateManager();

    private char[] state = {'A','B','C','D','E'};
    private int currentState;

    static StateManager getInstance() {
        return ourInstance;
    }

    private StateManager() {
        currentState = 0;
    }

    public String getState(){
        if (currentState == 5)
            currentState = 0;
        return String.valueOf(state[currentState++]);
    }

}
