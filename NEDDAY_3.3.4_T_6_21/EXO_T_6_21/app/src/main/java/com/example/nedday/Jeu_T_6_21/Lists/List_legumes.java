package com.example.nedday.Jeu_T_6_21.Lists;

import java.util.ArrayList;

public class List_legumes {
    private ArrayList<String> legumes ;
    public List_legumes()
    {
        legumes=new ArrayList<String>();
        legumes.add("im_0");
        legumes.add("im_1");
        legumes.add("im_2");
        legumes.add("im_3");
        legumes.add("im_4");
        legumes.add("im_5");
        legumes.add("im_6");
    }
    public boolean isLegume(String element)
    {   if (this.legumes.contains(element))
        {
        return true ;
         }
    else {

        return  false ;}
    }
}
