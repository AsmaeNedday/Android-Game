package com.example.nedday.Jeu_T_6_21.Lists;

import java.util.ArrayList;

public class List_fish {
    private ArrayList<String> fish ;
    public List_fish()
    {
        fish=new ArrayList<String>();
        fish.add("im3_0");
        fish.add("im3_1");


    }
    public boolean isFish(String element)
    {   if (this.fish.contains(element))
    {
        return true ;
    }
    else {return  false ;}
    }
}
