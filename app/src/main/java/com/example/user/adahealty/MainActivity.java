package com.example.user.adahealty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

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
        txtdeskripsi = (TextView)findViewById(R.id.txt1);

    }
}
