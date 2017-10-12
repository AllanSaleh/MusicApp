package com.example.allan.musicapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.allan.AlbumsActivity;
import com.example.allan.ArtistsActivity;
import com.example.allan.PaymentActivity;
import com.example.allan.TracksActivity;
import com.example.allan.musicapplication.databinding.ActivityMusicLibraryBinding;

public class MusicLibrary extends AppCompatActivity {

    ActivityMusicLibraryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_music_library);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_music_library);

        binding.includedTag.playlist.setImageResource(R.drawable.playlist_pressed);
        binding.includedTag.view1.setBackgroundResource(R.color.checked);

        binding.includedTag.albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicLibrary.this, AlbumsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicLibrary.this, TracksActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                finish();
            }
        });

        binding.includedTag.artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicLibrary.this, ArtistsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicLibrary.this, PaymentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.nowPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicLibrary.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}
