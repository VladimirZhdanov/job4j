package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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
        Cell[] steps = new Cell[0];
        int deltaX = 0;
        int deltaY = 0;
        for (int i = 0; i < )
        return new Cell[] {
                dest
        };
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
/*

    Cell[] steps = new Cell[size];
    int deltaX = ...
        int deltaY = ...;
        for (.... ) {
        steps[index] = ...
        }
        return steps;

        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x) {
        steps = new Cell[] {
        dest
        };
        }
        return steps;
        }*/
