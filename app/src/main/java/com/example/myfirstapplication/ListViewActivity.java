package com.example.myfirstapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
    ListView aListView;
    String[] items, prices, descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Resources res = getResources();
        aListView = (ListView) findViewById(R.id.aListView);
        // R.array gets variables from res.values
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        // Context c: destination of linkage (this class + list_view.xml)
        // here we also need items, prices, descriptions cuz we want these data
        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);

        // indirectly call ItemAdapter.getView() -> link two .xml files
        aListView.setAdapter(itemAdapter);


        // for (ListView), use .setOnItemClickListener()    **not the same as (Button)
        aListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                Intent showImage = new Intent(getApplicationContext(), ImageDetailActivity.class);
                // send the index of the item which is OnClick
                showImage.putExtra("com.example.ITEM_INDEX", position);
                startActivity(showImage);
            }
        });

    }
}
