package Player_interface;

import Game_env.Board;

public class Hard extends Player {
    /* Here we have an AI that decides its next move with the help of minmax algorithm */
    public Hard(Board board_ctrl) {
        this.board_ctrl = board_ctrl;
    }

    int minmax(int[][] board, int player, int depth, Boolean getMax) {
        int whoWon = board_ctrl.checkWin();

        if (whoWon == player)
            return 10 - depth;
        if (whoWon == Math.abs(player - 1))
            return -10 + depth;
        if (whoWon == 2)
            return 0;

        if (getMax) {
            int best = -100;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = player;
                        best = Math.max(best, minmax(board, player, depth + 1, !getMax));
                        board[i][j] = -1;
                    }
                }
            }
            return best;
        } else {
            int best = 100;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = Math.abs(player - 1);
                        best = Math.min(best, minmax(board, player, depth + 1, !getMax));
                        board[i][j] = -1;
                    }
                }
            }
            return best;
        }
    }

    @Override
    public void computeMove() {
        int maxVal = -1000;
        int bestX = -1; // The coordinates of the best  move
        int bestY = -1;

        int[][] board = board_ctrl.getBoard();
        int player = board_ctrl.whoseTurn();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == -1) {

                    board[i][j] = player;
                    int moveVal = minmax(board, player, 0, false);
                    board[i][j] = -1;

                    if (moveVal > maxVal) {
                        bestX = i;
                        bestY = j;
                        maxVal = moveVal;
                    }
                }
            }
        }
        board_ctrl.makeMove(bestX, bestY);
    }
}
