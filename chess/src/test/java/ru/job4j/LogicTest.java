package ru.job4j;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import org.junit.Test;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenTryToMoveEmptyCellThenFalseIsReturned()
    {
        Logic logic = new Logic();
        assertEquals(false, logic.move(Cell.C8, Cell.D7));
    }

    @Test
    public void whenMoveSingleBishopOnDiagonalThenTrueIsReturned(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        assertEquals(true, logic.move(Cell.C8, Cell.D7));
    }

    @Test
    public void whenMoveAbsentFigureThenFalseIsReturned(){
        Logic logic = new Logic();
        assertEquals(false, logic.move(Cell.C8, Cell.D7));
    }

    @Test
    public void whenMoveBishopOnDiagonalToFilledCellThenFalseIsReturned(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new BishopBlack(Cell.D7));
        assertEquals(false, logic.move(Cell.C8, Cell.D7));
    }

    @Test
    public void whenMoveBishopOnDiagonalThroughFilledCellThenFalseIsReturned(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new BishopBlack(Cell.D7));
        assertEquals(false, logic.move(Cell.C8, Cell.E6));
    }
}
