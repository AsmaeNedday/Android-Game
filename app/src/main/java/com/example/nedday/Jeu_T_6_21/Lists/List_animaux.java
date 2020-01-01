package com.example.nedday.Jeu_T_6_21.Lists;

import java.util.ArrayList;

public class List_animaux {
    private ArrayList<String> animaux ;
    public List_animaux()
    {
        animaux=new ArrayList<String>();
        animaux.add("im3_2");
        animaux.add("im3_3");
        animaux.add("im3_4");
        animaux.add("im3_5");
        animaux.add("im3_6");
        animaux.add("im3_7");
        animaux.add("im3_8");
        animaux.add("im3_9");
        animaux.add("im3_10");


    }
    public boolean isAnimaux(String element)
    {   if (this.animaux.contains(element))
    {
        return true ;
    }
    else {return  false ;}
    }
}
