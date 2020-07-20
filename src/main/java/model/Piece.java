package model;

import type.Side;

public abstract class Piece {

    public Side side;

    public Piece(Side side) {
        this.side = side;
    }

    public Side getSide() {
        return side;
    }

    public abstract String getDisplayName();

    public String toString() {
        return side.name().charAt(0) + "-" + getDisplayName();
    }
}
