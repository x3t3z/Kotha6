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
public class RoomDescFragment extends Fragment {


    public RoomDescFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room_description, container, false);
    }

}
