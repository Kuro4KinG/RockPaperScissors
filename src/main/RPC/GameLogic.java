package main.RPC;

public class GameLogic {
    GameLogic() {
        defindWinner(Field.programWeapon, Field.yourWeapon);
    }


    void defindWinner(String program, String yours) {       // Метод сравнения оружия пользователя
        switch (program) {                                  // и программы
            case "Rock":
                switch (yours) {
                    case "Rock":
                        noWinner();
                        break;
                    case "Paper":
                        youWin();
                        break;
                    case "Scissors":
                        programWin();
                        break;
                }
                break;
            case "Paper":
                switch (yours) {
                    case "Rock":
                        programWin();
                        break;
                    case "Paper":
                        noWinner();
                        break;
                    case "Scissors":
                        youWin();
                        break;
                }
                break;
            case "Scissors":
                switch (yours) {
                    case "Rock":
                        youWin();
                        break;
                    case "Paper":
                        programWin();
                        break;
                    case "Scissors":
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
