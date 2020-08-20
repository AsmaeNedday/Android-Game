package com.example.nedday.Jeu_T_6_21.Lists;

import java.util.ArrayList;

public class List_fournitures {
    private ArrayList<String> fournitures ;
    public List_fournitures()
    {
        fournitures=new ArrayList<String>();
        fournitures.add("im2_0");
        fournitures.add("im2_1");
        fournitures.add("im2_2");
        fournitures.add("im2_3");

    }
    public boolean isFournitures(String element)
    {   if (this.fournitures.contains(element))
    {
        return true ;
    }
    else {return  false ;}
    }
}

