package com.codurance.david;

public class BoardPrinter {
    public String print(Board board) {
        String result = "";
        for (int row = 0; row < board.rowsCount(); row++) {
            for (int col = 0; col < board.columnsCount(); col++) {
                result += cellToChar(board.cellAt(row, col));
            }
            result += '\n';
        }
        return result;
    }

    private char cellToChar(Cell cell) {
        if (cell == Cell.live()) {
            return '*';
        } else {
            return '.';
        }
    }
}
