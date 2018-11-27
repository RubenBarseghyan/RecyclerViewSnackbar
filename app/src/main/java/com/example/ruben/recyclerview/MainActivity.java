package com.example.ruben.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;


public class
MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> data;
    private Button button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        data = new ArrayList<>();
        data.add("Babken");
        data.add("Varuj");
        data.add("Tatev");
        ;


        recyclerView = findViewById(R.id.recuclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        final SimpleAdapter adapter = new SimpleAdapter(data);
        recyclerView.setAdapter(adapter);

        button = findViewById(R.id.addBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data.add(0, "Karen");
                adapter.notifyItemInserted(0);
            }
        });
    }

}
