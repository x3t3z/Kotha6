package com.codelite.kr4k3rz.kotha6.fragments.listfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codelite.kr4k3rz.kotha6.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomLocationFragment extends Fragment {
    public RoomLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_room_location, container, false);

        return view;
    }

}
