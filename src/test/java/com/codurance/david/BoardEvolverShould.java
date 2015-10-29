package com.codurance.david;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardEvolverShould {
    private BoardEvolver boardEvolver = new BoardEvolver();

    @Test
    public void returnABoardWithSameDimensionsAsOriginalBoard() throws Exception {
        Board evolvedBoard = evolveFrom(new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                }
        }));

        assertEquals(evolvedBoard.rowsCount(), 3);
        assertEquals(evolvedBoard.columnsCount(), 3);
    }

    @Test
    public void killAnyLiveCellWithNoLiveNeighbour() throws Exception {
        Board evolvedBoard = evolveFrom(new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                }
        }));

        assertEquals(Cell.empty(), evolvedBoard.cellAt(1, 1));
    }

    @Test
    public void killAnyLiveCellWithOneLiveNeighbours() throws Exception {
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.empty(), evolvedBoard.cellAt(1, 1));
    }

    @Test
    public void keepEmptyAnyEmptyCellWithNoLiveNeighbour(){
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.empty(), evolvedBoard.cellAt(1, 1));
    }

    @Test
    public void keepEmptyAnyEmptyCellWithOneLiveNeighbour(){
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.empty()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.empty(), evolvedBoard.cellAt(1, 1));
    }

    @Test
    public void keepEmptyAnyEmptyCellWithTwoLiveNeighbours(){
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.live()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.empty(), evolvedBoard.cellAt(1, 1));
    }

    @Test
    public void createALiveCellIfAnEmptyCellHasThreeLiveNeighbours() throws Exception {
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.empty(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.live(), Cell.empty(), Cell.live()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.live(), evolvedBoard.cellAt(2, 1));
    }

    @Test
    public void killACellWithFourLiveNeighbours() {
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.live()
                },
                new Cell[]{
                        Cell.live(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.live(), Cell.empty(), Cell.live()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.empty(), evolvedBoard.cellAt(1, 1));
    }

    @Test
    public void maintainALiveCellWithTwoLiveNeighbours() throws Exception {
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.live(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.live(), Cell.live(), Cell.empty()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.live(), evolvedBoard.cellAt(2, 1));
    }

    @Test
    public void maintainALiveCellWithThreeLiveNeighbours() throws Exception {
        Board initialBoard = new Board(new Cell[][]{
                new Cell[]{
                        Cell.empty(), Cell.empty(), Cell.empty()
                },
                new Cell[]{
                        Cell.live(), Cell.live(), Cell.empty()
                },
                new Cell[]{
                        Cell.live(), Cell.live(), Cell.empty()
                }
        });

        Board evolvedBoard = evolveFrom(initialBoard);

        assertEquals(Cell.live(), evolvedBoard.cellAt(2, 1));
    }

    private Board evolveFrom(Board initialBoard) {
        return boardEvolver.evolve(initialBoard);
    }
}