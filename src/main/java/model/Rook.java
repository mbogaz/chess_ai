package model;

import type.Side;

public class Rook extends Piece {

    public Rook(Side side) {
        super(side);
    }

    public String getDisplayName() {
        return "R";
    }
}
