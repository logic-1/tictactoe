package com.example.myapp;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

/**
 * Created by DELL on 12-04-2014.
 */

public class TicTacToeButton {

    private Button button;
    private String state;

    public TicTacToeButton(final TicTacToeActivity activity, int id) {
        this.button = (Button) activity.findViewById(id);
        this.state = null;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonState(activity.getNextButtonState());
                disable();
                activity.updateGame();
            }
        });
    }

    private void setButtonState(String nextButtonState) {
        this.state = nextButtonState;
        this.button.setText(state);
    }

    public void reset(){
        setButtonState(null);
        button.setEnabled(true);
    }

    public void disable(){
        this.button.setEnabled(false);
    }

    public boolean isEnabled(){
        return this.button.isEnabled();
    }

    public String getState() {
        return state;
    }

}
