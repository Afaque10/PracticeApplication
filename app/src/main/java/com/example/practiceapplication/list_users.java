package com.example.practiceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class list_users extends AppCompatActivity {

    private RecyclerView recyclerView;
    userAdapter adapter;
    DatabaseReference mbase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        mbase= FirebaseDatabase.getInstance().getReference();
        recyclerView = findViewById(R.id.user_recyclerview);


        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        FirebaseRecyclerOptions<user> options
                = new FirebaseRecyclerOptions.Builder<user>()
                .setQuery(mbase,user.class)
                .build();
        adapter = new userAdapter(options);
        recyclerView.setAdapter(adapter);
    }
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }


}