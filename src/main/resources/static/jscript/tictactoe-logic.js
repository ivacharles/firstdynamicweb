(function() {

    const winningMoves = [
        {p1: 0, p2: 1, p3: 2},
        {p1: 3, p2: 4, p3: 5},
        {p1: 6, p2: 7, p3: 8},

        {p1: 0, p2: 3, p3: 6},
        {p1: 1, p2: 4, p3: 7},
        {p1: 2, p2: 5, p3: 8},

        {p1: 0, p2: 4, p3: 8},
        {p1: 2, p2: 4, p3: 6},
    ];

    function isWinner(moves) {
        const wc = winningMoves.find(e => {
            let status =  moves[ e.p1 ] === moves[e.p2]
                && moves[ e.p2 ] === moves[e.p3]
                && moves[ e.p2 ] !== "?" ;


            return status;
        });

        if(wc){
            wc.whoWon = moves[wc.p1]
        }

        return wc || {whoWon: "no one"} ;
    }

    // creating a name space in javascript
    window.cst4713 = window.cst4713 || {};
    window.cst4713.isWinner = isWinner;

}) ();