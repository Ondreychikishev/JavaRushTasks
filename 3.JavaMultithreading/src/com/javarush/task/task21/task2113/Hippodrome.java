package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chikishev-93 on 01.04.17.
 */
public class Hippodrome {
    private List<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;


    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses1 = new ArrayList<Horse>();
        Hippodrome hippodrome = new Hippodrome(horses1);
        game = hippodrome;
        Horse horse1 = new Horse("Andrey", 3, 0);
        Horse horse2 = new Horse("Anton", 3, 0);
        Horse horse3 = new Horse("Sem", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    public Horse getWinner() {
        double dis = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > dis) {
                dis = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
