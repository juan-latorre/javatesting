package com.javatestprj.javatesting.player;

public class Dice {
    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int roll(){
        return (int) (Math.random() * sides) + 1;
    }
}
