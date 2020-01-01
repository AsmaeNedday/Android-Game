package com.example.nedday.Jeu_T_6_21.state;


import android.content.Intent;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.ensias_auth_library.FoxyAuth;
import com.example.nedday.Jeu_T_6_21.Assets.Learn2_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Learn3_Assets;
import com.example.nedday.Jeu_T_6_21.Assets.Learn_Assets;
import com.example.nedday.Jeu_T_6_21.R;
import com.example.nedday.Jeu_T_6_21.Views.Learn_Clothes_Screen;
import com.example.nedday.Jeu_T_6_21.Views.Learn_Fish_Screen;
import com.example.nedday.Jeu_T_6_21.Views.Learn_Fournitures_Screen;
import com.example.nedday.Jeu_T_6_21.Views.Learn_Fruits_Screen;
import com.example.nedday.Jeu_T_6_21.Views.Learn_Legumes_Screen;
import com.example.nedday.Jeu_T_6_21.Views.Learn_animals_Screen;

import com.example.nedday.Jeu_T_6_21.logic.Mylogic;

import static com.example.nedday.Jeu_T_6_21.state.First.mp;


public class MyGameActivity extends AndroidGame {

    Mylogic logic ;


    @Override
    public Screen getInitScreen() {
        if (mp.isPlaying())
        {
             mp.pause();
        }

        Screen screen=null;
        logic=new Mylogic();
        initAssets();


            switch (PopupActivity.niveau) {
                case 1:
                      screen = new Learn_Legumes_Screen(this, logic, this);

                    break;
                case 2:screen = new Learn_Fruits_Screen(this, logic, this);

                    break;
                case 3:screen = new Learn_animals_Screen(this, logic, this);

                    break;
                case 4:screen = new Learn_Fish_Screen(this, logic, this);
                     break;
                case 5:screen=new Learn_Fournitures_Screen(this, logic, this);
                     break;
                case 6:screen = new Learn_Clothes_Screen(this, logic, this);
                      break;


        }
        return screen;
    }

    private void initAssets() {


        Learn2_Assets.im2_0=getGraphics().newImage(R.drawable.im2_0, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_1=getGraphics().newImage(R.drawable.im2_1, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_2=getGraphics().newImage(R.drawable.im2_2, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_3=getGraphics().newImage(R.drawable.im2_3, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_4=getGraphics().newImage(R.drawable.im2_4, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_6=getGraphics().newImage(R.drawable.im2_6, Graphics.ImageFormat.ARGB8888, getResources());
        Learn2_Assets.im2_7=getGraphics().newImage(R.drawable.im2_7, Graphics.ImageFormat.ARGB8888, getResources());



        Learn3_Assets.im3_0=getGraphics().newImage(R.drawable.im3_0, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_1=getGraphics().newImage(R.drawable.im3_1, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_2=getGraphics().newImage(R.drawable.im3_2, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_3=getGraphics().newImage(R.drawable.im3_3, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_4=getGraphics().newImage(R.drawable.im3_4, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_5=getGraphics().newImage(R.drawable.im3_5, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_6=getGraphics().newImage(R.drawable.im3_6, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_7=getGraphics().newImage(R.drawable.im3_7, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_8=getGraphics().newImage(R.drawable.im3_8, Graphics.ImageFormat.ARGB8888, getResources());
        Learn3_Assets.im3_9=getGraphics().newImage(R.drawable.im3_9, Graphics.ImageFormat.ARGB8888, getResources());



        Learn_Assets.backlearn=getGraphics().newImage(R.drawable.popu, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.backmenu=getGraphics().newImage(R.drawable.jardin, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.teacher=getGraphics().newImage(R.drawable.teacher, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.underwater=getGraphics().newImage(R.drawable.underwater, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.room=getGraphics().newImage(R.drawable.room, Graphics.ImageFormat.ARGB8888, getResources());
        Learn_Assets.womenteacher=getGraphics().newImage(R.drawable.womanteacher, Graphics.ImageFormat.ARGB8888, getResources());







    }
    public void start() {


        Intent i = new Intent(this,MyGameActivity.class);
        startActivity(i);
    }

    public void onFinish()
    {

       this.finish();
    }


}