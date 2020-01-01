package com.example.nedday.Jeu_T_6_21.Sprites;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class MySprite_learn extends Sprite {
    private static final String TAG = "Square";

    Game g; //fore drawing purposes

    public MySprite_learn(Game game, Image image,int x, int y, int height, int width) {
        super(image, x, y, height, width);
        this.g = game;


    }
}