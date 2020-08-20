package com.example.nedday.Jeu_T_6_21.state;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.emobadaragaminglib.Base.Graphics;

import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;
import com.example.nedday.Jeu_T_6_21.Assets.Correct_faux;

import com.example.nedday.Jeu_T_6_21.Assets.Learn2_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Learn3_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Play_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.R;
import com.example.nedday.Jeu_T_6_21.Views.Menu_Screen;



public class First extends AndroidGame {


    private static final String TAG = "GameActivity";
    //public static MediaPlayer mp;
    public static MediaPlayer mp;



    @Override
    public Screen getInitScreen() {
        mp=MediaPlayer.create(this,R.raw.toby);
        mp.setLooping(true);

        initAssets();
        Log.i(TAG, "getInitScreen: Assets are Loaded");

        return new Menu_Screen(this,this);

    }
    ///je vais l'utiliser dans l'app avec auth
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FoxyAuth.emerge(this,First.class);}

    @Override
    public void setScreen(Screen screen) {

        super.setScreen(screen);
    }
    public AndroidSound getAudiobyName(String name){
        int id = this.getResources().getIdentifier(name, "raw", this.getPackageName());
        return (AndroidSound) this.getAudio().createSound(id);
    }

    public void initAssets(){
        System.out.println("IM in loading assets")     ;


        Correct_faux.correct = getGraphics().newImage(R.drawable.correct, Graphics.ImageFormat.ARGB8888, getResources());
        Correct_faux.faux = getGraphics().newImage(R.drawable.faux, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.panier_legume = getGraphics().newImage(R.drawable.panier_legumes, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.panier_fruit = getGraphics().newImage(R.drawable.panier_fruits, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.back = getGraphics().newImage(R.drawable.jardin, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.cartable = getGraphics().newImage(R.drawable.cartable, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.placard = getGraphics().newImage(R.drawable.placard, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.zoo = getGraphics().newImage(R.drawable.zoo, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.aquarium = getGraphics().newImage(R.drawable.aquarium, Graphics.ImageFormat.ARGB8888, getResources());



        //Pour les images de learn
        Learn_Assets.im_0=getGraphics().newImage(R.drawable.im_0, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_1=getGraphics().newImage(R.drawable.im_1, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_2=getGraphics().newImage(R.drawable.im_2, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_3=getGraphics().newImage(R.drawable.im_3, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_4=getGraphics().newImage(R.drawable.im_4, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_5=getGraphics().newImage(R.drawable.im_5, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_6=getGraphics().newImage(R.drawable.im_6, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_7=getGraphics().newImage(R.drawable.im_7, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_8=getGraphics().newImage(R.drawable.im_8, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_9=getGraphics().newImage(R.drawable.im_9, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_10=getGraphics().newImage(R.drawable.im_10, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_11=getGraphics().newImage(R.drawable.im_11, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_12=getGraphics().newImage(R.drawable.im_12, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_13=getGraphics().newImage(R.drawable.im_13, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_14=getGraphics().newImage(R.drawable.im_14, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.im_15=getGraphics().newImage(R.drawable.im_15, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_10=getGraphics().newImage(R.drawable.im3_10, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_5=getGraphics().newImage(R.drawable.im2_5, Graphics.ImageFormat.ARGB8888, getResources());


        Voice.im_ang_0=(AndroidSound) getAudio().createSound(R.raw.im_ang_0);
        Voice.im_ang_1=(AndroidSound) getAudio().createSound(R.raw.im_ang_1);
        Voice.im_ang_2=(AndroidSound) getAudio().createSound(R.raw.im_ang_2);
        Voice.im_ang_3=(AndroidSound) getAudio().createSound(R.raw.im_ang_3);
        Voice.im_ang_4=(AndroidSound) getAudio().createSound(R.raw.im_ang_4);
        Voice.im_ang_5=(AndroidSound) getAudio().createSound(R.raw.im_ang_5);
        Voice.im_ang_6=(AndroidSound) getAudio().createSound(R.raw.im_ang_6);

        Voice.im_ar_0=(AndroidSound) getAudio().createSound(R.raw.im_ar_0);
        Voice.im_ar_1=(AndroidSound) getAudio().createSound(R.raw.im_ar_1);
        Voice.im_ar_2=(AndroidSound) getAudio().createSound(R.raw.im_ar_2);
        Voice.im_ar_3=(AndroidSound) getAudio().createSound(R.raw.im_ar_3);
        Voice.im_ar_4=(AndroidSound) getAudio().createSound(R.raw.im_ar_4);
        Voice.im_ar_5=(AndroidSound) getAudio().createSound(R.raw.im_ar_5);
        Voice.im_ar_6=(AndroidSound) getAudio().createSound(R.raw.im_ar_6);


        Voice.im_fr_0=(AndroidSound) getAudio().createSound(R.raw.im_fr_0);
        Voice.im_fr_1=(AndroidSound) getAudio().createSound(R.raw.im_fr_1);
        Voice.im_fr_2=(AndroidSound) getAudio().createSound(R.raw.im_fr_2);
        Voice.im_fr_3=(AndroidSound) getAudio().createSound(R.raw.im_fr_3);
        Voice.im_fr_4=(AndroidSound) getAudio().createSound(R.raw.im_fr_4);
        Voice.im_fr_5=(AndroidSound) getAudio().createSound(R.raw.im_fr_5);
        Voice.im_fr_6=(AndroidSound) getAudio().createSound(R.raw.im_fr_6);



        Voice.im_ang_7=(AndroidSound) getAudio().createSound(R.raw.im_ang_7);
        Voice.im_ang_8=(AndroidSound) getAudio().createSound(R.raw.im_ang_8);
        Voice.im_ang_9=(AndroidSound) getAudio().createSound(R.raw.im_ang_9);
        Voice.im_ang_10=(AndroidSound) getAudio().createSound(R.raw.im_ang_10);
        Voice.im_ang_11=(AndroidSound) getAudio().createSound(R.raw.im_ang_11);
        Voice.im_ang_12=(AndroidSound) getAudio().createSound(R.raw.im_ang_12);
        Voice.im_ang_13=(AndroidSound) getAudio().createSound(R.raw.im_ang_13);
        Voice.im_ang_14=(AndroidSound) getAudio().createSound(R.raw.im_ang_14);
        Voice.im_ang_15=(AndroidSound) getAudio().createSound(R.raw.im_ang_15);

        Voice.im_ar_7=(AndroidSound) getAudio().createSound(R.raw.im_ar_7);
        Voice.im_ar_8=(AndroidSound) getAudio().createSound(R.raw.im_ar_8);
        Voice.im_ar_9=(AndroidSound) getAudio().createSound(R.raw.im_ar_9);
        Voice.im_ar_10=(AndroidSound) getAudio().createSound(R.raw.im_ar_10);
        Voice.im_ar_11=(AndroidSound) getAudio().createSound(R.raw.im_ar_11);
        Voice.im_ar_12=(AndroidSound) getAudio().createSound(R.raw.im_ar_12);
        Voice.im_ar_13=(AndroidSound) getAudio().createSound(R.raw.im_ar_13);
        Voice.im_ar_14=(AndroidSound) getAudio().createSound(R.raw.im_ar_14);
        Voice.im_ar_15=(AndroidSound) getAudio().createSound(R.raw.im_ar_15);


        Voice.im_fr_7=(AndroidSound) getAudio().createSound(R.raw.im_fr_7);
        Voice.im_fr_8=(AndroidSound) getAudio().createSound(R.raw.im_fr_8);
        Voice.im_fr_9=(AndroidSound) getAudio().createSound(R.raw.im_fr_9);
        Voice.im_fr_10=(AndroidSound) getAudio().createSound(R.raw.im_fr_10);
        Voice.im_fr_11=(AndroidSound) getAudio().createSound(R.raw.im_fr_11);
        Voice.im_fr_12=(AndroidSound) getAudio().createSound(R.raw.im_fr_12);
        Voice.im_fr_13=(AndroidSound) getAudio().createSound(R.raw.im_fr_13);
        Voice.im_fr_14=(AndroidSound) getAudio().createSound(R.raw.im_fr_14);
        Voice.im_fr_15=(AndroidSound) getAudio().createSound(R.raw.im_fr_15);


        Voice.im2_ang_0=(AndroidSound) getAudio().createSound(R.raw.im2_ang_0);
        Voice.im2_ang_1=(AndroidSound) getAudio().createSound(R.raw.im2_ang_1);
        Voice.im2_ang_2=(AndroidSound) getAudio().createSound(R.raw.im2_ang_2);
        Voice.im2_ang_3=(AndroidSound) getAudio().createSound(R.raw.im2_ang_3);
        Voice.im2_ang_4=(AndroidSound) getAudio().createSound(R.raw.im2_ang_4);
        Voice.im2_ang_5=(AndroidSound) getAudio().createSound(R.raw.im2_ang_5);
        Voice.im2_ang_6=(AndroidSound) getAudio().createSound(R.raw.im2_ang_6);
        Voice.im2_ang_7=(AndroidSound) getAudio().createSound(R.raw.im2_ang_7);

        Voice.im2_ar_0=(AndroidSound) getAudio().createSound(R.raw.im2_ar_0);
        Voice.im2_ar_1=(AndroidSound) getAudio().createSound(R.raw.im2_ar_1);
        Voice.im2_ar_2=(AndroidSound) getAudio().createSound(R.raw.im2_ar_2);
        Voice.im2_ar_3=(AndroidSound) getAudio().createSound(R.raw.im2_ar_3);
        Voice.im2_ar_4=(AndroidSound) getAudio().createSound(R.raw.im2_ar_4);
        Voice.im2_ar_5=(AndroidSound) getAudio().createSound(R.raw.im2_ar_5);
        Voice.im2_ar_6=(AndroidSound) getAudio().createSound(R.raw.im2_ar_6);
        Voice.im2_ar_7=(AndroidSound) getAudio().createSound(R.raw.im2_ar_7);


        Voice.im2_fr_0=(AndroidSound) getAudio().createSound(R.raw.im2_fr_0);
        Voice.im2_fr_1=(AndroidSound) getAudio().createSound(R.raw.im2_fr_1);
        Voice.im2_fr_2=(AndroidSound) getAudio().createSound(R.raw.im2_fr_2);
        Voice.im2_fr_3=(AndroidSound) getAudio().createSound(R.raw.im2_fr_3);
        Voice.im2_fr_4=(AndroidSound) getAudio().createSound(R.raw.im2_fr_4);
        Voice.im2_fr_5=(AndroidSound) getAudio().createSound(R.raw.im2_fr_5);
        Voice.im2_fr_6=(AndroidSound) getAudio().createSound(R.raw.im2_fr_6);
        Voice.im2_fr_7=(AndroidSound) getAudio().createSound(R.raw.im2_fr_7);




        Voice.im3_ang_0=(AndroidSound) getAudio().createSound(R.raw.im3_ang_0);
        Voice.im3_ang_1=(AndroidSound) getAudio().createSound(R.raw.im3_ang_1);
        Voice.im3_ang_2=(AndroidSound) getAudio().createSound(R.raw.im3_ang_2);
        Voice.im3_ang_3=(AndroidSound) getAudio().createSound(R.raw.im3_ang_3);
        Voice.im3_ang_4=(AndroidSound) getAudio().createSound(R.raw.im3_ang_4);
        Voice.im3_ang_5=(AndroidSound) getAudio().createSound(R.raw.im3_ang_5);
        Voice.im3_ang_6=(AndroidSound) getAudio().createSound(R.raw.im3_ang_6);
        Voice.im3_ang_7=(AndroidSound) getAudio().createSound(R.raw.im3_ang_7);
        Voice.im3_ang_8=(AndroidSound) getAudio().createSound(R.raw.im3_ang_8);
        Voice.im3_ang_9=(AndroidSound) getAudio().createSound(R.raw.im3_ang_9);
        Voice.im3_ang_10=(AndroidSound) getAudio().createSound(R.raw.im3_ang_10);

        Voice.im3_ar_0=(AndroidSound) getAudio().createSound(R.raw.im3_ar_0);
        Voice.im3_ar_1=(AndroidSound) getAudio().createSound(R.raw.im3_ar_1);
        Voice.im3_ar_2=(AndroidSound) getAudio().createSound(R.raw.im3_ar_2);
        Voice.im3_ar_3=(AndroidSound) getAudio().createSound(R.raw.im3_ar_3);
        Voice.im3_ar_4=(AndroidSound) getAudio().createSound(R.raw.im3_ar_4);
        Voice.im3_ar_5=(AndroidSound) getAudio().createSound(R.raw.im3_ar_5);
        Voice.im3_ar_6=(AndroidSound) getAudio().createSound(R.raw.im3_ar_6);
        Voice.im3_ar_7=(AndroidSound) getAudio().createSound(R.raw.im3_ar_7);
        Voice.im3_ar_8=(AndroidSound) getAudio().createSound(R.raw.im3_ar_8);
        Voice.im3_ar_9=(AndroidSound) getAudio().createSound(R.raw.im3_ar_9);
        Voice.im3_ar_10=(AndroidSound) getAudio().createSound(R.raw.im3_ar_10);

        Voice.im3_fr_0=(AndroidSound) getAudio().createSound(R.raw.im3_fr_0);
        Voice.im3_fr_1=(AndroidSound) getAudio().createSound(R.raw.im3_fr_1);
        Voice.im3_fr_2=(AndroidSound) getAudio().createSound(R.raw.im3_fr_2);
        Voice.im3_fr_3=(AndroidSound) getAudio().createSound(R.raw.im3_fr_3);
        Voice.im3_fr_4=(AndroidSound) getAudio().createSound(R.raw.im3_fr_4);
        Voice.im3_fr_5=(AndroidSound) getAudio().createSound(R.raw.im3_fr_5);
        Voice.im3_fr_6=(AndroidSound) getAudio().createSound(R.raw.im3_fr_6);
        Voice.im3_fr_7=(AndroidSound) getAudio().createSound(R.raw.im3_fr_7);
        Voice.im3_fr_8=(AndroidSound) getAudio().createSound(R.raw.im3_fr_8);
        Voice.im3_fr_9=(AndroidSound) getAudio().createSound(R.raw.im3_fr_9);
        Voice.im3_fr_10=(AndroidSound) getAudio().createSound(R.raw.im3_fr_10);



        Voice.Learnanimals_ang=getAudiobyName("learnanimals_ang");
        Voice.Learnanimals_ar=getAudiobyName("learnanimals_ar");
        Voice.Learnanimals_fr=getAudiobyName("learnanimals_fr");
        Voice.Learnanimals_dar=getAudiobyName("learnanimals_dar");

        Voice.Learnfruits_fr=getAudiobyName("learnfruits_fr");
        Voice.Learnfruits_ar=getAudiobyName("learnfruits_ar");
        Voice.Learnfruits_dar=getAudiobyName("learnfruits_dar");
        Voice.Learnfruits_ang=getAudiobyName("learnfruits_ang");
        Voice.Learnvegetables_ang=getAudiobyName("learnvegetables_ang");
        Voice.Learnvegetables_fr=getAudiobyName("learnvegetables_fr");
        Voice.Learnvegetables_ar=getAudiobyName("learnvegetables_ar");
        Voice.Learnvegetables_dar=getAudiobyName("learnvegetables_dar");
        Voice.Learnfish_ar=getAudiobyName("learnfish_ar");
        Voice.Learnfish_dar=getAudiobyName("learnfish_dar");
        Voice.Learnfish_fr=getAudiobyName("learnfish_fr");
        Voice.Learnfish_ang=getAudiobyName("learnfish_ang");
        Voice.Learnclothes_ar=getAudiobyName("learnclothes_ar");
        Voice.Learnclothes_dar=getAudiobyName("learnclothes_dar");
        Voice.Learnclothes_ang=getAudiobyName("learnclothes_ang");
        Voice.Learnclothes_fr=getAudiobyName("learnclothes_fr");
        Voice.Learnfurniture_fr=getAudiobyName("learnfurniture_fr");
        Voice.Learnfurniture_ar=getAudiobyName("learnfurniture_ar");
        Voice.Learnfurniture_dar=getAudiobyName("learnfurniture_dar");
        Voice.Learnfurniture_ang=getAudiobyName("learnfurniture_ang");

        Learn_Assets.home=getGraphics().newImage(R.drawable.retour, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.how=getGraphics().newImage(R.drawable.how, Graphics.ImageFormat.ARGB8888, getResources());

        Voice.lose_ang_0=getAudiobyName("lose_ang_0");
        Voice.lose_ar_0=getAudiobyName("lose_ar_0");
        Voice.lose_fr_0=getAudiobyName("lose_fr_0");
        Voice.win_ang_4=getAudiobyName("win_ang_4");
        Voice.win_ar_0=getAudiobyName("win_ar_0");
        Voice.win_fr_2=getAudiobyName("win_fr_2");

        Voice.en_ang_0=getAudiobyName("en_ang_0");
        Voice.en_ar_0=getAudiobyName("en_ar_0");
        Voice.en_fr_0=getAudiobyName("en_fr_0");





    }





        /*
        mp=MediaPlayer.create(this,R.raw.toby);
        mp.setLooping(true);
        if (mp.isPlaying())
        {
            muet=0;
        }
        else
        {
            mp.start();
        }
     */


/*
    @Override
    public void onPause() {

        super.onPause();
        if (First.mp.isPlaying()){
            First.mp.pause();
        }


    }
    @Override
    public void onResume() {

        super.onResume();
        if ((!First.mp.isPlaying() ) && muet==0){
            First.mp.start();
            muet=0;
        }


    }
    */

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }


}