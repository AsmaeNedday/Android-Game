package com.example.nedday.Jeu_T_6_21.logic;

import com.example.nedday.Jeu_T_6_21.Lists.List_Expressions;
import com.example.nedday.Jeu_T_6_21.Lists.List_animaux;
import com.example.nedday.Jeu_T_6_21.Lists.List_clothes;
import com.example.nedday.Jeu_T_6_21.Lists.List_fish;
import com.example.nedday.Jeu_T_6_21.Lists.List_fournitures;
import com.example.nedday.Jeu_T_6_21.Lists.List_fruits;
import com.example.nedday.Jeu_T_6_21.Lists.List_legumes;

import java.util.Random;

public class Mylogic {



    private List_legumes legumes ;
    private List_fruits   fruits ;
    private List_clothes clothes;
    private List_fournitures fournitures;
    private List_fish fish;
    private List_animaux animaux;


    private static String currentimage;
    private static String currentimage2;
    private static String currentimage3;
    private Random rnd ;
    public List_Expressions expressions ;

    public Mylogic() {
        expressions=new List_Expressions();
        legumes=new List_legumes();
        fruits=new List_fruits();
        fournitures=new List_fournitures();
        clothes=new List_clothes();
        fish=new List_fish();
        animaux=new List_animaux();
        rnd = new Random();
        int f = rnd.nextInt(14);
        currentimage = "im_"+f;
        f=rnd.nextInt(6);
        currentimage2 = "im2_"+f;
        f=rnd.nextInt(11);
        currentimage3= "im3_"+f;


    }
    public List_legumes getLegumes() {
        return legumes;
    }
    public List_fruits getFruits() {
        return fruits;
    }
    public List_clothes getClothes() {
        return clothes;
    }
    public List_fournitures getFournitures() {
        return fournitures;
    }
    public List_fish getFish() {return fish; }
    public List_animaux getAnimaux() { return animaux; }


    public static String getCurrentimage() {
        return currentimage;
    }
    public static String getCurrentimage2() {
        return currentimage2;
    }
    public static String getCurrentimage3() {
        return currentimage3;
    }



     public String check()
        {   String type="";
            if (this.getLegumes().isLegume(currentimage))
            {
                type="legume";
            }
            if (this.getFruits().isFruit(currentimage))
            {
                type="fruit";
            }

          return  type ;
}

public String check2()
{    String type="";
    if (this.getClothes().isClothes(currentimage2))
    {
        type="vetement";
    }
    if (this.getFournitures().isFournitures(currentimage2))
    {
        type="fourniture";
    }
    return  type ;
}
    public String check3()
    {    String type="";
        if (this.getFish().isFish(currentimage3))
        {
            type="fish";
        }
        if (this.getAnimaux().isAnimaux(currentimage3))
        {
            type="animal";
        }
        return  type ;
    }
     }

