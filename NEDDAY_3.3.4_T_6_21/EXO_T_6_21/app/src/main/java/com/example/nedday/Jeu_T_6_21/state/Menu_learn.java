package com.example.nedday.Jeu_T_6_21.state;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.R;

import static com.example.nedday.Jeu_T_6_21.state.First.mp;
import static com.example.nedday.Jeu_T_6_21.state.PopupActivity.muet;


public class Menu_learn extends AppCompatActivity {

    Button a1,a2,a3,a4,a5,a6,music;
    ImageView img1;
    Dialog myDialog;
    Button commencer,acc;
    public static Activity activity_menu_learn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity_menu_learn= this;

        //Have a full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_learn);
        myDialog = new Dialog(this);
        a1 = (Button) findViewById(R.id.a1);
        a2=  (Button) findViewById(R.id.a2);
        a3=  (Button) findViewById(R.id.a3);
        a4=  (Button) findViewById(R.id.a4);
        a5=  (Button) findViewById(R.id.a5);
        a6=  (Button) findViewById(R.id.a6);
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
            case 0:  a1.setText("Legumes"); a2.setText("Fruits"); a3.setText("Animaux");
                     a4.setText("Poissons"); a5.setText("Fournitures");a6.setText("Vetements");
            break;
            case 1:  a1.setText("خضر");a2.setText("فواكه ") ; a3.setText("حيوانات") ;
                     a4.setText("سمك");a5.setText("ادوات مدرسية");a6.setText("ملابس");
            break;
            case 2 : a1.setText("Vegetables"); a2.setText("Fruits"); a3.setText("Animals");
                     a4.setText("Fish");a5.setText("Furnitures");a6.setText("Clothes");
            break;
            case 3:  a1.setText("خضر");a2.setText("فواكه ") ; a3.setText("حيوانات") ;
                a4.setText("سمك");a5.setText("ادوات مدرسية");a6.setText("ملابس");
                break;
        }

        /** le debut du traitement du level 1 */
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.popup_play_niveau1);
                PopupActivity.niveau=1;
                Level();

            }

        });

        /** Le debut du traitement du level 2 */
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popup_play_niveau2);
                PopupActivity.niveau=2;
                Level();

            }

        });

        /**Le debut du traitement du level 3 **/
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popup_play_niveau3);
                PopupActivity.niveau=3;
                Level();
            }

        });
        /** le debut du traitement du level 4 */
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popup_play_niveau4);
                PopupActivity.niveau=4;
                Level();

            }

        });
        /** le debut du traitement du level 5 */
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popup_play_niveau5);
                PopupActivity.niveau=5;
                Level();

            }

        });
        /** le debut du traitement du level 6  */
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popup_play_niveau6);
                PopupActivity.niveau=6;
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
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        img1 = (ImageView) myDialog.findViewById(R.id.imageView);
        myDialog.show();

        commencer = (Button) myDialog.findViewById(R.id.jouer);
        acc = (Button) myDialog.findViewById(R.id.acceuil);

        switch (PopupActivity.langue)
        {
            case 0:  commencer.setText("Commencer");acc.setText("Principale");break;
            case 1:  commencer.setText("إبدأ");acc.setText("الرئيسية");break;
            case 2 : commencer.setText("Start"); acc.setText("Main");break;
            case 3:  commencer.setText("إبدأ");acc.setText("الرئيسية");break;

        }

        commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying() )
                {
                    mp.pause();
                }
                switch (PopupActivity.niveau)
                {
                    case 1:if (PopupActivity.langue==0) Voice.Learnvegetables_fr.play(1);
                           if  (PopupActivity.langue==1) Voice.Learnvegetables_ar.play(1);
                           if (PopupActivity.langue==2) Voice.Learnvegetables_ang.play(1);
                           if (PopupActivity.langue==3) Voice.Learnvegetables_dar.play(1);
                           break ;
                    case 2:if (PopupActivity.langue==0) Voice.Learnfruits_fr.play(1);
                           if  (PopupActivity.langue==1) Voice.Learnfruits_ar.play(1);
                           if (PopupActivity.langue==2) Voice.Learnfruits_ang.play(1);
                           if (PopupActivity.langue==3) Voice.Learnfruits_dar.play(1);
                           break ;
                    case 3 :if (PopupActivity.langue==0) Voice.Learnanimals_fr.play(1);
                            if  (PopupActivity.langue==1) Voice.Learnanimals_ar.play(1);
                            if (PopupActivity.langue==2) Voice.Learnanimals_ang.play(1);
                            if (PopupActivity.langue==3) Voice.Learnanimals_dar.play(1);
                            break ;
                    case 4 :if (PopupActivity.langue==0) Voice.Learnfish_fr.play(1);
                        if  (PopupActivity.langue==1) Voice.Learnfish_ar.play(1);
                        if (PopupActivity.langue==2) Voice.Learnfish_ang.play(1);
                        if (PopupActivity.langue==3) Voice.Learnfish_dar.play(1);
                        break ;
                    case 5 : if (PopupActivity.langue==0) Voice.Learnfurniture_fr.play(1);
                        if  (PopupActivity.langue==1) Voice.Learnfurniture_ar.play(1);
                        if (PopupActivity.langue==2) Voice.Learnfurniture_ang.play(1);
                        if (PopupActivity.langue==3) Voice.Learnfurniture_dar.play(1);
                        break ;
                    case 6 : if (PopupActivity.langue==0) Voice.Learnclothes_fr.play(1);
                        if  (PopupActivity.langue==1) Voice.Learnclothes_ar.play(1);
                        if (PopupActivity.langue==2) Voice.Learnclothes_ang.play(1);
                        if (PopupActivity.langue==3) Voice.Learnclothes_dar.play(1);
                        break ;
                }



          Intent data1 = new Intent(Menu_learn.this, MyGameActivity.class);
          startActivity(data1);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!mp.isPlaying()) && muet==0)
                {
                       mp.start();
                }

                activity_menu_learn.finish();


            }

        });
    }

    @Override
    protected void onPause() {

        super.onPause();
        if (mp.isPlaying()){
           mp.pause();
        }


    }
    public void onResume() {

        super.onResume();
        if ((!mp.isPlaying())  && muet==0){
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
