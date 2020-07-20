package model;

import type.Side;

public class Queen extends Piece {

    public Queen(Side side) {
        super(side);
    }

    public String getDisplayName() {
        return "Q";
    }
}
