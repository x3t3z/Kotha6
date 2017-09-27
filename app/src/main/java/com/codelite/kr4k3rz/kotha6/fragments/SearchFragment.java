package com.codelite.kr4k3rz.kotha6.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codelite.kr4k3rz.kotha6.ListRoomActivity;
import com.codelite.kr4k3rz.kotha6.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search_room, container, false);
        Button addListBtn = (Button) rootView.findViewById(R.id.addSpareRoomBtn);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_listRoom);
        addListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListRoomActivity.class));
            }
        });

        return rootView;
    }
}
