"use strict";

(function () {

    let isX = true;
    let isWinner = false;


    const highLightWinner = function (winner){
        for (let i=0; i<winner.length; i++) {
            let div = $(".small-box")[winner[i]];
            $(div).addClass("winner");
        }
    }

    $(".small-box").click(  function() {
        let m = $("#message").text("");

        let value = $(this).text();
        if (value !== "?" || isWinner){
            let message = "Invalid move!";
            m.text(message);
            return;
        }

        let xOrO = isX ? "X" : "O";
        $(this).text(xOrO);
        isX = !isX;

        let moves = $(".small-box").text();

        let whichFunction = window.cst4713.isWinner || window.cst4713.isWinner4Server;
        //check for winner and who is the winner

        let winner = whichFunction(moves);
        let winnerArray = Object.values(winner);

        if(winnerArray.length > 2) {
            highLightWinner(winner);
            isWinner = true;
            m.text(winner.whoWon + " is the Winner");
        }
    });

    $("#btn-clear").click( () => {
        $(".small-box").text("?");
        $("#message").text("");
        isWinner = false;
        $(".small-box").removeClass("winner");
    });

})();