# Tic-Tac-Toe with MinMax

### Possible commands

start <player1 - X> <player2 - O>

exit

### Player options

user : A human player, you will be asked when it is your turn to write the coordinates where you want your next move to be placed.

easy : An AI that chooses its next move randomly

medium : An AI that makes moves using the following logic:

1. If it already has two in a row and can win with one further move, it does so.
2. If its opponent can win with one move, it plays the move necessary to block this.
3. Otherwise, it makes a random move.

hard : An AI that uses the MinMax algorithm. This is a brute force algorithm that maximizes the value of the AI's position and minimizes the worth of its opponent.

## Output example
The example below shows how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

<pre>
Input command: > start hard user
Making move level "hard"
---------
|       |
| X     |
|       |
---------
Enter the coordinates: > 2 2
---------
|       |
| X O   |
|       |
---------
Making move level "hard"
---------
|   X   |
| X O   |
|       |
---------
Enter the coordinates: > 3 2
---------
|   X   |
| X O   |
|   O   |
---------
Making move level "hard"
---------
| X X   |
| X O   |
|   O   |
---------
Enter the coordinates: > 3 1
---------
| X X   |
| X O   |
| O O   |
---------
Making move level "hard"
---------
| X X X |
| X O   |
| O O   |
---------
X wins

Input command: > exit
</pre>