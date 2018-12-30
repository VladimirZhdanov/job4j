package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if (this.impossibilityToMove(source, dest)) {
            throw new ImpossibleMoveException("Impossible movement!");
        }
        steps = new Cell[] {
                dest
        };
        return steps;
    }

    private boolean impossibilityToMove(Cell source, Cell dest) {
        boolean rst = false;
        if (!(source.y == dest.y + 1 && source.x == dest.x)) {
            rst = true;
        }
        return rst;
    }
    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}