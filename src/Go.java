//madison davis
//Go board
//4/7/24

import java.util.ArrayList;
import java.util.Scanner;
// Removed incorrect import statement

public class Go {

    // static String[][] GoBoard = new String[9][9];

    static String[][] GoBoard = {
            { null, null, null, null, null, null, null, null, null, },
            { null, null, null, null, null, null, null, null, null, },
            { null, null, null, null, null, null, null, null, null, },
            { null, null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null, null, null, },
            { null, null, null, null, null, null, null, null, null, },
            { null, null, null, null, null, null, null, null, null, },
            { null, null, null, null, null, null, null, null, null, }
    };

    // keeps track of first structure, allows us to check if piece is alive or not
    // static boolean[][] lives = new boolean[9][9];

    static boolean[][] beenChecked = new boolean[9][9];

    static boolean[][] dead = new boolean[9][9];

    // keeps track of dead or alive

    // dead or alive array that looks through booard
    // looks through if dead matches with color piece

    /*
     * 
     * static boolean[][] isVisited = new String[GoBoard.length][GoBoard.length];
     * 
     * static boolean statusCheck(){
     * return true;
     * }
     * 
     * private static void recentVisited() {
     * for (boolean[] row : isVisited) {
     * Arrays.fill(row, false);
     * }
     * }
     */

    static boolean canBreathe(int col, int row) {
        // have checks for out of bounds

        if (GoBoard[col][row] == null) {
            return true;
        }

        if (row + 1 < 9 && GoBoard[col][row + 1] == null) {
            return true;
        }

        if (row - 1 > -1 && GoBoard[col][row - 1] == null) {
            return true;
        }

        if (col - 1 > -1 && GoBoard[col - 1][row] == null) {
            return true;
        }

        if (col + 1 < 9 && GoBoard[col + 1][row] == null) {
            return true;
        }

        return false;
    }

    // checks if piece is alive
    static boolean isAlive(int col, int row) {
        // run on every spot each turn

        beenChecked[col][row] = true;

        if (canBreathe(col, row)) {
            return true;
        }

        if ((col - 1) > -1 && GoBoard[col - 1][row] == GoBoard[col][row] && !beenChecked[col - 1][row]) {
            return isAlive(col - 1, row);
        }

        if ((col + 1) < 9 && GoBoard[col + 1][row] == GoBoard[col][row] && !beenChecked[col + 1][row]) {
            return isAlive(col + 1, row);
        }

        if ((row + 1) < 9 && GoBoard[col][row + 1] == GoBoard[col][row] && !beenChecked[col][row + 1]) {
            return isAlive(col, row + 1);
        }

        if ((row - 1) > -1 && GoBoard[col][row - 1] == GoBoard[col][row] && !beenChecked[col][row - 1]) {
            return isAlive(col, row - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int moveX;
        int moveY;

        int black_score = 0;
        int white_score = 0;

        Boolean player_turn = true;

        int max_length = GoBoard.length;

        Scanner user_input = new Scanner(System.in);

        int black_count_pass = 2;
        int white_count_pass = 0;

        String black_pass = "a";
        String white_pass = "b";

        ArrayList<String> pass = new ArrayList<String>();
        boolean passing = false;

        // System.out.println(max_length);

        while (passing != true) {
            // reset each time
            beenChecked = new boolean[9][9];

            System.out.println("0  1 2 3 4 5 6 7 8 9");

            for (int i = 0; i < GoBoard.length; i++) {
                // handles columns of board (19)
                System.out.print(i + 1 + " ");

                for (int j = 0; j < GoBoard[i].length; j++) {
                    if (GoBoard[i][j] == null) {
                        System.out.print("-|");
                    } else
                        System.out.print(GoBoard[i][j]);
                }
                System.out.println();
            }

            System.out.println("\n" + ((player_turn) ? "Black" : "White") + "'s turn\n\n");

            System.out.println("What column would you like to place your piece at "
                    + ((player_turn) ? "Black" : "White") + " (or -1 to pass) ?");
            moveX = user_input.nextInt();

            System.out.println("What row would you like to place your piece at " + ((player_turn) ? "Black" : "White")
                    + " (or -1 to pass) ?");
            moveY = user_input.nextInt();

            // prints players move
            if (moveY != -1 && moveX != -1) {
                System.out.println(((player_turn) ? "Black" : "White") + " you placed your piece at: ");
                System.out.println(moveX + "," + moveY);
                System.out.println();

            } else {
                System.out.println(((player_turn) ? "Black" : "White") + " has passed on their turn");
                System.out.println();
            }

            // passing on players turn (consecutive ends game)
            if (moveY == -1 || moveX == -1) {
                if (player_turn != true) {
                    pass.add(black_pass);
                    black_count_pass += 1;
                    player_turn = !player_turn;

                } else {
                    pass.add(white_pass);
                    white_count_pass += 1;
                    player_turn = !player_turn;
                }

                for (int i = 0; i < pass.size() - 1; i++) {
                    // black first
                    if ((pass.get(i) == "b") && (pass.get(i + 1) == "a")) {
                        passing = true;
                        // System.out.println("pass");
                    }
                    // white first
                    else {
                        if ((pass.get(i) == "a") && (pass.get(i + 1) == "b")) {
                            passing = true;

                        }
                    }
                }
                continue;

            } else if (moveY > max_length || moveY < 0 || (moveX > max_length || moveX < 0)) {
                System.out.println("Out of Bounds");
                System.out.println();
                continue;

            } else {
                if ((moveY == 0) || (moveX == 0)) {
                    System.out.println("Not a valid move please choose again");
                    System.out.println();
                    continue;

                } else if (GoBoard[moveY - 1][moveX - 1] == null) {
                    GoBoard[moveY - 1][moveX - 1] = ((player_turn) ? "-B" : "-W");

                } else {
                    System.out.println("There is already a piece there, please choose another space");
                    System.out.println();
                    continue;
                }
            }

            // reset spot being alive
            dead = new boolean[9][9];
            for (int i = 0; i < GoBoard.length; i++) {
                for (int j = 0; j < GoBoard[i].length; j++) {
                    // removing piece adds one to score
                    if (GoBoard[i][j] == "-B" && !isAlive(i, j)) {
                        white_score += 1;
                        dead[i][j] = true;
                    }

                    if (GoBoard[i][j] == "-W" && !isAlive(i, j)) {
                        black_score += 1;
                        dead[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < GoBoard.length; i++) {
                for (int j = 0; j < GoBoard[i].length; j++) {
                    if (dead[i][j]) {
                        GoBoard[i][j] = null;
                    }
                }
            }

            System.out.println();
            System.out.println("White score: " + white_score);
            System.out.println("Black score: " + black_score);
            System.out.println();

            player_turn = !player_turn;

        }

        System.out.println("Both player's have passed and the game is over");
        // System.out.println(pass);
    }
}

// 👻

// allows suicide moves
// allows placing in prev spot