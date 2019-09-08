package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.lang.Math;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
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
        if(!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        int size = Math.abs(dest.x - source.x) + 1;
        Cell[] steps = new Cell[size];
        int deltaX = dest.x >= source.x ? 1 : -1;
        int deltaY = dest.y >= source.y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] =  source.getCell(source.x + (int)deltaX*index,
                                        source.y + (int)deltaY*index);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if(Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)){
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
