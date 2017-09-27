package com.codelite.kr4k3rz.kotha6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codelite.kr4k3rz.kotha6.model.ListRoom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListRoomActivity extends AppCompatActivity {
    EditText about, location, type_of_bed, no_of_room_mates, description;
    Button list_Room;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);
        about = (EditText) findViewById(R.id.aboutEdit);
        location = (EditText) findViewById(R.id.locationEdit);
        type_of_bed = (EditText) findViewById(R.id.typeOfBedEdit);
        no_of_room_mates = (EditText) findViewById(R.id.noOfRoomMatesEdit);
        description = (EditText) findViewById(R.id.descriptionEdit);
        list_Room = (Button) findViewById(R.id.addListBtn);
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        list_Room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users/" + mAuth.getCurrentUser().getUid());


                ListRoom room = new ListRoom();
                room.setAbout(about.getText().toString());
                room.setLocation(location.getText().toString());
                room.setType_of_bed(type_of_bed.getText().toString());
                room.setNo_of_roomMates(no_of_room_mates.getText().toString());
                room.setDescription(description.getText().toString());
                myRef.child("listRooms").setValue(room);

            }
        });


    }
}
