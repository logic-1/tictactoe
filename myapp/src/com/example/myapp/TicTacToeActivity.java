package com.example.myapp;

import android.app.Activity;
/**
 * Created by DELL on 14-04-2014.
 */
public abstract class TicTacToeActivity extends Activity{

    private static boolean nextState;
    public static final String STATE_X = "X";
    public static final String STATE_O = "O";


    public String getNextButtonState() {
        setNextState(!nextState);
        return nextState ?  STATE_X : STATE_O;
    }
    private void initializeNextState(){
        nextState = true;
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
    }

    protected abstract String getGameStateFromButtonList();

    protected abstract void resetUIComponents();
    protected abstract void initializeUIComponents();
    protected abstract void updateUIOnGameFinish(String winningMessage);

}
