package com.example.nedday.Jeu_T_6_21.Views;

import android.content.Context;
import android.media.AudioManager;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.nedday.Jeu_T_6_21.Assets.Correct_faux;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Play_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.Sprites.Background;
import com.example.nedday.Jeu_T_6_21.Sprites.MySprite_learn;
import com.example.nedday.Jeu_T_6_21.Sprites.Panier_fruits;
import com.example.nedday.Jeu_T_6_21.Sprites.Panier_legumes;
import com.example.nedday.Jeu_T_6_21.logic.Mylogic;
import com.example.nedday.Jeu_T_6_21.state.MyGameActivity_play;
import com.example.nedday.Jeu_T_6_21.state.PopupActivity;

public class How_to1 extends Screen {
    private Mylogic logic;
    private Background back;
    private Panier_legumes panier_legumes;
    private Panier_fruits panier_fruits;
    private MySprite_learn hand,handinverse,again;
    private MySprite_learn sprite ;
    private MySprite_learn home ;
    int w_unit,h_unit;


    MyGameActivity_play game_activity;




    public How_to1(Game game, Mylogic logic, MyGameActivity_play game_activity) {
        super(game);
        this.logic = logic;

        this.game_activity=game_activity;
        putPlaceHolders();



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

        sprite =new MySprite_learn(game,Learn_Assets.im_8,(int)(game.getScreenWidth()/2.54) ,(int)(game.getScreenHeight()/6.4),(int)(game.getScreenHeight()/6.4),(int)(game.getScreenWidth()/4.32));
        addSprite(sprite);

        home=new MySprite_learn(game,Learn_Assets.home,0*w_unit,(int)(game.getScreenHeight()/1.15),(int)(game.getScreenHeight()/8),(int)(game.getScreenWidth()/6));
        addSprite(home);

        hand =new MySprite_learn(game,Play_Assets.hand,(int)(game.getScreenWidth()/10) ,(int)(game.getScreenHeight()/6.4),(int)(game.getScreenHeight()/6.4),(int)(game.getScreenWidth()/4.32));
        addSprite(hand);

        handinverse=new MySprite_learn(game,Play_Assets.handinverse,0*w_unit,(int)(game.getScreenHeight()/2.70),(int)(game.getScreenHeight()/6.4),(int)(game.getScreenWidth()/4.32));
        //addSprite(handinverse);
        again=new MySprite_learn(game,Play_Assets.again,(int)(game.getScreenWidth()/1.22),(int)(game.getScreenHeight()/1.15),(int)(game.getScreenHeight()/8),(int)(game.getScreenWidth()/6));
        addSprite(again);


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


            game_activity.setScreen(new MyScreen(game,logic, game_activity));


        }
        if ((s == again ) && !(manager.isMusicActive())) {

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

    int flag =0;
    int flagi =0;
    public void job()
    {

        System.out.println("hand"+hand.getX());
        if (hand.getX()<(int)game.getScreenWidth()/5.4)
        //System.out.println("rouge"+hand.getX());
        {
            hand.setX((int)hand.getX() + (int)game.getScreenWidth()/216);
            //hand.setY((int)(game.getScreenHeight()/6.4));
        }else {
            if (flag != 3) {
                flag++;
                for (int i = 0; i < 7; i++) {
                    hand.setX((int) hand.getX() - (int)game.getScreenWidth()/216);
                }
            }
        }
        if (flag==3 )
        {
            System.out.println("y1"+handinverse.getY());
            hand.setWidth(0);
            addSprite(handinverse);

            if (handinverse.getY() <(int)(game.getScreenHeight()/2.20))

            {   //System.out.println("yyyy"+handinverse.getY());
                handinverse.setY((int) handinverse.getY() + (int)game.getScreenHeight()/192);

            } else {
                if (flagi != 5) {
                    flagi++;
                    for (int i = 0; i < 7; i++) {
                        hand.setY((int) handinverse.getY() -(int)game.getScreenHeight()/192);
                    }
                }



        }
        }
        if (flag==3 && flagi==5)
        {
            handinverse.setWidth(0);
            if (!(panier_fruits.contain(sprite.getX(),sprite.getY())))
            {
                sprite.setX(sprite.getX()-(int)game.getScreenWidth()/72);
                sprite.setY(sprite.getY()+(int)game.getScreenHeight()/77);
            }
            else
            {
                sprite.setPosition((int)(game.getScreenWidth()/5.68),(int)(game.getScreenHeight()/1.6));
                game.getCurrentScreen().
                        addSprite(new Sprite(Correct_faux.correct,0*w_unit,(int)(game.getScreenHeight()/1.58),(int)(game.getScreenHeight()/3.9),(int)(game.getScreenWidth()/3.08)));

            }

        }

        /*
        if (panier_legumes.contain(sprite.getX(),sprite.getY())  )
        {    //i=1;
            switch(this.logic.check())
            {
                case "legume":

                    sprite.setWidth((int)(game.getScreenWidth()/6));
                    sprite.setHeight((int)(game.getScreenHeight()/7));
                    sprite.setPosition((int)(game.getScreenWidth()/1.3),(int)(game.getScreenHeight()/1.6));
                    sprite.setDragged(false);
                    sprite.setStatic(true);
                    game.getCurrentScreen().
                            addSprite(new Sprite(Correct_faux.correct,(int)(game.getScreenWidth()/1.74),(int)(game.getScreenHeight()/1.58),(int)(game.getScreenHeight()/3.9),(int)(game.getScreenWidth()/2.25)));
                    System.out.println(logic.expressions.get_win_expression(logic));
                    logic.expressions.expression_play(logic.expressions.get_win_expression(logic));
                    game_activity.start();
                    game_activity.onFinish();


                    break;

                case "fruit":

                    sprite.setWidth((int)(game.getScreenWidth()/6));
                    sprite.setHeight((int)(game.getScreenHeight()/7));
                    sprite.setPosition((int)(game.getScreenWidth()/1.3),(int)(game.getScreenHeight()/1.6));
                    game.getCurrentScreen().
                            addSprite(new Sprite(Correct_faux.faux,(int)(game.getScreenWidth()/1.74),(int)(game.getScreenHeight()/1.58),(int)(game.getScreenHeight()/3.9),(int)(game.getScreenWidth()/2.25)));


                    logic.expressions.expression_play(logic.expressions.get_lose_expression(logic));
                    game_activity.start();
                    game_activity.onFinish();

                    break;

            }





            //addSprite(sprite);

        }
        else

        {
            if (panier_fruits.contain(sprite.getX(),sprite.getY()) )
            {  switch(this.logic.check())
            {
                case "fruit":

                    //sprite.setWidth((int)(game.getScreenWidth()/13.5));
                    //sprite.setHeight((int)(game.getScreenHeight()/12.8));
                    sprite.setWidth((int)(game.getScreenWidth()/6));
                    sprite.setHeight((int)(game.getScreenHeight()/7));
                    sprite.setPosition((int)(game.getScreenWidth()/5.68),(int)(game.getScreenHeight()/1.6));
                    sprite.setDragged(false);
                    sprite.setStatic(true);
                    game.getCurrentScreen().
                            addSprite(new Sprite(Correct_faux.correct,0*w_unit,(int)(game.getScreenHeight()/1.58),(int)(game.getScreenHeight()/3.9),(int)(game.getScreenWidth()/3.08)));
                    System.out.println(logic.expressions.get_win_expression(logic));

                    logic.expressions.expression_play(logic.expressions.get_win_expression(logic));
                    //MyGameActivity_play.Losingsound.setVolume(0.09f , 0.09f);

                    game_activity.start();
                    game_activity.onFinish();
                    break;

                case "legume":
                    sprite.setWidth((int)(game.getScreenWidth()/6));
                    sprite.setHeight((int)(game.getScreenHeight()/7));
                    sprite.setPosition((int)(game.getScreenWidth()/5.68),(int)(game.getScreenHeight()/1.6));
                    game.getCurrentScreen().
                            addSprite(new Sprite(Correct_faux.faux,0*w_unit,(int)(game.getScreenHeight()/1.58),(int)(game.getScreenHeight()/3.9),(int)(game.getScreenWidth()/3.08)));

                    logic.expressions.expression_play(logic.expressions.get_lose_expression(logic));
                    System.out.println(logic.expressions.get_lose_expression(logic));

                    //MyGameActivity_play.Losingsound.setVolume(0.09f , 0.09f);

                    game_activity.start();
                    game_activity.onFinish();
                    break;

            }

            }
        }

      */
    }

}
