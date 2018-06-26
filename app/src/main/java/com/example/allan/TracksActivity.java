package com.example.allan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.allan.musicapplication.R;
import com.example.allan.musicapplication.databinding.ActivityTracksBinding;

public class TracksActivity extends AppCompatActivity {

    ActivityTracksBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tracks);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_tracks);

        binding.includedTag.tracks.setImageResource(R.drawable.music_note_pressed);
        binding.includedTag.view2.setBackgroundResource(R.color.checked);

        binding.includedTag.playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TracksActivity.this, MusicLibrary.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TracksActivity.this, AlbumsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TracksActivity.this, ArtistsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TracksActivity.this, PaymentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.nowPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TracksActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}
