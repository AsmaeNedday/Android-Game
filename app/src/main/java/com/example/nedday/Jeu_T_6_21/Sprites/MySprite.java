package com.example.nedday.Jeu_T_6_21.Sprites;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class MySprite extends Sprite {


    Game g; //fore drawing purposes


    public MySprite(Game game, Image image, int x, int y, int height, int width) {
        super( image, x, y, height, width);
        this.g=game;
        setStatic(false);

    }

    /*
     * Notice that we defined square in the Screen as
     * ph[i][j] = forest Square(game,SquareAssets.square,i*w_unit,j*h_unit,h_unit,w_unit);
     * so to get the iterators i and j back, and use them in the logic of the game
     * notice that i = this.x / this.width because
     * this.x = i*w_unit and this.width = w_unit
     * */



}
