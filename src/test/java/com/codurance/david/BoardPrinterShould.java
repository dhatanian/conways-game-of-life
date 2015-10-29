package com.codurance.david;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardPrinterShould {
    @Test
    public void shouldPrintEmptyCellsAsDots() {
        assertPrintedBoardEquals(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty()
                }
        }, "..\n");
    }

    @Test
    public void shouldPrintLiveCellsAsStars() {
        assertPrintedBoardEquals(new Cell[][]{
                new Cell[]{
                        Cell.live(), Cell.live()
                }
        }, "**\n");
    }

    @Test
    public void shouldPrintOneRowPerLine() {
        assertPrintedBoardEquals(new Cell[][]{
                new Cell[]{
                        Cell.live(), Cell.live()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty()
                }
        }, "**\n..\n");
    }

    private void assertPrintedBoardEquals(Cell[][] cells, String expected) {
        String output = new BoardPrinter().print(new Board(cells));
        assertEquals(expected, output);
    }
}