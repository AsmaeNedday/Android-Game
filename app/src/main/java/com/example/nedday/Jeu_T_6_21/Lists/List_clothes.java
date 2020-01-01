package com.example.nedday.Jeu_T_6_21.Lists;

import java.util.ArrayList;

public class List_clothes {
    private ArrayList<String> clothes ;
    public List_clothes()
    {
        clothes=new ArrayList<String>();
        clothes.add("im2_4");
        clothes.add("im2_5");
        clothes.add("im2_6");
        clothes.add("im2_7");

    }
    public boolean isClothes(String element)
    {   if (this.clothes.contains(element))
    {
        return true ;
    }
    else {return  false ;}
    }
}
