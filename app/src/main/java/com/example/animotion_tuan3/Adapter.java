package com.example.animotion_tuan3;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.MusicViewHolder> {
    List<Music> musicList;

    public Adapter(List<Music> musicList) {
        this.musicList = musicList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item, parent, false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
            Music music = musicList.get(position);
            holder.imgMusic.setImageResource(music.getImgSing());
            holder.tvSingName.setText(music.getSingName());
            holder.tvSingerName.setText(music.getSingerName());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imgMusic;
        private LinearLayout layout;
        private TextView tvSingName, tvSingerName;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            imgMusic = itemView.findViewById(R.id.img_music);
            tvSingerName = itemView.findViewById(R.id.singer_name);
            tvSingName = itemView.findViewById(R.id.sing_name);

            layout.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {

                    Intent shareIntent = new Intent(itemView.getContext(), MainActivity.class);
                    Pair[] pair = new Pair[1];
                    pair[0] = new Pair<View, String>(imgMusic,"img_sing");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) itemView.getContext(), pair);
                    itemView.getContext().startActivity(shareIntent, options.toBundle());
                }
            });
        }
    }
}
