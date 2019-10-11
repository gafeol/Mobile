package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    public static final String REPLY = "com.example.android.shoppinglist.extra.REPLY";

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mButton = findViewById(R.id.button1);
    }

    public void returnItem(View view) {
        mButton = (Button)view;
        String mButtonText = mButton.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra(REPLY, mButtonText);
        setResult(RESULT_OK, returnIntent);
        //mButton.setVisibility(View.INVISIBLE);
        finish();

    }
}
