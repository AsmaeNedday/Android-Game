package com.example.nedday.Jeu_T_6_21.state;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.example.ensias_auth_library.models.GameStat;
import com.example.nedday.Jeu_T_6_21.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.nedday.Jeu_T_6_21.state.First.mp;
import static com.example.nedday.Jeu_T_6_21.state.PopupActivity.muet;


public class Menu_jouer extends AppCompatActivity {

    Button a1,a2,a3,music;
    Dialog myDialog;
    public static int win_score;
    public static int lose_score;
    public static ArrayList<Integer> array_L;
    public static GameStat gameStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Have a full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_play);


        myDialog = new Dialog(this);
        a1 = (Button) findViewById(R.id.a1);
        a2=  (Button) findViewById(R.id.a2);
        a3=  (Button) findViewById(R.id.a3);
        music = (Button) findViewById(R.id.music);


        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mp.isPlaying()){
                    mp.pause();
                    music.setBackgroundResource(R.drawable.muet);
                    muet=1;
                }
                else{
                    mp.start();
                    music.setBackgroundResource(R.drawable.volume);
                    muet=0;
                }

            }

        });



        switch (PopupActivity.langue)
        {
            case 0:  a1.setText("Theme 1"); a2.setText("Theme 2"); a3.setText("Theme3"); break;
            case 1:  a1.setText("الموضوع 1");a2.setText("الموضوع 2") ; a3.setText("الموضوع 3") ;break;
            case 2 : a1.setText("Theme 1"); a2.setText("Theme 2"); a3.setText("Theme3");break;
            case 3:  a1.setText("الموضوع 1");a2.setText("الموضوع 2") ; a3.setText("الموضوع 3") ;break;
        }

        /** le debut du traitement du level 1 */
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myDialog.setContentView(R.layout.popup_play_niveau1);


                PopupActivity.niveau=1;
                Level();

            }

        });

        /** Le debut du traitement du level 2 */
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myDialog.setContentView(R.layout.popup_play_niveau2);
                PopupActivity.niveau=2;
                Level();

            }

        });

        /**Le debut du traitement du level 3 **/
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupActivity.niveau=3;
                Level();
            }

        });




    }

    public void onClick(View v){
        if(v.getId() == R.id.home){
            this.finish();
        }

    }

    public void Level()
    {
        gameStat = new GameStat();

        System.out.println("j'eeeeeeeeeeeeeeeeeeeeeeeennnnnnnnnntreeeeeeeeee");


        array_L = new ArrayList<Integer>();
        win_score=0;
        lose_score=0;
        //stocker date d'entree au level
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");
        String currentDate = sdf.format(new Date());
        gameStat.setCreated_at(currentDate);
        System.out.println("Entreeeeeeeeeeeeeee level" + currentDate);
        gameStat.setApp_id("2019_3_3_4");
        gameStat.setExercise_id("T_6_21");
        gameStat.setLevel_id("1");
        Intent data1 = new Intent(Menu_jouer.this, MyGameActivity_play.class);
        startActivity(data1);

    }
    @Override
    protected void onPause() {

        super.onPause();
        if (mp.isPlaying() && muet==0){
            mp.pause();
        }


    }
    public void onResume() {

        super.onResume();
        if ((!mp.isPlaying() ) && muet==0){
            mp.start();
        }
        if(mp.isPlaying()){
            music.setBackgroundResource(R.drawable.volume);

        }
        else{

            music.setBackgroundResource(R.drawable.muet);

        }


    }
}
