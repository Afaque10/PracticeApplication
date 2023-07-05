package com.example.practiceapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class userAdapter extends FirebaseRecyclerAdapter
        <user,userAdapter.userViewholder>

{

    public userAdapter(
            @NonNull FirebaseRecyclerOptions<user> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull userViewholder holder,
                     int position, @NonNull user model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.Nameholder.setText(model.getName());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.Genderholder.setText(model.getGender());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.Phoneholder.setText(model.getPhoneNumber());
        holder.Dobholder.setText(model.getDob());
        holder.Addressholder.setText(model.getAddress());
    }




    public userViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout, parent, false);
        return new userAdapter.userViewholder(view);
    }

    class userViewholder
            extends RecyclerView.ViewHolder {
        TextView Nameholder,Genderholder,Phoneholder,Dobholder,Addressholder;
        public userViewholder(@NonNull View itemView)
        {
            super(itemView);

            Nameholder = itemView.findViewById(R.id.card_name);
            Genderholder = itemView.findViewById(R.id.card_gender);
            Phoneholder = itemView.findViewById(R.id.card_phonenumber);
            Dobholder = itemView.findViewById(R.id.card_dob);
            Addressholder = itemView.findViewById(R.id.card_address);
        }
    }

}
