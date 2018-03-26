package com.example.android.guideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sam on 01/07/2017.
 */

public class AdapterListeView extends ArrayAdapter<Info> {
    public AdapterListeView(Activity context, ArrayList<Info> ArrayInfo) {
        super(context, 0, ArrayInfo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items_view, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        final Info currentword = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView TITLE = (TextView) listItemView.findViewById(R.id.text11);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        TITLE.setText(currentword.getmName());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView ARTIST = (TextView) listItemView.findViewById(R.id.text22);
        // Get the version number from the current AndroidFlavor object and
        //set this text on the number TextView
        ARTIST.setText(currentword.getmDirection());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentword.getmImage());
        return listItemView;
    }
}
