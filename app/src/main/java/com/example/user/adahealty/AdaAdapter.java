package com.example.user.adahealty;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 11/28/2017.
 */

public class AdaAdapter extends RecyclerView.Adapter<AdaAdapter.ViewHolder> {
    public ArrayList<AdaObject> ListadaObject;
    private int id ;
    private Context c;

    public AdaAdapter(ArrayList<AdaObject> value,int id,Context c) {
        this.ListadaObject = value;
        this.id = id;
        this.c = c;
    }


    public void refil(AdaObject adaObject) {
        ListadaObject.add(adaObject);
        notifyDataSetChanged();
    }

    @Override
    public AdaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaAdapter.ViewHolder holder, int position) {

        final AdaObject adaObject = ListadaObject.get(position);

        holder.button.setText(adaObject.getAnswer());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                i.putExtra("id", adaObject.getID()+id);
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ListadaObject.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button button;


        public ViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.btnYes);


        }
    }
}
