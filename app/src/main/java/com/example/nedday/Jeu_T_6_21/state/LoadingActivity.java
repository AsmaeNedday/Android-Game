package com.example.nedday.Jeu_T_6_21.state;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.nedday.Jeu_T_6_21.R;



public class LoadingActivity extends AppCompatActivity {

    private static final String TAG ="LoadingActivity";



    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Intent mIntent =  new Intent(LoadingActivity.this,First.class);
            LoadingActivity.this.startActivity(mIntent);
            LoadingActivity.this.finish();
            //For The animation
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Have a full Screen
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Setting the Layout
        setContentView(R.layout.activity_loading);


        //Wait for the Loading of the Assets and Starting the Game
        handler.postDelayed(runnable,100);

    }






    }