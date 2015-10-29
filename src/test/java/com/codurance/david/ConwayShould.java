package com.codurance.david;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConwayShould {
    @Mock
    BoardEvolver mockBoardEvolver;

    @Mock
    BoardParser mockBoardParser;

    @Mock
    BoardPrinter mockBoardPrinter;

    Board resultBoard = new Board();
    Board parsedBoard = new Board();
    String input =
            ".....**....\n" +
            "......*....";
    String output =
            ".....**....\n" +
            ".....**....";

    @Before
    public void configureMocks() {
        when(mockBoardEvolver.evolve(any())).thenReturn(resultBoard);
        when(mockBoardParser.parse(anyString())).thenReturn(parsedBoard);
        when(mockBoardPrinter.print(any())).thenReturn(output);
    }

    private String play() {
        return new Conway(mockBoardEvolver, mockBoardParser, mockBoardPrinter).play(input);
    }


    @Test
    public void passInputParameterToBoardParser() {
        play();
        verify(mockBoardParser).parse(input);
    }

    @Test
    public void callBoardEvolverWithParsedBoard() {
        play();
        verify(mockBoardEvolver).evolve(parsedBoard);
    }

    @Test
    public void callBoardPrinterWithResultBoard() {
        play();
        verify(mockBoardPrinter).print(resultBoard);
    }

    @Test
    public void returnPrinterResult(){
        assertEquals(output, play());
    }
}