package com.example.nedday.Jeu_T_6_21.Lists;

import com.example.nedday.Jeu_T_6_21.Assets.Voice;
import com.example.nedday.Jeu_T_6_21.logic.Mylogic;
import com.example.nedday.Jeu_T_6_21.state.PopupActivity;

import java.util.ArrayList;
import java.util.Random;

public class List_Expressions {
    private ArrayList<String> lose_ar;
    private ArrayList<String> lose_fr;
    private ArrayList<String> lose_ang;
    private ArrayList<String> win_ar;
    private ArrayList<String> win_fr;
    private ArrayList<String> win_ang;
    private ArrayList<String> inst_ar;
    private ArrayList<String> inst_ang;
    private ArrayList<String> inst_fr;


    public List_Expressions() {

        /*
        lose_ar = new ArrayList<String>();
        lose_ar.add("lose_ar_0");
        lose_ar.add("lose_ar_1");
        lose_ar.add("lose_ar_2");

        lose_fr = new ArrayList<String>();
        lose_fr.add("lose_fr_0");
        lose_fr.add("lose_fr_1");
        lose_fr.add("lose_fr_3");

        lose_ang = new ArrayList<String>();
        lose_ang.add("lose_ang_0");
        lose_ang.add("lose_ang_1");
        win_ang = new ArrayList<String>();
        win_ang.add("win_ang_0");
        win_ang.add("win_ang_1");
        win_ang.add("win_ang_2");
        win_ang.add("win_ang_4");
        win_ang.add("win_ang_6");
        win_ar = new ArrayList<String>();
        win_ar.add("win_ar_0");
        win_ar.add("win_ar_1");
        win_ar.add("win_ar_2");
        win_ar.add("win_ar_3");
        win_ar.add("win_ar_4");
        win_ar.add("win_ar_7");
        win_fr = new ArrayList<String>();
        win_fr.add("win_fr_2");
        win_fr.add("win_fr_3");
        win_fr.add("win_fr_5");
        win_fr.add("win_fr_6");
        win_fr.add("win_fr_8");
        inst_ang = new ArrayList<String>();
        inst_ang.add("inst_ang_0");
        inst_ang.add("inst_ang_1");
        inst_ar = new ArrayList<String>();
        inst_ar.add("inst_ar_0");
        inst_fr = new ArrayList<String>();
        inst_fr.add("inst_fr_0");
        inst_fr.add("inst_fr_1");

    }

    public ArrayList<String> getLose_ar() {
        return lose_ar;
    }

    public void setLose_ar(ArrayList<String> lose_ar) {
        this.lose_ar = lose_ar;
    }

    public ArrayList<String> getLose_fr() {
        return lose_fr;
    }

    public void setLose_fr(ArrayList<String> lose_fr) {
        this.lose_fr = lose_fr;
    }

    public ArrayList<String> getLose_ang() {
        return lose_ang;
    }

    public void setLose_ang(ArrayList<String> lose_ang) {
        this.lose_ang = lose_ang;
    }

    public ArrayList<String> getWin_ar() {
        return win_ar;
    }

    public void setWin_ar(ArrayList<String> win_ar) {
        this.win_ar = win_ar;
    }

    public ArrayList<String> getWin_fr() {
        return win_fr;
    }

    public void setWin_fr(ArrayList<String> win_fr) {
        this.win_fr = win_fr;
    }

    public ArrayList<String> getWin_ang() {
        return win_ang;
    }

    public void setWin_ang(ArrayList<String> win_ang) {
        this.win_ang = win_ang;
    }

    public ArrayList<String> getInst_ar() {
        return inst_ar;
    }

    public void setInst_ar(ArrayList<String> inst_ar) {
        this.inst_ar = inst_ar;
    }

    public ArrayList<String> getInst_ang() {
        return inst_ang;
    }

    public void setInst_ang(ArrayList<String> inst_ang) {
        this.inst_ang = inst_ang;
    }

    public ArrayList<String> getInst_fr() {
        return inst_fr;
    }

    public void setInst_fr(ArrayList<String> inst_fr) {
        this.inst_fr = inst_fr;
    }

    public String get_win_expression(Mylogic logic) {
        Random rand = new Random();
        int max, min = 0, nombreAleatoire;
        String element = "";
        switch (PopupActivity.langue) {
            case 0:
                max = (logic.expressions).getWin_fr().size() - 1;
                nombreAleatoire = rand.nextInt(max - min + 1) + min;
                element = (logic.expressions).getWin_fr().get(nombreAleatoire);


                break;
            case 1:
                max = (logic.expressions).getWin_ar().size() - 1;
                nombreAleatoire = rand.nextInt(max - min + 1) + min;
                element = (logic.expressions).getWin_ar().get(nombreAleatoire);

                break;
            case 2:
                max = (logic.expressions).getWin_ang().size() - 1;
                nombreAleatoire = rand.nextInt(max - min + 1) + min;
                element = (logic.expressions).getWin_ang().get(nombreAleatoire);
                break;
        }

        return element;

    }

    public String get_lose_expression(Mylogic logic) {
        Random rand = new Random();
        int max, min = 0, nombreAleatoire;
        String element = "";
        switch (PopupActivity.langue) {
            case 0:
                max = (logic.expressions).getLose_fr().size() - 1;
                nombreAleatoire = rand.nextInt(max - min + 1) + min;
                element = (logic.expressions).getLose_fr().get(nombreAleatoire);


                break;
            case 1:
                max = (logic.expressions).getLose_ar().size() - 1;
                nombreAleatoire = rand.nextInt(max - min + 1) + min;
                element = (logic.expressions).getLose_ar().get(nombreAleatoire);

                break;
            case 2:
                max = (logic.expressions).getLose_ang().size() - 1;
                nombreAleatoire = rand.nextInt(max - min + 1) + min;
                element = (logic.expressions).getLose_ang().get(nombreAleatoire);
                break;
        }
        return element;
    }

    public void expression_play(String expression) {

        switch (expression) {
            case "win_ar_0":
                Voice.win_ar_0.play(1);
                break;
            case "win_ar_1":
                Voice.win_ar_1.play(1);
                break;
            case "win_ar_2":
                Voice.win_ar_2.play(1);
                break;
            case "win_ar_3":
                Voice.win_ar_3.play(1);
                break;
            case "win_ar_4":
                Voice.win_ar_4.play(1);
                break;
            case "win_ar_7":
                Voice.win_ar_7.play(1);
                break;


            case "win_ang_0":
                Voice.win_ang_0.play(1);
                break;
            case "win_ang_1":
                Voice.win_ang_1.play(1);
                break;
            case "win_ang_2":
                Voice.win_ang_2.play(1);
                break;
            case "win_ang_4":
                Voice.win_ang_4.play(1);
                break;
            case "win_ang_6":
                Voice.win_ang_6.play(1);
                break;


            case "win_fr_2":
                Voice.win_fr_2.play(1);
                break;
            case "win_fr_3":
                Voice.win_fr_3.play(1);
                break;
            case "win_fr_5":
                Voice.win_fr_5.play(1);
                break;
            case "win_fr_6":
                Voice.win_fr_6.play(1);
                break;
            case "win_fr_8":
                Voice.win_fr_8.play(1);
                break;


            case "lose_ang_0":
                Voice.lose_ang_0.play(1);
                break;
            case "lose_ang_1":
                Voice.lose_ang_1.play(1);
                break;

            case "lose_ar_0":
                Voice.lose_ar_0.play(1);
                break;
            case "lose_ar_1":
                Voice.lose_ar_1.play(1);
                break;
            case "lose_ar_2":
                Voice.lose_ar_2.play(1);
                break;

            case "lose_fr_0":
                Voice.lose_fr_0.play(1);
                break;
            case "lose_fr_1":
                Voice.lose_fr_1.play(1);
                break;
            case "lose_fr_3":
                Voice.lose_fr_3.play(1);
                break;


        }
*/

    }



    }
