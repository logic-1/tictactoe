package com.example.myapp;

/**
 * Created by DELL on 12-04-2014.
 */
public abstract class GameStateSingleton {


    private static int turnCounter = 0;
    private static char [][] grid = new char[3][3];
    private static String gameStateString;
    private static String winner;


    public static void updateGameState(String stateString){
        increment();
        gameStateString = stateString;
    }
    public static void resetGameState(){
        turnCounter = 0;
        gameStateString = null;
        for(int i=0; i<3; i++)for(int j=0; j<3; j++)
            grid[i][j] = 0;
    }
    public static void initializeGameState() {
        turnCounter = 0;
        grid = new char[3][3];
        gameStateString = null;
    }
    public static String getWinningMessage() {
        String winMsg;
        if(winner == null)
            winMsg = "DRAW";
        else
            winMsg = winner + " Won !!!";
        return winMsg;
    }
    public static boolean isGameFinished() {
        if(turnCounter < 5)
            return false;

        convertToGrid(gameStateString);

        if(checkIfPlayerWon(TicTacToeActivity.STATE_X) ){
            winner = TicTacToeActivity.STATE_X;
            return true;
        }

        if(checkIfPlayerWon(TicTacToeActivity.STATE_O)){
            winner = TicTacToeActivity.STATE_O;
            return true;
        }

        if(turnCounter == 9){
            winner = null;
            return true;
        }

        return false;
    }

    private static boolean increment(){
        if(turnCounter == 9)
            return false;
        turnCounter++;
        return true;
    }

    private static void convertToGrid(String stateString) {

        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                char state = stateString.charAt(3 * i + j);
                grid[i][j] = state == '.' ? 0 : state;
            }
    }

    private static boolean checkIfPlayerWon(String sPlayer) {
        //find if player has a streak
        char player = sPlayer.charAt(0);
        if(grid[1][1] == player && grid[0][0] == player && grid[2][2] == player)
            return true;
        if(grid[1][1] == player && grid[2][0] == player && grid[0][2] == player)
            return true;

        for(int i=0;i<3;i++)
                if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player)
                    return true;

        for(int i=0;i<3;i++)
                if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)
                    return true;

        return false;
    }


}
