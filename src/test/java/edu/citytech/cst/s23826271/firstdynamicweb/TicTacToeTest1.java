package edu.citytech.cst.s23826271.firstdynamicweb;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.TicTacToeBusinessObj;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GameStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicTacToeTest1 {

    @DisplayName("X: Find winner on line 1 in position (0, 1, 2)")
    @Test
    void T1() {
        final char [] moves = {'X','X','X','N','O','O','N','N','N'};
        GameStatus gameStatus = TicTacToeBusinessObj.isWinner(moves);
        char expected = 'X';
        char actual = gameStatus.getWhoWon();
        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("O: Find winner on line 1 in position (0, 1, 2)")
    @Test
    void T2() {
        final char [] moves = {'O','O','O','X','N','X','N','N','N'};
        GameStatus gameStatus = TicTacToeBusinessObj.isWinner(moves);
        char expected = 'O';
        char actual = gameStatus.getWhoWon();
        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("No winner was found on line 1 in position (0, 1, 2)")
    @Test
    void T3() {
        final char [] moves = {'O','N','O','X','N','X','N','N','N'};
        GameStatus gameStatus = TicTacToeBusinessObj.isWinner(moves);
        char expected =  ' ';
        char actual = gameStatus.getWhoWon();
        Assertions.assertEquals(expected, actual);
    }
}
