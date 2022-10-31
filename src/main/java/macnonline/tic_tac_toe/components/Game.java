/*
 * Copyright (c) 2022. http://macnonline
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package macnonline.tic_tac_toe.components;


import macnonline.tic_tac_toe.model.GameTable;

import java.util.Random;

/**
 * @author macnonline
 */
public class Game {
    private final DataPrinter dataPrinter;

    private final Player player1;
    private final Player player2;

    private final WinnerVerifier winnerVerifier;
    private final DrawVerifier drawVerifier;

    public Game(final DataPrinter dataPrinter, final Player player1, final Player player2,
                final WinnerVerifier winnerVerifier,
                final DrawVerifier drawVerifier) {
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.drawVerifier = drawVerifier;
    }

    public void play() {
        dataPrinter.printInfoMessagePrintln("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMapping();
        final GameTable gameTable = new GameTable();

        if (new Random().nextBoolean()) {
            player2.makeMove(gameTable, player2.getSign());
            dataPrinter.printGameMap(gameTable);

        }
        final Player[] players = {player1, player2};
        while (true) {

            for (Player player : players) {
                player.makeMove(gameTable, player.getSign());
                dataPrinter.printGameMap(gameTable);

                if (winnerVerifier.isWinner(gameTable, player)) {
                    dataPrinter.printInfoMessagePrintln(player.getSign() + " WIN");
                    dataPrinter.printInfoMessagePrintln("Game over");
                    return;
                }


                if (drawVerifier.isDraw(gameTable)) {
                    dataPrinter.printInfoMessagePrintln(("Game is draw"));
                    dataPrinter.printInfoMessagePrintln("Game over");
                    return;
                }
            }
        }
    }
}

