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

import macnonline.tic_tac_toe.keypad.DesktopNumericKeypadCellNumberConverter;
import macnonline.tic_tac_toe.model.PlayerType;

import static macnonline.tic_tac_toe.components.Sign.O;
import static macnonline.tic_tac_toe.components.Sign.X;
import static macnonline.tic_tac_toe.model.PlayerType.COMPUTER;
import static macnonline.tic_tac_toe.model.PlayerType.USER;

public class GameFactory {
    private final PlayerType playerType1;
    private final PlayerType playerType2;

    public GameFactory(String[] args) {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;

        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf((arg.toUpperCase()));
                } else {
                    System.err.println("not supported " + arg);
                }
            } else {
                System.err.println("not supported " + arg);
            }
        }
        this.playerType1 = playerType1;
        this.playerType2 = playerType2;


    }

    public Game creat() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        final Player player1;
        final Player player2;
        if (playerType1 == USER) {
            player1 = new Player(new UserMove(cellNumberConverter), X);
        } else {
            player1 = new Player(new ComputerMove(), X);
        }
        if (playerType2 == USER) {
            player2 = new Player(new UserMove(cellNumberConverter), O);
        } else {
            player2 = new Player(new ComputerMove(), O);
        }


        final Game game = new Game(
                new DataPrinter(cellNumberConverter),
                player1,
                player2,
                new WinnerVerifier(),
                new DrawVerifier()
        );
        return game;
    }
}



