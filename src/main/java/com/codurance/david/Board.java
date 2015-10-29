package com.codurance.david;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Board {
    private Cell[][] cells;

    public Board() {

    }

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return Arrays.deepEquals(cells, board.cells);

    }

    @Override
    public int hashCode() {
        return cells != null ? Arrays.deepHashCode(cells) : 0;
    }

    public int rowsCount() {
        return cells.length;
    }

    public int columnsCount() {
        return cells[0].length;
    }

    public Cell cellAt(int row, int col) {
        return cells[row][col];
    }

    public Stream<Cell> getNeighbours(int row, int col) {
        List<Cell> resultBuilder = new ArrayList<>();

        int topRowIndex = Math.max(0, row - 1);
        int bottomRowIndex = Math.min(row + 1, rowsCount() - 1);
        int rightMostColumnIndex = Math.min(col + 1, columnsCount() - 1);
        int leftMostColumnIndex = Math.max(0, col - 1);

        for (int neighbourRow = topRowIndex;
             neighbourRow <= bottomRowIndex;
             neighbourRow++) {
            for (int neighbourCol = leftMostColumnIndex;
                 neighbourCol <= rightMostColumnIndex;
                 neighbourCol++) {
                if (neighbourCol != col || neighbourRow != row) {
                    resultBuilder.add(cellAt(neighbourRow, neighbourCol));
                }
            }
        }

        return resultBuilder.stream();
    }
}
