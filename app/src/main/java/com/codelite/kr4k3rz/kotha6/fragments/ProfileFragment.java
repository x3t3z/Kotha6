package com.codelite.kr4k3rz.kotha6.fragments;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codelite.kr4k3rz.kotha6.ListRoomActivity;
import com.codelite.kr4k3rz.kotha6.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.google.firebase.auth.FirebaseAuth.getInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public static final int GET_FROM_GALLERY = 3;
    Uri selectedImage;
    ImageView profileImageView;
    TextView _firstName, _lastName;
    FloatingActionButton fab_addListing;
    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;


    public ProfileFragment() {
        // Required empty public constructor
        selectedImage = null;
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        _firstName = rootView.findViewById(R.id.firstName);
        _lastName = rootView.findViewById(R.id.lastName);
        profileImageView = rootView.findViewById(R.id.profileImage);
        fab_addListing = rootView.findViewById(R.id.floating_action_button);

        FirebaseUser user = getInstance().getCurrentUser();
        mAuth = getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        fab_addListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListRoomActivity.class));
            }
        });

        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            final String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("users/" + mAuth.getCurrentUser().getUid());
            profileImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
                }
            });

/*
            final StorageReference riversRef = mStorageRef.child("profiles/" + mAuth.getCurrentUser().getUid());
*//*

            uploadBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));

                    riversRef.putFile(selectedImage)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Get a URL to the uploaded content
                                    // Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                    //Log.d("TAG", taskSnapshot.getDownloadUrl() + "");

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle unsuccessful uploads
                                    // ...
                                }
                            });


                }
            });
*//*


            //Glide.with(getActivity()).using(new FirebaseImageLoader()).load(riversRef).into(profileImageView);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Users name = dataSnapshot.getValue(Users.class);
                    emailID.setText("FirstName:" + name.getFirstName() + "\n" + "LastName:" + name.getLastName());

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
            Log.d("TAG", "name:" + name + "\n" + "email:" + email + "photoURl:" + photoUrl);*/
        }

        return rootView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            selectedImage = data.getData();
            Log.d("TAG", "imageURi" + selectedImage);

            Glide.with(getActivity())
                    .load(selectedImage).fitCenter().centerCrop().into(profileImageView);


        }
    }

}
