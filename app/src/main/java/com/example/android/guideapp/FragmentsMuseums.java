package com.example.android.guideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentsMuseums extends Fragment {
    private ArrayList<Info> ArrayInfo;

    public FragmentsMuseums() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_general, container, false);
        //arraylist that store the objects
        ArrayInfo = new ArrayList<Info>();
        ArrayInfo.add(new Info(getString(R.string.nameM1), getString(R.string.directionM1), R.drawable.ic_account_balance_black_24dp, getString(R.string.infoM), getString(R.string.numberM1)));//add objects(Info) to the array list
        ArrayInfo.add(new Info(getString(R.string.nameM2), getString(R.string.directionM2), R.drawable.ic_account_balance_black_24dp, getString(R.string.infoM2), getString(R.string.numberM2)));
        ArrayInfo.add(new Info(getString(R.string.nameM3), getString(R.string.directionM3), R.drawable.ic_account_balance_black_24dp, getString(R.string.infoM3), getString(R.string.numberM3)));
        ArrayInfo.add(new Info(getString(R.string.nameM4), getString(R.string.directionM4), R.drawable.ic_account_balance_black_24dp, getString(R.string.infoM4), getString(R.string.numberM4)));
        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        AdapterListeView itemAdapter = new AdapterListeView(getActivity(), ArrayInfo);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_general.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
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
    public void sendDataNowPlayingActivity(int position) {
        Intent intent = new Intent(getActivity(), Details_Activity.class);
        // bundle that hold the data of the currently playing song
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ArrayList", ArrayInfo);
        bundle.putInt("position", position);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
