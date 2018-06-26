package com.example.allan;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.allan.musicapplication.R;
import com.example.allan.musicapplication.databinding.ActivityNowPlayingBinding;

import java.util.Timer;
import java.util.TimerTask;

public class NowPlayingActivity extends AppCompatActivity {

    ActivityNowPlayingBinding binding;


    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_now_playing);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_now_playing);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        binding.setMPlayer(MediaPlayer.create(this, R.raw.changes));

        binding.getMPlayer().seekTo(preferences.getInt("POSITION",0));

        binding.seekBar.setMax(binding.getMPlayer().getDuration());

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                binding.seekBar.setProgress(binding.getMPlayer().getCurrentPosition());
            }
        }, 0, 1000);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.getMPlayer().isPlaying()) {
                    binding.getMPlayer().start();
                    binding.play.setImageResource(R.drawable.pause);
                } else {
                    binding.getMPlayer().pause();
                    binding.play.setImageResource(R.drawable.plat_fill);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        binding.getMPlayer().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("POSITION",binding.getMPlayer().getCurrentPosition());
        editor.apply();
        timer.cancel();
        binding.getMPlayer().release();
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        binding.getMPlayer().pause();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
