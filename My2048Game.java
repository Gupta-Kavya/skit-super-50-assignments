/*
@filename - My2048Game.java
@description - Game Implementation
@author - Kavya Gupta
*/


package Assignment_3;

import java.util.Random;
import java.util.Scanner;

public class My2048Game {
    private int[][] board = new int[4][4];
    private Random random = new Random();

    My2048Game() {
        addRandomTile();
        addRandomTile();
    }

    void addRandomTile() {
        int row, col;
        if (isBoardFull()) return; 

        int value = random.nextInt(10) < 9 ? 2 : 4;
        do {
            row = random.nextInt(4);
            col = random.nextInt(4);
        } while (board[row][col] != 0);
        board[row][col] = value;
    }


    void displayBoard() {
        System.out.println("-----------------------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0)
                    System.out.print(".\t");
                else
                    System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }


    void moveLeft() {
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = new int[4];
            int index = 0;

            // compress
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    newRow[index++] = board[i][j];
                }
            }

            // merge
            for (int j = 0; j < 3; j++) {
                if (newRow[j] != 0 && newRow[j] == newRow[j + 1]) {
                    newRow[j] *= 2;
                    newRow[j + 1] = 0;
                    moved = true;
                }
            }

            // compress again
            int[] mergedRow = new int[4];
            index = 0;
            for (int j = 0; j < 4; j++) {
                if (newRow[j] != 0) {
                    mergedRow[index++] = newRow[j];
                }
            }

            // check if row changed
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != mergedRow[j]) {
                    moved = true;
                }
                board[i][j] = mergedRow[j];
            }
        }

        if (moved) addRandomTile();
    }


    void moveRight() {
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = new int[4];
            int index = 3;

         
            for (int j = 3; j >= 0; j--) {
                if (board[i][j] != 0) {
                    newRow[index--] = board[i][j];
                }
            }

           
            for (int j = 3; j > 0; j--) {
                if (newRow[j] != 0 && newRow[j] == newRow[j - 1]) {
                    newRow[j] *= 2;
                    newRow[j - 1] = 0;
                    moved = true;
                }
            }

          
            int[] mergedRow = new int[4];
            index = 3;
            for (int j = 3; j >= 0; j--) {
                if (newRow[j] != 0) {
                    mergedRow[index--] = newRow[j];
                }
            }

            for (int j = 0; j < 4; j++) {
                if (board[i][j] != mergedRow[j]) {
                    moved = true;
                }
                board[i][j] = mergedRow[j];
            }
        }

        if (moved) addRandomTile();
    }


    void moveUp() {
        boolean moved = false;
        for (int j = 0; j < 4; j++) {
            int[] newCol = new int[4];
            int index = 0;

        
            for (int i = 0; i < 4; i++) {
                if (board[i][j] != 0) {
                    newCol[index++] = board[i][j];
                }
            }

       
            for (int i = 0; i < 3; i++) {
                if (newCol[i] != 0 && newCol[i] == newCol[i + 1]) {
                    newCol[i] *= 2;
                    newCol[i + 1] = 0;
                    moved = true;
                }
            }

       
            int[] mergedCol = new int[4];
            index = 0;
            for (int i = 0; i < 4; i++) {
                if (newCol[i] != 0) {
                    mergedCol[index++] = newCol[i];
                }
            }

            for (int i = 0; i < 4; i++) {
                if (board[i][j] != mergedCol[i]) {
                    moved = true;
                }
                board[i][j] = mergedCol[i];
            }
        }

        if (moved) addRandomTile();
    }

  
    void moveDown() {
        boolean moved = false;
        for (int j = 0; j < 4; j++) {
            int[] newCol = new int[4];
            int index = 3;

           
            for (int i = 3; i >= 0; i--) {
                if (board[i][j] != 0) {
                    newCol[index--] = board[i][j];
                }
            }

          
            for (int i = 3; i > 0; i--) {
                if (newCol[i] != 0 && newCol[i] == newCol[i - 1]) {
                    newCol[i] *= 2;
                    newCol[i - 1] = 0;
                    moved = true;
                }
            }

          
            int[] mergedCol = new int[4];
            index = 3;
            for (int i = 3; i >= 0; i--) {
                if (newCol[i] != 0) {
                    mergedCol[index--] = newCol[i];
                }
            }

            for (int i = 0; i < 4; i++) {
                if (board[i][j] != mergedCol[i]) {
                    moved = true;
                }
                board[i][j] = mergedCol[i];
            }
        }

        if (moved) addRandomTile();
    }


    boolean hasWon() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 2048) return true;
            }
        }
        return false;
    }


    boolean isGameOver() {
        if (!isBoardFull()) return false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i < 3 && board[i][j] == board[i + 1][j]) ||
                    (j < 3 && board[i][j] == board[i][j + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isBoardFull() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) return false;
            }
        }
        return true;
    }

}