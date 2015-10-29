package com.codurance.david;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BoardParserShould {
    @Test
    public void convertDotsToEmptyCells() {
        assertParsedBoardEquals(".", new Cell[][]{new Cell[]{Cell.empty()}});
    }

    @Test
    public void createAsManyColumnsAsLineLength() {
        assertParsedBoardEquals("...", new Cell[][]{
                new Cell[]{Cell.empty(), Cell.empty(), Cell.empty()}});
    }

    @Test
    public void convertStarsToLiveCells() {
        assertParsedBoardEquals("*", new Cell[][]{new Cell[]{Cell.live()}});
    }

    @Test
    public void createAsManyRowsAsLines() {
        assertParsedBoardEquals(
                "...\n"
                        + "..."
                , new Cell[][]{
                        new Cell[]{Cell.empty(), Cell.empty(), Cell.empty()},
                        new Cell[]{Cell.empty(), Cell.empty(), Cell.empty()}
                });
    }

    private void assertParsedBoardEquals(String situation, Cell[][] cells) {
        assertThat(new BoardParser().parse(situation), equalTo(new Board(cells)));
    }

}