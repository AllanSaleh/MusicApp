package com.example.allan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.allan.musicapplication.MusicLibrary;
import com.example.allan.musicapplication.NowPlayingActivity;
import com.example.allan.musicapplication.R;
import com.example.allan.musicapplication.databinding.ActivityArtistsBinding;

public class ArtistsActivity extends AppCompatActivity {

   ActivityArtistsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_artists);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists);

        binding.indexTag.artists.setImageResource(R.drawable.artist_pressed);
        binding.indexTag.view4.setBackgroundResource(R.color.checked);

        binding.indexTag.playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistsActivity.this, MusicLibrary.class);
                startActivity(intent);
                finish();
            }
        });

        binding.indexTag.albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistsActivity.this, AlbumsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.indexTag.tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistsActivity.this, TracksActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.indexTag.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistsActivity.this, PaymentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.nowPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistsActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}
