/*
@filename - Game2048.java
@description - 2048 Game class usage
@author - Kavya Gupta
*/


package Assignment_3;

import java.util.Scanner;

public class Game2048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        My2048Game game = new My2048Game();

        System.out.println("Use W (Up), A (Left), S (Down), D (Right)");
        game.displayBoard();

        while (true) {
            System.out.print("Enter move: ");
            char move = sc.next().toLowerCase().charAt(0);

            switch (move) {
                case 'w': game.moveUp(); break;
                case 'a': game.moveLeft(); break;
                case 's': game.moveDown(); break;
                case 'd': game.moveRight(); break;
                default: 
                    System.out.println("Invalid input! Use W/A/S/D");
                    continue;
            }

            game.displayBoard();

            if (game.hasWon()) {
                System.out.println("You Win! You made 2048!");
                break;
            }

            if (game.isGameOver()) {
                System.out.println("Game Over! No moves left!");
                break;
            }
        }

        sc.close();
    }

}
