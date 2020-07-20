package user_interface;

import config.Constants;
import model.*;
import util.BoardUtil;

public class CliGame {

    private Piece[][] board;

    public CliGame() {
       board = BoardUtil.initBoard();
    }

    public void draw() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                Piece p = board[i][j];
                if (p != null) {
                    String text = p.getDisplayName();
                    if(text.length() == 2) {
                        System.out.print("(" + p + ")");
                    } else {
                        System.out.print("(" + p + " )");
                    }
                } else {
                    System.out.print("      ");
                }
                if (j + 1 != Constants.BOARD_SIZE) {
                    System.out.print(" - ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

}
