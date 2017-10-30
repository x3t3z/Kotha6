package com.codelite.kr4k3rz.kotha6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codelite.kr4k3rz.kotha6.fragments.listfragments.SimpleFragmentPagerAdapter;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ListRoomActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Find the viewpager that will allow the user to swipe between fragments
        final ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        final FloatingActionButton floatingActionButton = findViewById(R.id.forward_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1), true); //getItem(-1) for previous

            }

            private int getItem(int i) {
                return viewPager.getCurrentItem() + i;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                switch (position) {
                    case 4:
                        floatingActionButton.setImageResource(R.drawable.done_icon);
                        break;
                    default:
                        floatingActionButton.setImageResource(R.drawable.ic_forward);
                        break;

                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



  /*  public void spinner_settings() {

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        adapter =
                ArrayAdapter.createFromResource(this, R.array.activity_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch(position){
                    case 0:
                        // TO-DO something when item selected
                        break;
                    case 1:
                        // TO-DO something when item selected
                        break;
                    case 2:
                        // TO-DO something when item selected
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
*/



  /*      about = (EditText) findViewById(R.id.aboutEdit);
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
                DatabaseReference roomsRef = database.getReference("rooms/" + mAuth.getCurrentUser().getUid());


                Rooms room = new Rooms();
                Users users = Paper.book().read("user");
                room.setFistName(users.getFirstName());
                room.setLastName(users.getLastName());
                room.setAbout(about.getText().toString());
                room.setLocation(location.getText().toString());
                room.setType_of_bed(type_of_bed.getText().toString());
                room.setNo_of_roomMates(no_of_room_mates.getText().toString());
                room.setDescription(description.getText().toString());
                myRef.child("rooms").setValue(room);
                roomsRef.setValue(room);


            }
        });*/


}


   /* public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        TextView dateofJoinTextView;

        public DatePickerFragment() {

        }

        public DatePickerFragment(TextView dateofJoin) {
            dateofJoinTextView = dateofJoin;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            dateofJoinTextView.setText(day + " / " + (month + 1) + " / "
                    + year);
        }
    }*/



