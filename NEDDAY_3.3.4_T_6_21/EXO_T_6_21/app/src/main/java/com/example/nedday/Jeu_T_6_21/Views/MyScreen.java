package com.example.nedday.Jeu_T_6_21.Views;



import android.content.Context;
import android.media.AudioManager;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.ensias_auth_library.FoxyAuth;
import com.example.nedday.Jeu_T_6_21.Assets.Correct_faux;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Play_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.Sprites.Background;
import com.example.nedday.Jeu_T_6_21.Sprites.MySprite;
import com.example.nedday.Jeu_T_6_21.Sprites.MySprite_learn;
import com.example.nedday.Jeu_T_6_21.Sprites.Panier_fruits;
import com.example.nedday.Jeu_T_6_21.Sprites.Panier_legumes;
import com.example.nedday.Jeu_T_6_21.logic.Mylogic;
import com.example.nedday.Jeu_T_6_21.state.First;
import com.example.nedday.Jeu_T_6_21.state.Menu_jouer;
import com.example.nedday.Jeu_T_6_21.state.MyGameActivity_play;
import com.example.nedday.Jeu_T_6_21.state.PopupActivity;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import static com.example.nedday.Jeu_T_6_21.state.Menu_jouer.array_L;
import static com.example.nedday.Jeu_T_6_21.state.Menu_jouer.gameStat;
import static com.example.nedday.Jeu_T_6_21.state.Menu_jouer.lose_score;
import static com.example.nedday.Jeu_T_6_21.state.Menu_jouer.win_score;
import static com.example.nedday.Jeu_T_6_21.state.PopupActivity.activity_pop;
import static com.example.nedday.Jeu_T_6_21.state.First.mp;
import static com.example.nedday.Jeu_T_6_21.state.PopupActivity.muet;


public class MyScreen extends Screen {
    private Mylogic logic;
    private Background back;
    private Panier_legumes panier_legumes;
    private Panier_fruits panier_fruits;
    private  MySprite sprite ;
    private MySprite_learn home,garcon,how ;

    int w_unit,h_unit;
    Date entree;


    MyGameActivity_play game_activity;




    public MyScreen(Game game, Mylogic logic, MyGameActivity_play game_activity) {
        super(game);
        this.logic = logic;

        this.game_activity=game_activity;
        entree=new Date();
        putPlaceHolders();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");










    }



    private void putPlaceHolders(){

         w_unit = game.getGraphics().getWidth() / 4;
         h_unit = game.getGraphics().getHeight() / 4;

        /** J'initialise mes sprites et je les met dans mon interface
         *
         *
         * */

        back= new Background(game, Play_Assets.back,0,0,game.getScreenHeight(),game.getScreenWidth());
        addSprite(back);


        panier_fruits=new Panier_fruits(game,Play_Assets.panier_fruit,0*w_unit,2*h_unit,(int)(game.getScreenHeight()/2.9),(int)(game.getScreenWidth()/3.08));
        addSprite(panier_fruits);

        panier_legumes=new Panier_legumes(game,Play_Assets.panier_legume,(int)(game.getScreenWidth()/1.74),2*h_unit,(int)(game.getScreenHeight()/2.9),(int)(game.getScreenWidth()/2.25));
        addSprite(panier_legumes);

        sprite =new MySprite(game,Play_Assets.guess,(int)(game.getScreenWidth()/2.54) ,(int)(game.getScreenHeight()/6.4),(int)(game.getScreenHeight()/6.4),(int)(game.getScreenWidth()/4.32));
        addSprite(sprite);

        home=new MySprite_learn(game,Learn_Assets.home,0*w_unit,(int)(game.getScreenHeight()/1.15),(int)(game.getScreenHeight()/8),(int)(game.getScreenWidth()/6));
        addSprite(home);

        garcon=new MySprite_learn(game,Play_Assets.garcon,0*w_unit ,(int)(game.getScreenHeight()/6.4),(int)(game.getScreenHeight()/6.4),(int)(game.getScreenWidth()/4.32));

        how=new MySprite_learn(game,Play_Assets.how,(int)(game.getScreenWidth()/1.36),0*h_unit,(int)(game.getScreenHeight()/5),(int)(game.getScreenWidth()/3));
        addSprite(how);




    }



    @Override

    public void handleTouchDown(int x, int y, int pointer) {

        // In this method I check which Sprite I did touch and act accordingly

        super.handleTouchDown(x, y, pointer);




    }

    @Override
    public void render(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 0, 0, 0);
        job();
    }

    @Override
    // The handle dragging is activated anytime you drag on your screen.
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        Sprite s = getDraggedSprite();
        AudioManager manager = (AudioManager)game_activity.getSystemService(Context.AUDIO_SERVICE);
        if ((s == home ) && !(manager.isMusicActive())) {
            //pour stocker le temps min et la moyenne
            if (array_L.size()>0)
            {
                // Retourner la plus petite valeur
                Object min = Collections.min(array_L);
                System.out.println("miiiiiiiiiiiiiiiiiiiiiiin"+min);
                gameStat.setMin_time_succeed_sec(min.toString());
                int somme=0;
                float moy;
                for (Object obj:array_L)
                {
                    somme=somme+(int)obj;

                }
                moy=(float) somme/array_L.size();
                gameStat.setAvg_time_succeed_sec(String.valueOf(moy));
                System.out.println("avggggggggg"+moy);

            }

            //Stocker date de sortie de level
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");
            String updateDate = sd.format(new Date());
            gameStat.setUpdated_at(updateDate);
            System.out.println("Sortiiiiiie Level" + updateDate);


             //Stocker latitude et longitude
            gameStat.setLatitude(String.valueOf(PopupActivity.latitude));
            System.out.println("laaat"+PopupActivity.latitude);
            gameStat.setLongitude(String.valueOf(PopupActivity.longitude));
            System.out.println("loooooooong"+String.valueOf(PopupActivity.longitude));

            //Stocker tentatives d'échec et succes
            gameStat.setSuccessful_attempts(String.valueOf(win_score));
            System.out.println("wwwwwwwwiiin"+win_score);
            gameStat.setFailed_attempts(String.valueOf(lose_score));
            System.out.println("loooooose"+lose_score);


            FoxyAuth.storeGameStat(activity_pop,gameStat);

            if ((mp.isPlaying() ) && muet==0){
                mp.start();
            }
            game_activity.finish();



        }
        if ((s == how ) && !(manager.isMusicActive())) {


            if (PopupActivity.langue==0 && !(manager.isMusicActive()))
            {
                Voice.instfr.play(1);
            }
            if (PopupActivity.langue==1 && !(manager.isMusicActive()))
            {
                Voice.instar.play(1);
            }
            if (PopupActivity.langue==2 && !(manager.isMusicActive()))
            {
                Voice.instang.play(1);
            }
            if (PopupActivity.langue==3 && !(manager.isMusicActive()))
            {
                Voice.instdar.play(1);
            }


            game_activity.setScreen(new How_to1(game,logic, game_activity));


        }
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
     int i=0;
     int c=0;

    public void job() {
        AudioManager manager = (AudioManager) game_activity.getSystemService(Context.AUDIO_SERVICE);
        i++;
        if (c == 0) {
            if (panier_legumes.contain(sprite.getX(), sprite.getY())) {
                switch (this.logic.check()) {
                    case "legume":

                        sprite.setWidth((int) (game.getScreenWidth() / 6));
                        sprite.setHeight((int) (game.getScreenHeight() / 7));
                        sprite.setPosition((int) (game.getScreenWidth() / 1.3), (int) (game.getScreenHeight() / 1.6));
                        sprite.setDragged(false);
                        sprite.setStatic(true);
                        game.getCurrentScreen().
                                addSprite(new Sprite(Correct_faux.correct, (int) (game.getScreenWidth() / 1.74), (int) (game.getScreenHeight() / 1.58), (int) (game.getScreenHeight() / 3.9), (int) (game.getScreenWidth() / 2.25)));
                        win_score++;

                        Date win=new Date();
                        int between = (int) ((win.getTime() - entree.getTime())/1000);
                        System.out.println("SEEECOOOONDS"+between);
                        array_L.add(between);

                        switch (PopupActivity.langue) {
                            case 0:
                                if (Voice.win_fr != null) Voice.win_fr.start();
                                else Voice.win_fr_2.play(1);
                                break;
                            case 1:
                                if (Voice.win_ar != null) Voice.win_ar.start();
                                else Voice.win_ar_0.play(1);
                                break;

                            case 2:
                                if (Voice.win_ang != null) Voice.win_ang.start();
                                else Voice.win_ang_4.play(1);
                                break;
                            case 3:
                                if (Voice.win_dar != null) Voice.win_dar.start();
                                else Voice.win_ar_0.play(1);
                                break;


                }

                  c++;
                break;

                case "fruit":

                    sprite.setWidth((int) (game.getScreenWidth() / 6));
                    sprite.setHeight((int) (game.getScreenHeight() / 7));
                    sprite.setPosition((int) (game.getScreenWidth() / 1.3), (int) (game.getScreenHeight() / 1.6));
                    sprite.setDragged(false);
                    sprite.setStatic(true);
                    game.getCurrentScreen().
                            addSprite(new Sprite(Correct_faux.faux, (int) (game.getScreenWidth() / 1.74), (int) (game.getScreenHeight() / 1.58), (int) (game.getScreenHeight() / 3.9), (int) (game.getScreenWidth() / 2.25)));
                    lose_score++;
                    switch (PopupActivity.langue) {
                        case 0:
                            if (Voice.lose_fr != null) Voice.lose_fr.start();
                            else Voice.lose_fr_0.play(1);
                            break;
                        case 1:
                            if (Voice.lose_ar != null) Voice.lose_ar.start();
                            else Voice.lose_ar_0.play(1);
                            break;

                        case 2:
                            if (Voice.lose_ang != null) Voice.lose_ang.start();
                            else Voice.lose_ang_0.play(1);
                            break;
                        case 3:
                            if (Voice.lose_dar != null) Voice.lose_dar.start();
                            else Voice.lose_ar_0.play(1);
                            break;

                    }
                    c++;



                    break;

            }


        } else

        {
            if (panier_fruits.contain(sprite.getX(), sprite.getY())) {
                switch (this.logic.check()) {
                    case "fruit":
                        sprite.setWidth((int) (game.getScreenWidth() / 6));
                        sprite.setHeight((int) (game.getScreenHeight() / 7));
                        sprite.setPosition((int) (game.getScreenWidth() / 5.68), (int) (game.getScreenHeight() / 1.6));
                        sprite.setDragged(false);
                        sprite.setStatic(true);
                        game.getCurrentScreen().
                                addSprite(new Sprite(Correct_faux.correct, 0 * w_unit, (int) (game.getScreenHeight() / 1.58), (int) (game.getScreenHeight() / 3.9), (int) (game.getScreenWidth() / 3.08)));
                        win_score++;
                        Date win=new Date();
                        int between = (int) ((win.getTime() - entree.getTime())/1000);
                        System.out.println("SEEECOOOONDS"+between);
                        array_L.add(between);


                        switch (PopupActivity.langue) {
                            case 0:
                                if (Voice.win_fr != null) Voice.win_fr.start();
                                else Voice.win_fr_2.play(1);
                                break;
                            case 1:
                                if (Voice.win_ar != null) Voice.win_ar.start();
                                else Voice.win_ar_0.play(1);
                                break;

                            case 2:
                                if (Voice.win_ang != null) Voice.win_ang.start();
                                else Voice.win_ang_4.play(1);
                                break;
                            case 3:
                                if (Voice.win_dar != null) Voice.win_dar.start();
                                else Voice.win_ar_0.play(1);
                                break;
                        }
                        c++;
                        break;

                    case "legume":
                        sprite.setWidth((int) (game.getScreenWidth() / 6));
                        sprite.setHeight((int) (game.getScreenHeight() / 7));
                        sprite.setPosition((int) (game.getScreenWidth() / 5.68), (int) (game.getScreenHeight() / 1.6));
                        sprite.setDragged(false);
                        sprite.setStatic(true);
                        game.getCurrentScreen().
                                addSprite(new Sprite(Correct_faux.faux, 0 * w_unit, (int) (game.getScreenHeight() / 1.58), (int) (game.getScreenHeight() / 3.9), (int) (game.getScreenWidth() / 3.08)));

                        lose_score++;

                        switch (PopupActivity.langue) {
                            case 0:
                                if (Voice.lose_fr != null) Voice.lose_fr.start();
                                else Voice.lose_fr_0.play(1);
                                break;
                            case 1:
                                if (Voice.lose_ar != null) Voice.lose_ar.start();
                                else Voice.lose_ar_0.play(1);
                                break;

                            case 2:
                                if (Voice.lose_ang != null) Voice.lose_ang.start();
                                else Voice.lose_ang_0.play(1);
                                break;
                            case 3:
                                if (Voice.lose_dar != null) Voice.lose_dar.start();
                                else Voice.lose_ar_0.play(1);
                                break;
                        }
                        c++;
                        break;

                }

            }
        }


    }
     else {

            if (!(manager.isMusicActive())) {
                System.out.println("jjjjjjjjjjjjjjjjjjjjjj");
                game_activity.start();
                game_activity.onFinish();
            }
        }
        if (i==300){
            addSprite(garcon);

            switch (PopupActivity.langue)
            {
                case 0:
                    if (Voice.en_fr !=null) Voice.en_fr.start();
                    else  Voice.en_fr_0.play(1);
                    break;
                case 1:
                    if (Voice.en_ar!=null) Voice.en_ar.start();
                    else  Voice.en_ar_0.play(1);
                    break;

                case 2:
                    if (Voice.en_ang!=null) Voice.en_ang.start();
                    else  Voice.en_ang_0.play(1);
                    break;
                case 3 :
                    if (Voice.en_dar!=null) Voice.en_dar.start();
                    else  Voice.en_ar_0.play(1);
                    break;

            }
        }
        if (i>300 )
        {

            if (garcon.getX()<(int)(game.getScreenWidth()/5.4))

            {
                garcon.setX((int)garcon.getX() +(int)game.getScreenWidth()/108);

            }
        }


    }
}
