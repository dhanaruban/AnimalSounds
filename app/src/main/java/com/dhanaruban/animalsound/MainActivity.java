package com.dhanaruban.animalsound;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;

    public Integer[] gridviewSound = {
            R.raw.african_grey_parrot, R.raw.alligator,
            R.raw.alpaca, R.raw.anteater,
            R.raw.antelope, R.raw.ape,
            R.raw.bat, R.raw.bee,
            R.raw.bowhead_whale, R.raw.buffalo,
            R.raw.cat, R.raw.chicken,
            R.raw.cow, R.raw.dog,
            R.raw.dove, R.raw.duck,
            R.raw.elephant, R.raw.falcon,
            R.raw.guinea_pig, R.raw.horse,
            R.raw.humpback_whale, R.raw.leopard,
            R.raw.lion,R.raw.lizard,
            R.raw.moose,R.raw.owl,
            R.raw.panda,R.raw.penguin,
            R.raw.pig,R.raw.rabbit,
            R.raw.raccoon,R.raw.rhinoceros,
            R.raw.rooster,R.raw.sheep,
            R.raw.tiger,R.raw.turkey,
            R.raw.zebra
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                if (mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                mediaPlayer =  MediaPlayer.create(getApplicationContext(), gridviewSound[position]);
                mediaPlayer.start();
            }
        });
    }
}