package com.example.myapp;

import android.app.Activity;
/**
 * Created by DELL on 14-04-2014.
 */
public abstract class TicTacToeActivity extends Activity{



    private static boolean nextState;
    private static boolean startState;
    public static final String STATE_X = "X";
    public static final String STATE_O = "O";

    public static boolean isNextState() {
        return nextState;
    }

    public String getNextButtonState() {
        setNextState(!nextState);
        return nextState ?  STATE_X : STATE_O;
    }
    protected String getNextPlayerMessage() {
        String message = nextState ?  STATE_O : STATE_X;
        return message + "'s Turn";
    }

    public String getNextPlayer(){
        return nextState ? STATE_X : STATE_O;
    }
    private void initializeNextState(){
        startState = !startState;
        nextState = startState;

    }
    private void setNextState(boolean state){
        nextState = state;
    }
    private void resetNextState() {
        initializeNextState();
    }

    public void initializeGame() {
        initializeNextState();
        this.initializeUIComponents();
        GameStateSingleton.initializeGameState();
        this.displayMessage(getNextPlayerMessage());
    }

    public void resetGame(){
        resetNextState();
        GameStateSingleton.resetGameState();
        this.resetUIComponents();
    }

    public void updateGame() {
        GameStateSingleton.updateGameState(this.getGameStateFromButtonList());
        if(GameStateSingleton.isGameFinished()){
            this.updateUIOnGameFinish(GameStateSingleton.getWinningMessage());
        }
        else{
            this.displayMessage(getNextPlayerMessage());
        }

    }

    protected abstract String getGameStateFromButtonList();

    protected abstract void resetUIComponents();
    protected abstract void initializeUIComponents();
    protected abstract void updateUIOnGameFinish(String winningMessage);

    protected abstract void displayMessage(String winningMessage);

}
