package com.example.android.guideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentHotels extends Fragment {
    private  ArrayList<Info> ArrayInfo;
    public FragmentHotels() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_general, container, false);
        //arraylist that store the objects
        ArrayInfo= new ArrayList<Info>();
        ArrayInfo.add(new Info(getString(R.string.nameH1),getString(R.string.directionH1),R.drawable.ic_hotel_black_24dp,getString(R.string.infoH),getString(R.string.numberH1)));//add objects(Info) to the array list
        ArrayInfo.add(new Info(getString(R.string.nameH2),getString(R.string.directionH2),R.drawable.ic_hotel_black_24dp,getString(R.string.infoH2),getString(R.string.numberH2)));
        ArrayInfo.add(new Info(getString(R.string.nameH3),getString(R.string.directionH3),R.drawable.ic_hotel_black_24dp,getString(R.string.infoH3),getString(R.string.numberH3)));
        ArrayInfo.add(new Info(getString(R.string.nameH4),getString(R.string.directionH4),R.drawable.ic_hotel_black_24dp,getString(R.string.infoH4),getString(R.string.numberH4)));
        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        AdapterListeView itemAdapter=new AdapterListeView(getActivity(),ArrayInfo);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_general.xml layout file.
        ListView listView=(ListView) rootView.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendDataNowPlayingActivity(position);
            }
        });
        return rootView;
    }
    ///methode that send data to the now playing activity combinig bundle and intent.
    public void sendDataNowPlayingActivity(int position){
        Intent intent = new Intent(getActivity(), Details_Activity.class);
        // bundle that hold the data of the currently playing song
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ArrayList", ArrayInfo);
        bundle.putInt("position",position);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
