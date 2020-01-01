package com.example.nedday.Jeu_T_6_21.Views;

import android.content.Intent;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.nedday.Jeu_T_6_21.state.First;
import com.example.nedday.Jeu_T_6_21.state.PopupActivity;

public class Menu_Screen extends Screen {


    private First firstactivity ;




    public Menu_Screen(Game game, First firstactivity) {
        super(game);
        this.firstactivity=firstactivity;
        putPlaceHolders();



    }


    private void putPlaceHolders(){
        Intent i = new Intent(firstactivity,PopupActivity.class);
        firstactivity.finish();
        firstactivity.startActivity(i);

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








}
