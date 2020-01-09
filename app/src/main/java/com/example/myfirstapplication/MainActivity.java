package com.example.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      -----------------------Second Activity Button Within Out Project---------------------------
        Button CalculatorButton = (Button) findViewById(R.id.CalculatorButton);
        CalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // link CalculatorApplication
                /* ApplicationContext => configuration.xml */
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);

                // pass the value: "UserName" with its name: "NAME" to SecondActivity
                EditText UserName = (EditText) findViewById(R.id.Name);
                String userName = UserName.getText().toString();
                startIntent.putExtra("NAME", userName);

                startActivity(startIntent);
            }
        });

//      -------------------------List Activity Button Within Our Project---------------------------
        Button ImageButton = (Button) findViewById(R.id.ListButton);
        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // link ListActivity
                /* ApplicationContext => configuration.xml */
                Intent goImageActivity = new Intent(getApplicationContext(),
                        ListViewActivity.class);
                startActivity(goImageActivity);
            }
        });

//      ----------------------------Activity Outside Our Project----------------------------------
        Button GoogleSearch = (Button) findViewById(R.id.GoogleSearchButton);
        GoogleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google);     // String -> universal resource identifier
                // link webAddress
                Intent ToGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                if (ToGoogle.resolveActivity(getPackageManager()) != null)
                    startActivity(ToGoogle);
            }
        });
    }
}
