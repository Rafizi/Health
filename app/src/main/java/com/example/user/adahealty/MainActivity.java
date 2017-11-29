package com.example.user.adahealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvbutton;
    AdaAdapter adaAdapter;

    TextView txtdeskripsi;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //insisalisasi
        rvbutton = (RecyclerView)findViewById(R.id.rvbutton);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext());
        rvbutton.setHasFixedSize(true);
        rvbutton.setLayoutManager(layoutManager);

        txtdeskripsi = (TextView)findViewById(R.id.txt1);

        databaseReference.getDatabase().getReference();

        databaseReference.child("ada").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren() ){
                   AdaObject adaObject = snapshot.getValue(AdaObject.class);
                   if (adaObject.getQuestion().equals(adaObject)){

                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
