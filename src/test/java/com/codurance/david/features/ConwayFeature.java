package com.codurance.david.features;

import com.codurance.david.BoardEvolver;
import com.codurance.david.BoardParser;
import com.codurance.david.BoardPrinter;
import com.codurance.david.Conway;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConwayFeature {
    @Test
    public void evolveToNewGeneration() {
        String initialSituation =
                "........\n" +
                "....*...\n" +
                "...**...\n" +
                "........\n";
        String finalSituation =
                "........\n" +
                "...**...\n" +
                "...**...\n" +
                "........\n";
        assertEquals(finalSituation, new Conway(new BoardEvolver(), new BoardParser(), new BoardPrinter()).play(initialSituation));
    }
}