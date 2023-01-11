package Player_interface;

import Game_env.Board;

import java.util.Scanner;

public class Human extends Player {
    /* A User can choose to play by writing in the console the coordinates of its move.*/
    public Human(Board board_ctrl) {
        this.board_ctrl = board_ctrl;
    }

    @Override
    public void computeMove() {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        while (true) {
            System.out.println("Enter the coordinates: ");
            try {
                x = scanner.nextInt();// Read the coordinates
                y = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                String aux = scanner.nextLine();
                continue;
            }
            x--;
            y--;
            if (x < 0 || x > 2 || y < 0 || y > 2) {// Make sure the input is valid
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (!board_ctrl.makeMove(x, y)) {// Check if the cell  is already occupied
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }
    }
}
