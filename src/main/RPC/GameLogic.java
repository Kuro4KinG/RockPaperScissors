package main.RPC;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    void start() {                          // Метод запуска программы
        Field field = new Field();
        do {
            choice();
            field.yourWeapon = ChooseYourWeapon();
            field.programWeapon = ChooseProgramWeapon();
            defindWinner(field.programWeapon, field.yourWeapon);
            again();
        } while (toScan() == 1);
    }

    int toScan() {                          // Метод считывания ввода пользователем значения в консоли
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


    void choice() {                         // Метод вывода пользователю оружия на выбор

        System.out.println("\nChoose your weapon!\n" +
                "Input a number of your choice!");
        Weapon[] wpn = Weapon.values();
        for (Weapon w : wpn) {
            System.out.println((w.ordinal() + 1) + ". " + w);
        }
    }

    Weapon ChooseYourWeapon() {             // Метод выбора оружия пользователя
        int num = toScan();
        if ((num > 0) & (num < 4)) {
            Weapon yourWeapon = Weapon.values()[num - 1];
            return yourWeapon;
        } else {
            System.out.println("Non-existent number\n" +
                    "Try again");
            ChooseYourWeapon();             // Повторный вызов метода при вводе несуществующего номера оружия
        }
        return null;
    }

    Weapon ChooseProgramWeapon() {          // Рандомный выбор оружия программы
        Random rand = new Random();
        int wpn = rand.nextInt(3);
        Weapon programWeapon = Weapon.values()[wpn];
        return programWeapon;
    }

    void again() {                          // Метод считывает, желает ли пользователь продолжить игру
        System.out.println("\nInput '1' to play again!\nInput another number to exit!");
    }

    void defindWinner(Weapon program, Weapon yours) {
        System.out.println("Your choice is " + yours);
        System.out.println("Program's choice is " + program);
        System.out.println();                // Метод сравнения оружия пользователя и программы
        switch (program) {
            case ROCK:
                switch (yours) {
                    case ROCK:
                        noWinner();
                        break;
                    case PAPER:
                        youWin();
                        break;
                    case SCISSORS:
                        programWin();
                        break;
                }
                break;
            case PAPER:
                switch (yours) {
                    case ROCK:
                        programWin();
                        break;
                    case PAPER:
                        noWinner();
                        break;
                    case SCISSORS:
                        youWin();
                        break;
                }
                break;
            case SCISSORS:
                switch (yours) {
                    case ROCK:
                        youWin();
                        break;
                    case PAPER:
                        programWin();
                        break;
                    case SCISSORS:
                        noWinner();
                        break;
                }
                break;
        }
    }

    void programWin() {
        System.out.println("Program is winner!");
    }

    void youWin() {
        System.out.println("You win!");
    }

    void noWinner() {
        System.out.println("No winner!");
    }
}
