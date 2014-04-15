package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 12-04-2014.
 */
public class SecondActivity extends TicTacToeActivity{

    private List<TicTacToeButton> buttons;
    private TextView winningMessage;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeGame();
    }

    public void initializeUIComponents() {

        setContentView(R.layout.secondactivity);

        winningMessage = (TextView)findViewById(R.id.gameState);
        winningMessage.setVisibility(View.INVISIBLE);

        buttons = new ArrayList<TicTacToeButton>(9);
        buttons.add(0, new TicTacToeButton(this, R.id.button1));
        buttons.add(1, new TicTacToeButton(this, R.id.button2));
        buttons.add(2, new TicTacToeButton(this, R.id.button3));
        buttons.add(3, new TicTacToeButton(this, R.id.button4));
        buttons.add(4, new TicTacToeButton(this, R.id.button5));
        buttons.add(5, new TicTacToeButton(this, R.id.button6));
        buttons.add(6, new TicTacToeButton(this, R.id.button7));
        buttons.add(7, new TicTacToeButton(this, R.id.button8));
        buttons.add(8, new TicTacToeButton(this, R.id.button9));

        resetButton = (Button)findViewById(R.id.resetbutton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.this.resetGame();
            }
        });
    }

    @Override
    protected void updateUIOnGameFinish(String message) {
        winningMessage.setText(message);
        winningMessage.setVisibility(View.VISIBLE);
        for (TicTacToeButton button : buttons)
            button.disable();
    }

    @Override
    protected String getGameStateFromButtonList() {
        String stateString = "";
        for(TicTacToeButton button : buttons)
            stateString = stateString + (button.getState() == null ? "." : button.getState()) ;
        return stateString;
    }

    public void resetUIComponents() {
        winningMessage.setVisibility(View.INVISIBLE);
        for(TicTacToeButton button : buttons)
            button.reset();
    }

}