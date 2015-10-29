package com.codurance.david;

public class BoardParser {
    public Board parse(String input) {
        if (!input.endsWith("\n")) {
            input = input + "\n";
        }
        int rowLength = input.indexOf('\n');
        int rowCounts = input.length() / (rowLength + 1);
        Cell[][] cells = new Cell[rowCounts][rowLength];
        for (int row = 0; row < rowCounts; row++) {
            for (int column = 0; column < rowLength; column++) {
                cells[row][column] = charToCell(input.charAt(row * (rowLength + 1) + column));
            }
        }

        return new Board(cells);
    }

    private Cell charToCell(char c) {
        switch (c) {
            case '.':
                return Cell.empty();
            case '*':
                return Cell.live();
            default:
                throw new IllegalArgumentException("Unknown cell code : " + c);
        }
    }

}
