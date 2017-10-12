package com.example.allan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.allan.musicapplication.MusicLibrary;
import com.example.allan.musicapplication.NowPlayingActivity;
import com.example.allan.musicapplication.R;
import com.example.allan.musicapplication.databinding.ActivityAlbumsBinding;

public class AlbumsActivity extends AppCompatActivity {

    ActivityAlbumsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_albums);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_albums);

        binding.includedTag.albums.setImageResource(R.drawable.album_pressed);
        binding.includedTag.view3.setBackgroundResource(R.color.checked);

        binding.includedTag.playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlbumsActivity.this, MusicLibrary.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlbumsActivity.this, TracksActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlbumsActivity.this, ArtistsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlbumsActivity.this, PaymentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.nowPlayingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlbumsActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}
