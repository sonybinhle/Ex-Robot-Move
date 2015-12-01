package com.xeasony;

import java.util.Vector;

public class Robot {

    private Grid grid;
    private Vector<Coordinate> moves;
    private int totalWay;

    public Robot(int _size) {
        this.grid = new Grid(_size);
        this.moves = new Vector<>();

        Coordinate left = new Coordinate(-1, 0);
        Coordinate right = new Coordinate(1, 0);
        Coordinate up = new Coordinate(0, -1);
        Coordinate down = new Coordinate(0, 1);

        this.moves.add(left);
        this.moves.add(right);
        this.moves.add(up);
        this.moves.add(down);
    }

    public int getTotalWay() {
        totalWay = 0;
        grid.init();
        tryMove();

        return totalWay;
    }

    private void tryMove() {
        if (grid.isInLowerRightCorner()) {
            totalWay++;
            return;
        }

        moves.stream().filter(move -> grid.moveBy(move)).forEach(move -> {
            tryMove();
            grid.revertMoveBy(move);
        });
    }
}
