package com.example.nedday.Jeu_T_6_21.state;



import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Play_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.R;
import com.example.nedday.Jeu_T_6_21.Views.MyScreen;
import com.example.nedday.Jeu_T_6_21.Views.MyScreen2;
import com.example.nedday.Jeu_T_6_21.Views.MyScreen3;
import com.example.nedday.Jeu_T_6_21.logic.Mylogic;

import static com.example.nedday.Jeu_T_6_21.state.First.mp;


public class MyGameActivity_play extends AndroidGame {

    Mylogic logic ;
    public static MediaPlayer Losingsound;


    @Override
    public Screen getInitScreen() {
        if ((mp.isPlaying()))
        {
            mp.pause();
        }
        Screen screen=null;
        logic=new Mylogic();
        initAssets();

            switch (PopupActivity.niveau) {
                case 1:
                    screen = new MyScreen(this, logic, this);
                    break;
                case 2:
                    screen = new MyScreen2(this, logic, this);

                    break;
                case 3:
                    screen = new MyScreen3(this, logic, this);

                    break;



        }
        return screen;
    }
    public Image getImgbyName(String name){
        int id = this.getResources().getIdentifier(name, "drawable", this.getPackageName());
        return this.getGraphics().newImage(id, Graphics.ImageFormat.ARGB8888, this.getResources());
    }
    private void initAssets() {




        Learn_Assets.im_8=getGraphics().newImage(R.drawable.im_8, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.hand=getGraphics().newImage(R.drawable.hand, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.handinverse=getGraphics().newImage(R.drawable.handinverse, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.again=getGraphics().newImage(R.drawable.again, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.garcon=getGraphics().newImage(R.drawable.garcon, Graphics.ImageFormat.ARGB8888, getResources());
        Play_Assets.how=getGraphics().newImage(R.drawable.how, Graphics.ImageFormat.ARGB8888, getResources());
        String current;

        switch (PopupActivity.niveau) {
            case 1:
                current = Mylogic.getCurrentimage();
                Play_Assets.guess = getImgbyName(current);
                break;
            case 2:
                current = Mylogic.getCurrentimage2();
                Play_Assets.guess = getImgbyName(current);
                break;
            case 3:
                current = Mylogic.getCurrentimage3();
                Play_Assets.guess = getImgbyName(current);
                break;
        }

        switch (PopupActivity.langue) {
            /**Pour les audios des expressions
             *
             */
            case 0:
                Voice.lose_fr = moblibAudioFileManager.getRandomAudioFile(this, "encouragement", "FR");
                Voice.win_fr = moblibAudioFileManager.getRandomAudioFile(this, "excellent", "FR");
                Voice.en_fr = moblibAudioFileManager.getRandomAudioFile(this, "good", "FR");
                Voice.instfr = getAudiobyName("instfr");
                break;
            case 1:
                Voice.lose_ar = moblibAudioFileManager.getRandomAudioFile(this, "encouragement", "AR");
                Voice.win_ar = moblibAudioFileManager.getRandomAudioFile(this, "excellent", "AR");
                Voice.en_ar = moblibAudioFileManager.getRandomAudioFile(this, "good", "AR");
                Voice.instar = getAudiobyName("instar");
                break;
            case 2:
                Voice.lose_ang = moblibAudioFileManager.getRandomAudioFile(this, "encouragement", "ANG");
                Voice.win_ang = moblibAudioFileManager.getRandomAudioFile(this, "excellent", "ANG");
                Voice.en_ang = moblibAudioFileManager.getRandomAudioFile(this, "good", "ANG");
                Voice.instang = getAudiobyName("instang");
                break;
            case 3:
                Voice.lose_dar = moblibAudioFileManager.getRandomAudioFile(this, "encouragement", "DA");
                Voice.win_dar = moblibAudioFileManager.getRandomAudioFile(this, "excellent", "DAR");
                Voice.en_dar = moblibAudioFileManager.getRandomAudioFile(this, "good", "DAR");
                Voice.instdar = getAudiobyName("instdar");

                break;








        }


    }
    public void start() {

        Intent i = new Intent(this,MyGameActivity_play.class);
        startActivity(i);
    }

    public void onFinish()
    {

        this.finish();
    }
        public AndroidSound getAudiobyName(String name){
            int id = this.getResources().getIdentifier(name, "raw", this.getPackageName());
            return (AndroidSound) this.getAudio().createSound(id);
        }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }





}