package com.example.user.adahealty;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

public class AdaAdapter extends RecyclerView.Adapter<AdaAdapter.ViewHolder>{

    private final Context mcontext;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

    private List<AdaObject>ListadaObject = new ArrayList<>();

    String Key;

    public AdaAdapter(Context context){
        mcontext = context;
    }

    public void refil(List<AdaObject> adaObject){
        adaObject.clear();
        adaObject.addAll(adaObject);
        notifyDataSetChanged();
    }

    @Override
    public AdaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaAdapter.ViewHolder holder, int position) {

        final AdaObject adaObject = ListadaObject.get(position);

        holder.txtQuestion.setText(adaObject.getQuestion());
        holder.btnYes.setText(adaObject.getAnswer());
        holder.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("ada").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                            AdaObject adaTemp = snapshot.getValue(AdaObject.class);
                            if (adaObject.getQuestion().equals(adaTemp.getQuestion())){

                                ListadaObject.add(dataSnapshot.getValue(AdaObject.class));

                                String data = dataSnapshot.getKey();

                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btnYes,btnNo;
        TextView txtQuestion;

        public ViewHolder(View itemView) {
            super(itemView);

            btnNo = (Button)itemView.findViewById(R.id.btnNo);
            btnYes= (Button)itemView.findViewById(R.id.btnYes);
            txtQuestion = (TextView) itemView.findViewById(R.id.txtQuestion);

        }
    }
}
