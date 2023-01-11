package Player_interface;

import Game_env.Board;

public class Medium extends Easy {
    public Medium(Board board_ctrl) {
        super(board_ctrl);
    }

    boolean checkIfOneMoveNeeded(int[][] board, int player) {
        boolean makeMove;
        for (int i = 0; i < 3; i++) { //Check for possible win on line
            makeMove = true;
            int nrMarks = 0;
            for (int j = 0; j < 3; j++) {
                if (player == board[i][j])
                    nrMarks++;
                if (player != board[i][j] && board[i][j] != -1) {
                    makeMove = false;
                    break;
                }
            }
            if (makeMove && nrMarks == 2) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == -1) {
                        board_ctrl.makeMove(i, j);
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) { //Check for possible win on column
            makeMove = true;
            int nrMarks = 0;
            for (int j = 0; j < 3; j++) {
                if (player == board[i][j])
                    nrMarks++;
                if (player != board[j][i] && board[j][i] != -1) {
                    makeMove = false;
                    break;
                }
            }
            if (makeMove && nrMarks == 2) {
                for (int j = 0; j < 3; j++) {
                    if (board[j][i] == -1) {
                        board_ctrl.makeMove(j, i);
                        return true;
                    }
                }
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == -1) {
            board_ctrl.makeMove(2, 2);
            return true;
        }
        if (board[0][0] == player && board[1][1] == -1 && board[2][2] == player) {
            board_ctrl.makeMove(1, 1);
            return true;
        }
        if (board[0][0] == -1 && board[1][1] == player && board[2][2] == player) {
            board_ctrl.makeMove(0, 0);
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == -1) {
            board_ctrl.makeMove(2, 0);
            return true;
        }
        if (board[0][2] == player && board[1][1] == -1 && board[2][0] == player) {
            board_ctrl.makeMove(1, 1);
            return true;
        }
        if (board[0][2] == -1 && board[1][1] == player && board[2][0] == player) {
            board_ctrl.makeMove(0, 2);
            return true;
        }
        return false;
    }

    @Override
    public void computeMove() {
        int[][] board = board_ctrl.getBoard();
        System.out.println("Making move level \"medium\"");
        int player = board_ctrl.whoseTurn();
        if (checkIfOneMoveNeeded(board, player))//Check for possible win
            return;
        if (checkIfOneMoveNeeded(board, Math.abs(player - 1)))//Check for possible lose
            return;
        makeRandomMove(board);
    }
}
