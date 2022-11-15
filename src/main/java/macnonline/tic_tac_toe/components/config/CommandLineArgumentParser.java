/*
 * Copyright {2022} {macnonline}
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package macnonline.tic_tac_toe.components.config;

import macnonline.tic_tac_toe.components.console.ConsoleDataPrinter;
import macnonline.tic_tac_toe.model.config.LevelGame;
import macnonline.tic_tac_toe.model.config.PlayerType;
import macnonline.tic_tac_toe.model.config.UserInterface;

import static macnonline.tic_tac_toe.model.config.LevelGame.*;
import static macnonline.tic_tac_toe.model.config.PlayerType.COMPUTER;
import static macnonline.tic_tac_toe.model.config.PlayerType.USER;
import static macnonline.tic_tac_toe.model.config.UserInterface.CONSOLE;
import static macnonline.tic_tac_toe.model.config.UserInterface.GUI;

public class CommandLineArgumentParser {
    ConsoleDataPrinter consoleDataPrinter = new ConsoleDataPrinter();

    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    public PlayerTypes parse() {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;
        UserInterface userInterface = null;
        LevelGame levelGame = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf((arg.toUpperCase()));
                } else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because player types already set: player1Type='%s', player2Type='%s'!%n",
                            arg, playerType1, playerType2
                    );
                }
            } else if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                userInterface = UserInterface.valueOf(arg.toUpperCase());

            } else if (LEVEL1.name().equalsIgnoreCase(arg) || LEVEL2.name().equalsIgnoreCase(arg)
                    || LEVEL3.name().equalsIgnoreCase(arg)) {
                levelGame = LevelGame.valueOf(arg.toUpperCase());

            } else {
                System.err.printf(
                        "Invalid command line argument: '%s', because user interface already set: '%s'!%n",
                        arg, userInterface
                );
            }
        }
        if (levelGame == null) {
            levelGame = LEVEL3;
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }

        if (playerType1 == null) {
            return new PlayerTypes(USER, COMPUTER, userInterface, levelGame);
        } else {
            return new PlayerTypes(playerType1, playerType2, userInterface, levelGame);
        }
    }

    public static class PlayerTypes {
        private final PlayerType playerType1;
        private final PlayerType playerType2;
        private final UserInterface userInterface;

        private final LevelGame levelGame;

        public PlayerTypes(PlayerType playerType1, PlayerType playerType2, UserInterface userInterface, LevelGame levelGame) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
            this.userInterface = userInterface;
            this.levelGame = levelGame;
        }

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }

        public LevelGame getLevelGame() {
            return levelGame;
        }
    }
}


