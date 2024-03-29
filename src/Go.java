//madison davis
//Go board
//4/7/24

import java.util.Scanner;

public class Go {

    static String[][] GoBoard = new String[9][9];

    static String white = "◯";
    static String black = "●";

    public static void main (String [] args){
        int moveX;
        int moveY;

        Boolean cont = true;
        Boolean player_turn = true;

        int max_length = GoBoard.length - 1;

        Scanner user_input = new Scanner(System.in);

        //System.out.println("0  1 2 3 4 5 6 7 8 9");

        while (cont){

            System.out.println("0  1 2 3 4 5 6 7 8 9");
            
            for (int i = 0; i < GoBoard.length; i++) {
                // handles columns of board (19)
                System.out.print(i+1 + " ");

                for (int j = 0; j < GoBoard[i].length; j++) {
                    if (j == 0)
                        System.out.print("|");
        
                    GoBoard[i][j] = " ";
                    System.out.print("-|");

                }
                System.out.println();
            }

        //say if black or whites turn
        //System.out.print("It is " + color + "")
        System.out.println("\n" + ((player_turn) ? "Black" : "White") + "'s turn\n\n");
        

        System.out.println("What row would you like to place your piece at " + ((player_turn) ? "Black" : "White") + "?");
        //black or white piece
        moveX = user_input.nextInt();

        System.out.println("What column would you like to place your piece at " + ((player_turn) ? "Black" : "White") + "?");
        //black or white piece
        moveY = user_input.nextInt();

        /* 
        System.out.println(((player_turn) ? "Black" : "White") + " you placed your piece at: ");
        //+ where piece moved
        System.out.println(moveX + "," + moveY);
        System.out.println();
        */

        if (moveY > max_length || moveY < 0 || (moveX > max_length || moveX < 0)){
            System.out.println("Out of Bounds");
            System.out.println();
            continue;

        } else{
            if (GoBoard[moveY][moveX] == null){
                GoBoard[moveY][moveX] = ((player_turn) ?  "-●" : "-◯");
                System.out.println("o");

            //automaticaly goes to this option
            /* 
            } else {
                System.out.println("Choose another place, there is already a piece in that spot");
                System.out.println();
                continue;
            }
            */
        } else{
            continue;
        }
        }

        player_turn = !player_turn;
        

        }     

    }
}

