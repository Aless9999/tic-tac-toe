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

package macnonline.java.tic_tac_toe;

import java.util.Random;

/**
 * @author macnonline
 */
public class Game {
    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final DrowVerifier drowVerifier;

    public Game(final DataPrinter dataPrinter, final ComputerMove computerMove,
                final UserMove userMove, final WinnerVerifier winnerVerifier,
                final DrowVerifier drowVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.drowVerifier = drowVerifier;
    }

    public void play() {

        System.out.println("Start game");
        dataPrinter.printMapping();
        if (new Random().nextBoolean()) {
            computerMove.makeMove();
            dataPrinter.printGameMap();

        }
        while (true) {
            userMove.makeMove();
            dataPrinter.printGameMap();
            if (winnerVerifier.isWin()) {
                System.out.println("User is win");
                break;
            } else if (drowVerifier.isDrow()) {
                System.out.println(("Game is drow"));
                break;
            }


        }
    }
}
