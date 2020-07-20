package model;

import type.Side;

public class King extends Piece {

    public King(Side side) {
        super(side);
    }

    public String getDisplayName() {
        return "Ki";
    }
}
