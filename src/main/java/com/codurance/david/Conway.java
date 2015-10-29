package com.codurance.david;

public class Conway {

    private BoardEvolver boardEvolver;
    private BoardParser boardParser;
    private BoardPrinter boardPrinter;

    public Conway(BoardEvolver boardEvolver, BoardParser boardParser, BoardPrinter boardPrinter) {
        this.boardEvolver = boardEvolver;
        this.boardParser = boardParser;
        this.boardPrinter = boardPrinter;
    }

    public String play(String initialSituation) {
        Board initialBoard = boardParser.parse(initialSituation);
        Board resultBoard = boardEvolver.evolve(initialBoard);
        return boardPrinter.print(resultBoard);
    }
}