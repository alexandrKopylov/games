package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {

    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

       if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }


        int size = Math.abs(dest.x -source.x);
        Cell[] steps = new Cell[size];

        int deltaX = (dest.x-source.x)>0 ? 1 : -1;
        int deltaY = (dest.y-source.y)>0 ? 1 :-1;


        int cellX =source.x;
        int cellY =source.y;
        for (int index = 0; index < size; index++) {
            cellX += deltaX;
            cellY += deltaY;
            steps[index] = Cell.findBy(cellX, cellY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = (dest.x-source.x)>0 ? 1 : -1;
        int deltaY = (dest.y-source.y)>0 ? 1 :-1;
        int size = Math.abs(dest.x -source.x);
        if(dest.x == source.x+size*deltaX && dest.y == source.y+size*deltaY)
             return true;
        else return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
