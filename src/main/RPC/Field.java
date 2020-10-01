package main.RPC;

import java.util.Random;
import java.util.Scanner;

public class Field {
    static String yourWeapon;
    static String programWeapon;
    int num;

    Field() {
        do {
            choice();
            GameLogic game = new GameLogic();
            again();
        } while (num == 1);
    }

    static void choice() {      // Метод вывода пользователю оружия на выбор

        System.out.println("\nChoose your weapon!\n" +
                "Input a number of your choice!");
        Weapon[] wpn = Weapon.values();
        for (Weapon w : wpn) {
            System.out.println((w.ordinal() + 1) + ". " + w.getWeapon());
        }
        yourWeapon();
        System.out.println("Your choice is " + yourWeapon);
        System.out.println("Program's choice is " + programWeapon());
        System.out.println();
    }

    static void yourWeapon() {      // Метод выбора оружия пользователя
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if ((num > 0) & (num < 4)) {
            yourWeapon = Weapon.values()[(num - 1)].getWeapon();
        } else {
            System.out.println("Non-existent number\n" +
                    "Try again");
            yourWeapon();           // Повторный вызов метода при вводе
            // несуществующего номера оружия
        }

    }

    static String programWeapon() {     // Рандомный выбор оружия программы
        Random rand = new Random();
        int wpn = rand.nextInt(3);
        return programWeapon = Weapon.values()[wpn].getWeapon();
    }

    void again() {                          // Метод считывает, желает ли пользователь продолжить игру
        Scanner in = new Scanner(System.in);
        System.out.println("\nInput '1' to play again!\nInput another number to exit!");
        this.num = in.nextInt();
    }
}
