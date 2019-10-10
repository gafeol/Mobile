package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final  int TEXT_REQUEST = 1;
    private TextView[] mReturnedItems = new TextView[10];
    private int textViewCount = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter", textViewCount);
        outState.putString("text0", mReturnedItems[0].getText().toString());
        outState.putString("text1", mReturnedItems[1].getText().toString());
        outState.putString("text2", mReturnedItems[2].getText().toString());
        outState.putString("text3", mReturnedItems[3].getText().toString());
        outState.putString("text4", mReturnedItems[4].getText().toString());
        outState.putString("text5", mReturnedItems[5].getText().toString());
        outState.putString("text6", mReturnedItems[6].getText().toString());
        outState.putString("text7", mReturnedItems[7].getText().toString());
        outState.putString("text8", mReturnedItems[8].getText().toString());
        outState.putString("text9", mReturnedItems[9].getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReturnedItems[0] = findViewById(R.id.textView1);
        mReturnedItems[1] = findViewById(R.id.textView2);
        mReturnedItems[2] = findViewById(R.id.textView3);
        mReturnedItems[3] = findViewById(R.id.textView4);
        mReturnedItems[4] = findViewById(R.id.textView5);
        mReturnedItems[5] = findViewById(R.id.textView6);
        mReturnedItems[6] = findViewById(R.id.textView7);
        mReturnedItems[7] = findViewById(R.id.textView8);
        mReturnedItems[8] = findViewById(R.id.textView9);
        mReturnedItems[9] = findViewById(R.id.textView10);

        if(savedInstanceState != null){
            textViewCount = savedInstanceState.getInt("counter");
            mReturnedItems[0].setText(savedInstanceState.getString("text0"));
            mReturnedItems[1].setText(savedInstanceState.getString("text1"));
            mReturnedItems[2].setText(savedInstanceState.getString("text2"));
            mReturnedItems[3].setText(savedInstanceState.getString("text3"));
            mReturnedItems[4].setText(savedInstanceState.getString("text4"));
            mReturnedItems[5].setText(savedInstanceState.getString("text5"));
            mReturnedItems[6].setText(savedInstanceState.getString("text6"));
            mReturnedItems[7].setText(savedInstanceState.getString("text7"));
            mReturnedItems[8].setText(savedInstanceState.getString("text8"));
            mReturnedItems[9].setText(savedInstanceState.getString("text9"));

        }
    }


    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(Main2Activity.REPLY);
                mReturnedItems[textViewCount].setText(reply);
                //mReturnedItems[textViewCount].setTypeface(mReturnedItems[textViewCount].getTypeface(), Typeface.BOLD);
                textViewCount++;
            }
        }
    }
}