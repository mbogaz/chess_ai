package model;

import type.Side;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    public String getDisplayName() {
        return "Kn";
    }
}
