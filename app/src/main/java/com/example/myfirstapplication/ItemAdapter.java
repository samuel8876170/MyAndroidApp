package com.example.myfirstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// Adapter for filling the ListView with Items (name, prices, descriptions)
public class ItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private String[] items, prices, descriptions;

    ItemAdapter(Context c, String[] items, String[] prices, String[] descriptions){
        this.items = items;
        this.prices = prices;
        this.descriptions = descriptions;

        // Use mInflater to link (Context) c as destination
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    // tell the Adapter the sourceView of this.mInflater
    // -> this.mInflater know the starting point (sourceView v) and destination (Context c)
    public View getView(int position, View convertView, ViewGroup parent) {
        // mInflater.inflate() change the form of .xml to View
        View v = mInflater.inflate(R.layout.a_list_view_details, null);

        // input values into those Text boxes inside .xml file
        TextView NameTextView = (TextView) v.findViewById(R.id.NameTextView);
        TextView PriceTextView = (TextView) v.findViewById(R.id.PriceTextView);
        TextView DescriptionTextView = (TextView) v.findViewById(R.id.DescriptionTextView);

        String name = items[position];
        String description = descriptions[position];
        String price = prices[position];

        NameTextView.setText(name);
        DescriptionTextView.setText(description);
        PriceTextView.setText(price);

        return v;   // return sourceView
    }
}
