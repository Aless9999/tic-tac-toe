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

import static macnonline.tic_tac_toe.components.Sign.O;
import static macnonline.tic_tac_toe.components.Sign.X;

/**
 * @author macnonline
 */
public class Game {
    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final DrawVerifier drawVerifier;

    public Game(final DataPrinter dataPrinter, final ComputerMove computerMove,
                final UserMove userMove, final WinnerVerifier winnerVerifier,
                final DrawVerifier drawVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.drawVerifier = drawVerifier;
    }

    public void play() {

        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMapping();
        final GameTable gameTable = new GameTable();

        if (new Random().nextBoolean()) {
            computerMove.makeMove(gameTable);
            dataPrinter.printGameMap(gameTable);

        }
        final Player[] players = {new Player(userMove, X), new Player(computerMove, O)};
        while (true) {

            for (Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameMap(gameTable);

                if (winnerVerifier.isWinner(gameTable, player)) {
                    System.out.println(player.getSign() + " WIN");
                    System.out.println("Game over");
                    return;
                }


                if (drawVerifier.isDraw(gameTable)) {
                    System.out.println(("Game is draw"));
                    System.out.println("Game over");
                    return;
                }

            }


        }
    }
}

