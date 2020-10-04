package main.RPC;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    Field field = new Field();

    public void start() {                          // Метод запуска программы
        do {
            choice();
            field.setYourWeapon(chooseYourWeapon());
            field.setProgramWeapon(chooseProgramWeapon());
            defineWinner(field.getProgramWeapon(), field.getYourWeapon());
            again();
        } while (toScan() == 1);
    }

    private int toScan() {                          // Метод считывания ввода пользователем значения в консоли
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


    private void choice() {                         // Метод вывода пользователю оружия на выбор
        System.out.println("\nChoose your weapon!\n" +
                "Input a number of your choice!");
        Weapon[] wpn = Weapon.values();
        for (Weapon w : wpn) {
            System.out.println((w.ordinal() + 1) + ". " + w);
        }
    }

    private Weapon chooseYourWeapon() {             // Метод выбора оружия пользователя
        int num = toScan();
        if ((num > 0) & (num < 4)) {
            return Weapon.values()[num - 1];
        } else {
            System.out.println("Non-existent number\n" +
                    "Try again");
            chooseYourWeapon();             // Повторный вызов метода при вводе несуществующего номера оружия
        }
        return null;
    }

    private Weapon chooseProgramWeapon() {          // Рандомный выбор оружия программы
        Random rand = new Random();
        int wpn = rand.nextInt(3);
        return Weapon.values()[wpn];
    }

    private void again() {                          // Метод считывает, желает ли пользователь продолжить игру
        System.out.println("\nInput '1' to play again!\nInput another number to exit!");
    }

    private void defineWinner(Weapon program, Weapon yours) {
        System.out.println("Your choice is " + yours);
        System.out.println("Program's choice is " + program);
        System.out.println();                // Метод сравнения оружия пользователя и программы
        switch (program) {
            case ROCK:
                switch (yours) {
                    case ROCK -> noWinner();
                    case PAPER -> youWin();
                    case SCISSORS -> programWin();
                }
                break;
            case PAPER:
                switch (yours) {
                    case ROCK -> programWin();
                    case PAPER -> noWinner();
                    case SCISSORS -> youWin();
                }
                break;
            case SCISSORS:
                switch (yours) {
                    case ROCK -> youWin();
                    case PAPER -> programWin();
                    case SCISSORS -> noWinner();
                }
                break;
        }
    }

    private void programWin() {
        System.out.println("Program is winner!");
    }

    private void youWin() {
        System.out.println("You win!");
    }

    private void noWinner() {
        System.out.println("No winner!");
    }
}
