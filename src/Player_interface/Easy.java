package Player_interface;

import java.util.Random;
import Game_env.Board;

public class Easy extends Player {
    public Easy(Board board_ctrl) {
        this.board_ctrl = board_ctrl;
    }

    void makeRandomMove(int[][] board) {
        int nrPossibleMoves = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == -1)
                    nrPossibleMoves++;

        Random random = new Random();
        int move = random.nextInt(nrPossibleMoves);
        move++;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == -1) {
                    move--;
                    if (move == 0)
                        board_ctrl.makeMove(i, j);
                }
    }

    @Override
    public void computeMove() {
        int[][] board = board_ctrl.getBoard();
        System.out.println("Making move level \"easy\"");
        makeRandomMove(board);
    }
}
