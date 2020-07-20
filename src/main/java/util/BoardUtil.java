package util;

import config.Constants;
import model.*;
import type.Side;

public class BoardUtil {

    public static Piece[][] initBoard() {
        Piece[][] board = new Piece[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            board[1][i] = new Pawn(Side.WHITE);
            board[Constants.BOARD_SIZE - 2][i] = new Pawn(Side.BLACK);

            if (i % 7 == 0) {
                board[0][i] = new Rook(Side.WHITE);
                board[Constants.BOARD_SIZE - 1][i] = new Rook(Side.BLACK);
            } else if(i%5 == 1) {
                board[0][i] = new Knight(Side.WHITE);
                board[Constants.BOARD_SIZE - 1][i] = new Knight(Side.BLACK);
            } else if(i == 2 || i == 5) {
                board[0][i] = new Bishop(Side.WHITE);
                board[Constants.BOARD_SIZE - 1][i] = new Bishop(Side.BLACK);
            } else if(i == 3) {
                board[0][i] = new King(Side.WHITE);
                board[Constants.BOARD_SIZE - 1][i] = new Queen(Side.BLACK);
            } else {
                board[0][i] = new Queen(Side.WHITE);
                board[Constants.BOARD_SIZE - 1][i] = new King(Side.BLACK);
            }
        }

        return board;
    }
}
