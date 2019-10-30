package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final  int TEXT_REQUEST = 1;
    private TextView[] mReturnedItems = new TextView[10];
    private int textViewCount = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter", textViewCount);

        String key;

        for(int i = 0; i < 10; i++){
            key = "text" + i;
            outState.putString(key, mReturnedItems[i].getText().toString());
        }

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

            String key;

            for(int i = 0; i < 10; i++){
                key = "text" + i;
                mReturnedItems[i].setText(savedInstanceState.getString(key));
            }
        }
    }


    public void launchSecondActivity(View view) {
        if(textViewCount == 10){
            Toast.makeText(this, "You've reached the maximum amount of elements!", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, ItemsMenu.class);
            startActivityForResult(intent, TEXT_REQUEST);
        }
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(ItemsMenu.REPLY);
                mReturnedItems[textViewCount].setText(reply);
                //mReturnedItems[textViewCount].setTypeface(mReturnedItems[textViewCount].getTypeface(), Typeface.BOLD);
                textViewCount++;
            }
        }
    }
}