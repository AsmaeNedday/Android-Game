package com.example.nedday.Jeu_T_6_21.Lists;

import java.util.ArrayList;

public class List_fruits  {

    private ArrayList<String> fruits ;
    public List_fruits()
    {
        fruits=new ArrayList<String>();
        fruits.add("im_7");
        fruits.add("im_8");
        fruits.add("im_9");
        fruits.add("im_10");
        fruits.add("im_11");
        fruits.add("im_12");
        fruits.add("im_13");
        fruits.add("im_14");
        fruits.add("im_15");
    }
    public boolean isFruit(String element)
    {   if (this.fruits.contains(element))
    {
        return true ;
    }
    else {return  false ;}
    }
}
