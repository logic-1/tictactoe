package com.example.myapp;

import android.app.Activity;
/**
 * Created by DELL on 14-04-2014.
 */
public abstract class TicTacToeActivity extends Activity{



    public static Integer xScore = 0;
    public static Integer oScore = 0;
    public static Integer drawScore = 0;
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
        this.displayScore(GameStateSingleton.getGameScore());
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

    public static int getoScore() {
        return oScore;
    }

    public static int getxScore() {
        return xScore;
    }

    public static void setxScore(int xScore) {
        TicTacToeActivity.xScore = xScore;
    }

    public static void setoScore(int oScore) {
        TicTacToeActivity.oScore = oScore;
    }

    public static int getDrawScore() {
        return drawScore;
    }

    public static void setDrawScore(int drawScore) {
        TicTacToeActivity.drawScore = drawScore;
    }

    protected abstract String getGameStateFromButtonList();

    protected abstract void resetUIComponents();
    protected abstract void initializeUIComponents();
    protected abstract void updateUIOnGameFinish(String winningMessage);

    protected abstract void displayMessage(String winningMessage);
    protected abstract void displayScore(String winningMessage);

}
