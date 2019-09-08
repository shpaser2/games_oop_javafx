package ru.job4j;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import org.junit.Test;
import static org.junit.Assert.*;

public class BishopBlackTest {

    /**
     * Test for position method.
     */
    @Test
    public void whenCreatedWithSelectedCellThisCellIsSavedWithFigure(){
        Cell cell = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertEquals(cell, bishopBlack.position());
    }

    /**
     * Test for copy method in BishopBlack.
     */
    @Test
    public void whenMoveFigureToNewCellReturnsNewFigureOnNewCell(){
        Cell cell = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(cell);
        Cell cellNew = Cell.B7;
        Figure bishopBlackNew = bishopBlack.copy(cellNew);
        assertEquals(cellNew, bishopBlackNew.position());
    }

    /**
     * Test for way method from BishopBlack.
     */
    @Test
    public void whenSetDirectionForWayArrayWithRightWayIsReturned(){
        Cell cellStart = Cell.C1;
        Cell cellEnd = Cell.G5;
        Cell[] wayExpected = {Cell.C1, Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack bishopBlack = new BishopBlack(cellStart);
        assertArrayEquals(wayExpected, bishopBlack.way(cellStart, cellEnd));
    }

    /**
     * For method isDiagonal.
     */
    @Test
    public void whenSourceAndDestinationCellsNotOnDiagonalReturnsFalse(){
        Cell source = Cell.C1;
        Cell dest = Cell.G4;
        BishopBlack bishopBlack = new BishopBlack(source);
        assertFalse(bishopBlack.isDiagonal(source, dest));
    }
}
