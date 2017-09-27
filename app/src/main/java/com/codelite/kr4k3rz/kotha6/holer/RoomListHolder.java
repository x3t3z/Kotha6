package com.codelite.kr4k3rz.kotha6.holer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.codelite.kr4k3rz.kotha6.R;


public class RoomListHolder extends RecyclerView.ViewHolder {
    private TextView tv_FirstName, tv_lastName, tv_about, tv_location, tv_typeOfBed, tv_no_of_roomMates, tv_description;

    public RoomListHolder(View itemView) {
        super(itemView);
        tv_FirstName = (TextView) itemView.findViewById(R.id.item_firstName);
        tv_lastName = (TextView) itemView.findViewById(R.id.item_lastName);
        tv_about = (TextView) itemView.findViewById(R.id.item_about);
        tv_location = (TextView) itemView.findViewById(R.id.item_location);
        tv_typeOfBed = (TextView) itemView.findViewById(R.id.item_typeofBed);
        tv_no_of_roomMates = (TextView) itemView.findViewById(R.id.item_noOfRoomMates);
        tv_description = (TextView) itemView.findViewById(R.id.item_description);
    }

    public void setTv_firstName(String firstName) {
        tv_FirstName.setText(firstName);
    }

    public void setTv_lastName(String lastName) {
        tv_lastName.setText(lastName);
    }

    public void setTv_about(String about) {
        tv_about.setText(about);
    }

    public void setTv_location(String location) {
        tv_location.setText(location);
    }

    public void setTv_typeOfBed(String typeOfBed) {
        tv_typeOfBed.setText(typeOfBed);
    }

    public void setNo_of_roomMates(String no_of_roomMates) {
        tv_no_of_roomMates.setText(no_of_roomMates);
    }

    public void setTv_description(String description) {
        tv_description.setText(description);
    }


}
