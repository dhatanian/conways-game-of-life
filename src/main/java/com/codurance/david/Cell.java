package com.codurance.david;

public abstract class Cell {
    private static final Cell LIVE = new LiveCell();
    private static final Cell EMPTY = new EmptyCell();

    public static Cell live() {
        return LIVE;
    }

    public static Cell empty() {
        return EMPTY;
    }

    public abstract Cell evolve(long liveNeighboursCount);

    private static class LiveCell extends Cell {
        public static final int MAX_SURVIVABLE_LIVE_NEIGHBOURS = 3;
        public static final int MIN_SURVIVABLE_LIVE_NEIGHBOURS = 2;

        @Override
        public Cell evolve(long liveNeighboursCount) {
            if (liveNeighboursCount > MAX_SURVIVABLE_LIVE_NEIGHBOURS) {
                return Cell.empty();
            } else if (liveNeighboursCount >= MIN_SURVIVABLE_LIVE_NEIGHBOURS) {
                return Cell.live();
            }
            return Cell.empty();
        }
    }

    private static class EmptyCell extends Cell {
        public static final int LIVE_NEIGHBOURS_REQUIRED_FOR_REPRODUCTION = 3;

        @Override
        public Cell evolve(long liveNeighboursCount) {
            if (liveNeighboursCount == LIVE_NEIGHBOURS_REQUIRED_FOR_REPRODUCTION) {
                return Cell.live();
            }
            return Cell.empty();
        }
    }
}
