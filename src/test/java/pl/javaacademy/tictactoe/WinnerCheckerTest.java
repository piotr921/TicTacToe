package pl.javaacademy.tictactoe;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WinnerCheckerTest {

    private WinnerChecker checker;
    private Board board;

    @BeforeMethod()
    public void before() {
        checker = new WinnerChecker();
    }

    @BeforeGroups(groups = "4x6 board")
    public void before4x6Group() {
        board = new Board(new BoardSize(4, 6));
    }

    // region 3x3 board tests
    @Test(groups = "3x3 board")
    public void shouldFindNoWinnerForEmptyBoard() {

        // Given
        board = new Board(new BoardSize(3, 3));

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.NO_WINNER);
    }

    @Test(groups = "3x3 board")
    public void shouldFindWinnerInFirstRow() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Marks.X);
        board.updateBoard(2, Marks.X);
        board.updateBoard(3, Marks.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3 board")
    public void shouldFindWinnerInFirstColumn() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Marks.X);
        board.updateBoard(4, Marks.X);
        board.updateBoard(7, Marks.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3 board")
    public void shouldFindWinnerInSecondRow() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Marks.X);
        board.updateBoard(2, Marks.O);
        board.updateBoard(3, Marks.O);
        board.updateBoard(4, Marks.X);
        board.updateBoard(5, Marks.X);
        board.updateBoard(6, Marks.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3 board")
    public void shouldFindWinnerInSecondColumn() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Marks.X);
        board.updateBoard(4, Marks.O);
        board.updateBoard(7, Marks.O);
        board.updateBoard(2, Marks.X);
        board.updateBoard(5, Marks.X);
        board.updateBoard(8, Marks.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3 board")
    public void shouldFindWinnerWithEmptyFieldsOnBoard() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(7, Marks.O);
        board.updateBoard(8, Marks.O);
        board.updateBoard(9, Marks.O);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.O_WIN);
    }

    @Test(groups = "3x3 board")
    public void shouldFindColumnWinnerWithEmptyFieldsOnBoard() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(3, Marks.O);
        board.updateBoard(6, Marks.O);
        board.updateBoard(9, Marks.O);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.O_WIN);
    }

    @Test(groups = "3x3 board")
    public void shouldFindNoWinnerInFilledBoard() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Marks.O);
        board.updateBoard(2, Marks.X);
        board.updateBoard(3, Marks.X);
        board.updateBoard(4, Marks.X);
        board.updateBoard(5, Marks.O);
        board.updateBoard(6, Marks.O);
        board.updateBoard(7, Marks.O);
        board.updateBoard(8, Marks.O);
        board.updateBoard(9, Marks.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.NO_WINNER);
    }
    // endregion
}
