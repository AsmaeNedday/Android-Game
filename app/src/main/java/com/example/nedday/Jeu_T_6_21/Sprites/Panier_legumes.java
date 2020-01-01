package com.example.nedday.Jeu_T_6_21.Sprites;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class Panier_legumes extends Sprite {


    Game g; //fore drawing purposes


    public Panier_legumes(Game game, Image image, int x, int y, int height, int width) {
            super( image, x, y, height, width);
            this.g = game;

    }


}
