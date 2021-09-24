package com.example.animotion_tuan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class ListMusic extends AppCompatActivity {
    private RecyclerView rcv_music;
    private List<Music> musicList;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);
        rcv_music = findViewById(R.id.view_music);

        musicList = new ArrayList<>();
        musicList.add(new Music(R.drawable.eclipse, "Love Story", "Taylor Swift"));
        musicList.add(new Music(R.drawable.adele, "Rolling in the Deep", "Ade"));
        musicList.add(new Music(R.drawable.justin, "Baby", "Justin Bieber"));
        musicList.add(new Music(R.drawable.diva, "Single Ladies", "Diva Beyonce"));
        musicList.add(new Music(R.drawable.katy, "Dark Hourse", "Katy Perry"));
        adapter = new Adapter(musicList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_music.setLayoutManager(linearLayoutManager);
        rcv_music.setAdapter(adapter);

    }
}