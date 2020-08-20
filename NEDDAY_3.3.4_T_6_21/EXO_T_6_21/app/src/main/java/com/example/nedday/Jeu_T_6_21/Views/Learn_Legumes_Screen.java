package com.example.nedday.Jeu_T_6_21.Views;

import android.content.Context;
import android.media.AudioManager;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.Sprites.Background;
import com.example.nedday.Jeu_T_6_21.Sprites.MySprite;
import com.example.nedday.Jeu_T_6_21.Sprites.MySprite_learn;
import com.example.nedday.Jeu_T_6_21.logic.Mylogic;
import com.example.nedday.Jeu_T_6_21.state.First;
import com.example.nedday.Jeu_T_6_21.state.MyGameActivity;
import com.example.nedday.Jeu_T_6_21.state.PopupActivity;

import static com.example.nedday.Jeu_T_6_21.state.First.mp;
import static com.example.nedday.Jeu_T_6_21.state.PopupActivity.muet;


public class Learn_Legumes_Screen extends Screen {
    private Mylogic logic;
    private Background back,teacher;

    private MySprite_learn sprite0,sprite1,sprite2,sprite3,sprite4,sprite5,sprite6,sprite7,home;
    MyGameActivity game_activity;
    int w_unit,h_unit;
    private MySprite ph[][];


    public Learn_Legumes_Screen(Game game, Mylogic logic, MyGameActivity game_activity) {
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

        back= new Background(game,Learn_Assets.backmenu,0,0,game.getScreenHeight(),game.getScreenWidth());
        addSprite(back);
        teacher= new Background(game,Learn_Assets.teacher,7*w_unit,(int)(game.getScreenHeight()/1.7),(int)(game.getScreenHeight()/2.5),(int)(game.getScreenWidth()/3));
        addSprite(teacher);
        sprite0=new MySprite_learn(game,Learn_Assets.im_0,1*w_unit,1*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite0);
        sprite1=new MySprite_learn(game,Learn_Assets.im_1,4*w_unit,1*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite1);
        sprite2=new MySprite_learn(game,Learn_Assets.im_2,8*w_unit,1*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite2);
        sprite3=new MySprite_learn(game,Learn_Assets.im_3,8*w_unit,4*h_unit,(int)(game.getScreenHeight()/5.2),(int)(game.getScreenWidth()/5));
        addSprite(sprite3);
        sprite4=new MySprite_learn(game,Learn_Assets.im_4,4*w_unit,4*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite4);
        sprite5=new MySprite_learn(game,Learn_Assets.im_5,(int)(game.getScreenWidth()/17),4*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/3.9));
        addSprite(sprite5);
        sprite6=new MySprite_learn(game,Learn_Assets.im_6,4*w_unit,7*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/4.25));
        addSprite(sprite6);
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
                Voice.im_ar_0.play(1);

            }
            if (s==sprite1  && !(manager.isMusicActive()))
            {Voice.im_ar_1.play(1);}

            if (s==sprite2  && !(manager.isMusicActive()))
            {Voice.im_ar_2.play(1);}
            if (s==sprite3  && !(manager.isMusicActive()))
            {Voice.im_ar_3.play(1);}
            if (s==sprite4  && !(manager.isMusicActive()))
            {Voice.im_ar_4.play(1);}
            if (s==sprite5  && !(manager.isMusicActive()))
            {Voice.im_ar_5.play(1);}
            if (s==sprite6  && !(manager.isMusicActive()))
            {Voice.im_ar_6.play(1);}


        }
        if (PopupActivity.langue==0){



            if (s==sprite0 && !(manager.isMusicActive()))
            {


                System.out.println("tooooooomates");
                Voice.im_fr_0.play(1);

            }
            if (s==sprite1  && !(manager.isMusicActive()))
            {Voice.im_fr_1.play(1);}

            if (s==sprite2  && !(manager.isMusicActive()))
            {Voice.im_fr_2.play(1);}
            if (s==sprite3  && !(manager.isMusicActive()))
            {Voice.im_fr_3.play(1);}
            if (s==sprite4  && !(manager.isMusicActive()))
            {Voice.im_fr_4.play(1);}
            if (s==sprite5  && !(manager.isMusicActive()))
            {Voice.im_fr_5.play(1);}
            if (s==sprite6  && !(manager.isMusicActive()))
            {Voice.im_fr_6.play(1);}


        }
        if (PopupActivity.langue==2){



            if (s==sprite0 && !(manager.isMusicActive()))
            {


                System.out.println("tooooooomates");
                Voice.im_ang_0.play(1);

            }
            if (s==sprite1  && !(manager.isMusicActive()))
            {Voice.im_ang_1.play(1);}

            if (s==sprite2  && !(manager.isMusicActive()))
            {Voice.im_ang_2.play(1);}
            if (s==sprite3  && !(manager.isMusicActive()))
            {Voice.im_ang_3.play(1);}
            if (s==sprite4  && !(manager.isMusicActive()))
            {Voice.im_ang_4.play(1);}
            if (s==sprite5  && !(manager.isMusicActive()))
            {Voice.im_ang_5.play(1);}
            if (s==sprite6  && !(manager.isMusicActive()))
            {Voice.im_ang_6.play(1);}


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
