package com.example.nedday.Jeu_T_6_21.Views;


import android.content.Context;
import android.media.AudioManager;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.nedday.Jeu_T_6_21.Assets.Learn2_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.Sprites.Background;
import com.example.nedday.Jeu_T_6_21.Sprites.MySprite_learn;
import com.example.nedday.Jeu_T_6_21.logic.Mylogic;
import com.example.nedday.Jeu_T_6_21.state.First;
import com.example.nedday.Jeu_T_6_21.state.MyGameActivity;
import com.example.nedday.Jeu_T_6_21.state.PopupActivity;
import static com.example.nedday.Jeu_T_6_21.state.First.mp;
import static com.example.nedday.Jeu_T_6_21.state.PopupActivity.muet;

public class Learn_Fournitures_Screen extends Screen {
    private Mylogic logic;
    private Background back,teacher;

    private MySprite_learn sprite0,sprite1,sprite2,sprite3,home;
    MyGameActivity game_activity;
    int w_unit,h_unit;



    public Learn_Fournitures_Screen(Game game, Mylogic logic, MyGameActivity game_activity) {
        super(game);
        this.game_activity=game_activity;
        putPlaceHolders();
    }


    private void putPlaceHolders(){

        w_unit = game.getScreenWidth() / 11;
        h_unit = game.getScreenHeight() / 13;
        System.out.println(h_unit);
        System.out.println(w_unit);

        /** J'initialise mes sprites et je les met dans mon interface
         *
         *
         * */

        back= new Background(game,Learn_Assets.room,0,0,game.getScreenHeight(),game.getScreenWidth());
        addSprite(back);
        teacher= new Background(game,Learn_Assets.womenteacher,(int)(game.getScreenWidth()/1.7),(int)(game.getScreenHeight()/2),(int)(game.getScreenHeight()/2),(int)(game.getScreenWidth()/2.5));
        addSprite(teacher);
        sprite0=new MySprite_learn(game,Learn2_Assets.im2_0,2*w_unit,2*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite0);
        sprite1=new MySprite_learn(game,Learn2_Assets.im2_1,2*w_unit,7*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite1);
        sprite2=new MySprite_learn(game,Learn2_Assets.im2_2,6*w_unit,2*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite2);
        sprite3=new MySprite_learn(game,Learn2_Assets.im2_3,6*w_unit,7*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite3);
        home=new MySprite_learn(game,Learn_Assets.home,0*w_unit,11*h_unit,(int)(game.getScreenHeight()/8),(int)(game.getScreenWidth()/6));
        addSprite(home);





    }



    @Override

    public void handleTouchDown(int x, int y, int pointer) {

        // In this method I check which Sprite I did touch and act accordingly

        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();
        AudioManager manager = (AudioManager)game_activity.getSystemService(Context.AUDIO_SERVICE);
        if ((s == home ) && !(manager.isMusicActive())) {


            if ((!mp.isPlaying() ) && muet==0){
                mp.start();
            }
            game_activity.finish();


        }
        if (PopupActivity.langue==1  || PopupActivity.langue==3){



            if (s==sprite0 && !(manager.isMusicActive()))
            {
                Voice.im2_ar_0.play(1);
            }
            if (s==sprite1  && !(manager.isMusicActive()))
            {Voice.im2_ar_1.play(1);}

            if (s==sprite2  && !(manager.isMusicActive()))
            {Voice.im2_ar_2.play(1);}
            if (s==sprite3  && !(manager.isMusicActive()))
            {Voice.im2_ar_3.play(1);}



        }
        if (PopupActivity.langue==0){



            if (s==sprite0 && !(manager.isMusicActive()))
            {

                Voice.im2_fr_0.play(1);

            }
            if (s==sprite1  && !(manager.isMusicActive()))
            {Voice.im2_fr_1.play(1);}

            if (s==sprite2  && !(manager.isMusicActive()))
            {Voice.im2_fr_2.play(1);}
            if (s==sprite3  && !(manager.isMusicActive()))
            {Voice.im2_fr_3.play(1);}



        }
        if (PopupActivity.langue==2){



            if (s==sprite0 && !(manager.isMusicActive()))
            {
                Voice.im2_ang_0.play(1);

            }
            if (s==sprite1  && !(manager.isMusicActive()))
            {Voice.im2_ang_1.play(1);}

            if (s==sprite2  && !(manager.isMusicActive()))
            {Voice.im2_ang_2.play(1);}
            if (s==sprite3  && !(manager.isMusicActive()))
            {Voice.im2_ang_3.play(1);}





        }



    }

    @Override
    public void render(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 0, 0, 0);


    }

    @Override
    // The handle dragging is activated anytime you drag on your screen.
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        super.dispose();
        System.gc();
    }

    @Override
    public void backButton() {
        pause();
    }








    public void job()
    {


    }

}
