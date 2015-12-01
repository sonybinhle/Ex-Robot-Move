package com.xeasony;

import java.util.Arrays;

public class Grid {
    private int size;
    private boolean[][] grid;
    Coordinate position;

    public Grid(int _size) {
        this.size = _size;
        this.grid = new boolean[size][size];

        init();
    }

    public void init() {
        for (boolean[] row: grid) Arrays.fill(row, false);
        position = new Coordinate(0, 0);
        grid[0][0] = true;
    }

    public boolean moveTo(Coordinate newPosition, boolean forward) {
        if ( (!isInGrid(newPosition)) || (forward && isVisited(newPosition))) {
            return false;
        } else {
            if (forward) {
                grid[newPosition.x][newPosition.y] = true;
            } else {
                grid[position.x][position.y] = false;
            }
            position = newPosition;
            return true;
        }
    }

    public boolean moveBy(Coordinate move) {
        Coordinate newPosition = new Coordinate(position.x + move.x, position.y + move.y);

        return moveTo(newPosition, true);
    }

    public boolean revertMoveBy(Coordinate move) {
        Coordinate newPosition = new Coordinate(position.x - move.x, position.y - move.y);

        return moveTo(newPosition, false);
    }

    public boolean isInLowerRightCorner() {
        return (position.x == size - 1) && (position.y == size - 1);
    }

    private boolean isVisited(Coordinate pos) {
        return grid[pos.x][pos.y];
    }

    private boolean isInGrid(Coordinate pos) {
        return isInRange(pos.x, 0, size - 1) && isInRange(pos.y, 0, size - 1);
    }

    private boolean isInRange(int in, int low, int high) {
        return (in >= low) && (in <= high);
    }
}
