package com.codurance.david;

public class BoardEvolver {


    public Board evolve(Board initialBoard) {
        Cell[][] newCells = new Cell[initialBoard.rowsCount()][initialBoard.columnsCount()];

        for (int row = 0; row < initialBoard.rowsCount(); row++) {
            for (int col = 0; col < initialBoard.columnsCount(); col++) {
                newCells[row][col] = evolveCellAt(initialBoard, row, col);
            }
        }

        return new Board(newCells);
    }

    private Cell evolveCellAt(Board initialBoard, int row, int col) {
        long liveNeighboursCount = getLiveNeighboursCount(initialBoard, row, col);
        return initialBoard.cellAt(row,col).evolve(liveNeighboursCount);
    }

    private long getLiveNeighboursCount(Board board, int row, int col) {
        return board.getNeighbours(row, col).filter(cell -> cell==Cell.live()).count();
    }

}
