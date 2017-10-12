package com.example.allan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.allan.musicapplication.MusicLibrary;
import com.example.allan.musicapplication.R;
import com.example.allan.musicapplication.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_payment);

        binding.includedTag.payment.setImageResource(R.drawable.payment_pressed);
        binding.includedTag.view5.setBackgroundResource(R.color.checked);

        binding.includedTag.playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, MusicLibrary.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, AlbumsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, TracksActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.includedTag.artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, ArtistsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
