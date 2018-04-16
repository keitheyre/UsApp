package com.example.keitheyre.usapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keitheyre.usapp.Models.UserProfileModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Home extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    FirebaseFirestore mDatabase;
    DocumentReference mUserProfileRef;

    private UserProfileModel user;

    private TextView textView_welcome;

    private Button button_find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseFirestore.getInstance();
        mUserProfileRef = mDatabase.collection("users").document(mAuth.getCurrentUser().getUid());

        mUserProfileRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(UserProfileModel.class);
                textView_welcome.setText("Welcome, " + user.getfull_name());


                if(user.getchatroom_id() == null) {
                    button_find.setVisibility(View.VISIBLE);
                    Toast.makeText(Home.this, "You have no partner... ", Toast.LENGTH_SHORT).show();
                } else {
                    button_find.setVisibility(View.GONE);
                }
            }
        });

        textView_welcome = (TextView) findViewById(R.id.textView_welcome);
        button_find = (Button) findViewById(R.id.button_find);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_find:

                break;

            default:
                break;
        }
    }
}
