package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Receive message from MainActivity
        if (getIntent().hasExtra("NAME")){
            TextView tv = (TextView) findViewById(R.id.UserName);
            String text = getIntent().getExtras().getString("NAME");
            if (text == null || !text.equals(""))
                tv.setText("Hi, " + text + ". Welcome to my addition application.");
        }

//      ------------------------------- Back to Home page ---------------------------------------
        Button HomeButton = (Button) findViewById(R.id.HomeButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });

//      ----------- Create a variable for "addButton" for having reactions when OnClick ------------
        Button addButton = (Button) findViewById(R.id.AddButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // OnClick event
                // Link Num1, Num2 for getting its value in the app || Result for output
                EditText Num1 = (EditText) findViewById(R.id.Num1);
                EditText Num2 = (EditText) findViewById(R.id.Num2);
                TextView Result = (TextView) findViewById(R.id.Result);

                // Receive the text in Num1, Num2 -> toString -> toInteger
                String num1 = Num1.getText().toString();
                String num2 = Num2.getText().toString();
                if (num1.equals(""))
                    num1 = "0";
                if (num2.equals(""))
                    num2 = "0";

                int result = Integer.parseInt(num1) + Integer.parseInt(num2);

                // Output result to the screen
                Result.setText(result + "");
            }
        });
    }
}
