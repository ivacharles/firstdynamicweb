(function() {


    function isWinner(moves) {
        let allMoves = moves.replaceAll("?", "N");
        let url = "/tictactoe/"+allMoves;
        $.getJSON(url);
        console.log({moves, date: new Date()});

        return {whoWon: "?" } ;
    }

    // creating a name space in javascript
    window.cst4713 = window.cst4713 || {};
    window.cst4713.isWinner4Server = isWinner;

}) ();