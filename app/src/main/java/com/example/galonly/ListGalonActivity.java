package com.example.galonly;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListGalonActivity extends AppCompatActivity {
    private RecyclerView rvGalon;
    private final ArrayList<Galon> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galon_list);

        rvGalon = findViewById(R.id.rv_club);
        rvGalon.setHasFixedSize(true);

        list.addAll(GalonData.getListData());
        showRecayclerList();
    }

    private void showRecayclerList(){
        rvGalon.setLayoutManager(new LinearLayoutManager(this));
        ListGalonAdapter listClubAdapter = new ListGalonAdapter(list);
        rvGalon.setAdapter(listClubAdapter);

        listClubAdapter.setOnItemClickCallback(new ListGalonAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Galon club){
                Intent moveIntent = new Intent ( ListGalonActivity.this, DetailGalonActivity.class);
                moveIntent.putExtra(DetailGalonActivity.ITEM_EXTRA, club);
                startActivity(moveIntent);
            }
        });
    }


}