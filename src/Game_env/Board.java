package Game_env;

import java.util.Scanner;

public class Board {
    protected int[][] board = new int[3][3];

    public Board() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = -1;
    }

    public int[][] getBoard() {
        return board;
    }

    public void readBoard() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (input.charAt(i * 3 + j)) {
                    case '_' -> board[i][j] = -1;
                    case 'O' -> board[i][j] = 0;
                    case 'X' -> board[i][j] = 1;
                    default -> System.out.println("Error with input!");
                }
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case -1 -> System.out.print("  ");
                    case 0 -> System.out.print("O ");
                    case 1 -> System.out.print("X ");
                }
            }
            System.out.println('|');
        }
        System.out.println("---------");
    }

    public int checkWin() {
        //Return 0 if O wins, 1 if X wins, 2 if it's a draw and -1 if the game is not finished
        boolean isWin;
        boolean isFull = true; //Check if table has free spaces
        int player;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == -1)
                    isFull = false;
            }
        }
        if (isFull)
            return 2;


        for (int i = 0; i < 3; i++) { //Check win on line
            player = board[i][0];
            isWin = true;
            for (int j = 0; j < 3; j++) {
                if (player != board[i][j]) {
                    isWin = false;
                    break;
                }
            }
            if (isWin && player == 0)
                return 0;
            if (isWin && player == 1)
                return 1;
        }

        for (int i = 0; i < 3; i++) { //Check win on column
            player = board[0][i];
            isWin = true;
            for (int j = 0; j < 3; j++) {
                if (player != board[j][i]) {
                    isWin = false;
                    break;
                }
            }
            if (isWin && player == 0)
                return 0;
            if (isWin && player == 1)
                return 1;
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            if (board[1][1] == 1)
                return 1;
            if (board[1][1] == 0)
                return 0;
        }

        return -1;//Game not finished
    }

    public int whoseTurn() {
        int whoPlays = 0;
        for (int i = 0; i < 3; i++) { //Check whose turn it is.
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0)
                    whoPlays--;
                if (board[i][j] == 1)
                    whoPlays++;
            }
        }
        if (whoPlays == 0)
            return 1;
        else
            return 0;
    }

    public boolean makeMove(int x, int y) {
        if (board[x][y] != -1)
            return false;

        board[x][y] = whoseTurn();
        return true;
    }

}
