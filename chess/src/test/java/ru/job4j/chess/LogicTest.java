package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

  // @Ignore
    @Test
    public void moveBishop() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
       Cell[] path = bishop.way(Cell.C1, Cell.G5);

        assertThat(path, is(new Cell[] {Cell.D2,Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test (expected = IllegalStateException.class)
    public void wrongMoveBishop() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] path = bishop.way(Cell.C1, Cell.C5);

    }

    @Test
    public void position() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Cell rsl = bishop.position();
        assertThat(rsl, is(Cell.C1));
    }

    @Test
    public void copy() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Figure fig = bishop.copy(Cell.A5);
        Cell rsl = fig.position();
        assertThat(rsl, is(Cell.A5));
    }

    @Test
    public void moveLogicFigureRight() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C8);
        logic.add(bishop);
        boolean rsl = logic.move(Cell.C8, Cell.H3);

        assertThat(rsl, is(true));
    }

    @Test
    public void moveLogicFigureWrong() {
        Logic logic = new Logic();
        BishopBlack bishop = new BishopBlack(Cell.C8);
        logic.add(bishop);

        PawnBlack pawn = new PawnBlack(Cell.E6);
        logic.add( pawn);
        boolean rsl = logic.move(Cell.C8, Cell.H3);

        assertThat(rsl, is(false));
    }

}