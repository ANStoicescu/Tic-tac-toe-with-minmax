package Player_interface;

import Game_env.Board;

public abstract class Player {
    Board board_ctrl;

    public abstract void computeMove();
}
