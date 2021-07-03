package edu.citytech.cst.s23826271.firstdynamicweb;

import edu.citytech.cst.s23826271.firstdynamicweb.businessObject.TicTacToeBusinessObj;
import edu.citytech.cst.s23826271.firstdynamicweb.model.GameStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicTacToeTest3 {

    @DisplayName("X: Find winner on line 3 in position (0, 1, 2)")
    @Test
    void T1() {
        final char[] moves = {'?', '?', 'X', '?', 'O', 'O', 'X', 'X', 'X'};
        GameStatus gameStatus = TicTacToeBusinessObj.isWinner(moves);
        char expected = 'X';
        char actual = gameStatus.getWhoWon();
        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("O: Find winner on line 3 in position (0, 1, 2)")
    @Test
    void T2() {
        final char[] moves = {'?', 'O', 'X', 'X', '?', 'X', 'O', 'O', 'O'};
        GameStatus gameStatus = TicTacToeBusinessObj.isWinner(moves);
        char expected = 'O';
        char actual = gameStatus.getWhoWon();
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("No winner was found on line 3 in position (0, 1, 2)")
    @Test
    void T3() {
        final char [] moves = {'O','?','O','X','?','X','?','?','?'};
        GameStatus gameStatus = TicTacToeBusinessObj.isWinner(moves);
        char expected =  ' ';
        char actual = gameStatus.getWhoWon();
        Assertions.assertEquals(expected, actual);
    }

}
