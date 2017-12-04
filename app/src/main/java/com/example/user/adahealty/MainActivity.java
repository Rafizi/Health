package com.example.user.adahealty;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView rvbutton;
    AdaAdapter adaAdapter;
    TextView txtdeskripsi, txtQues;
    DatabaseReference databaseReference;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //insisalisasi
        txtQues = (TextView) findViewById(R.id.txtQues);
        rvbutton = (RecyclerView) findViewById(R.id.rvbutton);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvbutton.setLayoutManager(layoutManager);




        if (getIntent().getExtras()!= null){
            i = getIntent().getIntExtra("id",0);
        }
        adaAdapter = new AdaAdapter(new ArrayList<AdaObject>(),i,MainActivity.this);
        rvbutton.setAdapter(adaAdapter);

        txtdeskripsi = (TextView) findViewById(R.id.txtada);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        setAnim();

        databaseReference.child("ada").child(String.valueOf(i)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getKey().equals("answer")) {
                        databaseReference.child("ada").child(String.valueOf(i)).child("answer").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Integer id = Integer.parseInt(snapshot.getKey());
                                    AdaObject adaObject = new AdaObject(id,snapshot.getValue().toString());
                                    adaAdapter.refil(adaObject);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.e(TAG, "Failed to read app title value.", databaseError.toException());
                            }
                        });
                    }

                    if (snapshot.getKey().equals("question")) {
                        txtQues.setText(snapshot.getValue().toString());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Failed to read app title value.", databaseError.toException());
            }
        });

    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_fade_in);
        rvbutton.setAnimation(animation_fade_in);
        txtdeskripsi.setAnimation(animation_card_in);
        txtQues.setAnimation(animation_card_in);
    }
}