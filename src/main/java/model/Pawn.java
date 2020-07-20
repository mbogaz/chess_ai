package model;

import type.Side;

public class Pawn extends Piece {

    public Pawn(Side side) {
        super(side);
    }

    public String getDisplayName() {
        return "P";
    }
}
