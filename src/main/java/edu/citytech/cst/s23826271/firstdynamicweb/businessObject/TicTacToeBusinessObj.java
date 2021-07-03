package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;

import edu.citytech.cst.s23826271.firstdynamicweb.model.GameStatus;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class TicTacToeBusinessObj {

    private static final int [][] winningMoves = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    public static final char PLACE_HOLDER = 'N';


    public static GameStatus isWinner(char [] moves){

        Predicate<GameStatus> predicate = e -> moves[e.getP1()] ==  moves[e.getP2()]
                                           &&  moves[e.getP2()] ==  moves[e.getP3()]
                                           &&  moves[e.getP2()] != PLACE_HOLDER;

        Optional<GameStatus> gs = Arrays.stream(winningMoves)
                              .map(GameStatus::new)
                              //.peek(System.out::println)
                              .filter(predicate) //return true or false
                              .findFirst();

        if(gs.isPresent()){ //if no row is return, no winner was found
            GameStatus status = gs.get(); //get the object from optional gs so you can modify its props.
            status.setWhoWon(moves[status.getP1()]);  //set the whoWon property
            return status;
        }

        return new GameStatus();
    }
}
