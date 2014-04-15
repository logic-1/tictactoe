package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener {
    Button button1;

    /**
     * Called when the activity is first created.
     */

//    test commit by me_1    :P changes hata dia
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1 = (Button)findViewById(R.id.nextPageButton);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent secondActivityIntent = new Intent();
        secondActivityIntent.setClass(getBaseContext(), SecondActivity.class);
        startActivity(secondActivityIntent);
    }
}
