package model;

import type.Side;

public class Bishop extends Piece {

    public Bishop(Side side) {
        super(side);
    }

    public String getDisplayName() {
        return "B";
    }
}
