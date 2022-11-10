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

package macnonline.tic_tac_toe;

import macnonline.tic_tac_toe.components.*;
import macnonline.tic_tac_toe.components.config.CommandLineArgumentParser;
import macnonline.tic_tac_toe.components.console.CellNumberConverter;
import macnonline.tic_tac_toe.components.console.ConsoleDataPrinter;
import macnonline.tic_tac_toe.components.console.ConsoleGameOverHandler;
import macnonline.tic_tac_toe.components.console.ConsoleUserInputReader;
import macnonline.tic_tac_toe.components.console.keypad.DesktopNumericKeypadCellNumberConverter;
import macnonline.tic_tac_toe.components.strategy.MoveCentreTable;
import macnonline.tic_tac_toe.components.strategy.RandomComputerMove;
import macnonline.tic_tac_toe.components.swing.GameWindow;
import macnonline.tic_tac_toe.model.config.PlayerType;
import macnonline.tic_tac_toe.model.config.UserInterface;
import macnonline.tic_tac_toe.model.game.Player;

import static macnonline.tic_tac_toe.model.config.PlayerType.USER;
import static macnonline.tic_tac_toe.model.config.UserInterface.GUI;
import static macnonline.tic_tac_toe.model.game.Sign.O;
import static macnonline.tic_tac_toe.model.game.Sign.X;

public class GameFactory {
    private final UserInterface userInterface;
    private final PlayerType playerType1;
    private final PlayerType playerType2;

    public GameFactory(String[] args) {

        final CommandLineArgumentParser.PlayerTypes playerTypes =
                new CommandLineArgumentParser(args).parse();

        this.userInterface = playerTypes.getUserInterface();
        this.playerType1 = playerTypes.getPlayerType1();
        this.playerType2 = playerTypes.getPlayerType2();
    }

    public Game creat() {
        final ComputerMoveStrategy[] strategies= {
                new MoveCentreTable(),
                new RandomComputerMove()

        };
        final GameOverHandler gameOverHandler;
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;

        if(userInterface==GUI){
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;
        }else{
        final CellNumberConverter cellNumberConverter =
                new DesktopNumericKeypadCellNumberConverter();
        dataPrinter =
                new ConsoleDataPrinter(cellNumberConverter);
        userInputReader =
                new ConsoleUserInputReader(dataPrinter,cellNumberConverter);
        gameOverHandler = new ConsoleGameOverHandler(dataPrinter);

        }
        final Player player1;
        final Player player2;
        if (playerType1 == USER) {
            player1 = new Player(new UserMove(dataPrinter, userInputReader), X);
        } else {
            player1 = new Player(new ComputerMove(strategies), X);
        }
        if (playerType2 == USER) {
            player2 = new Player(new UserMove(dataPrinter, userInputReader), O);
        } else {
            player2 = new Player(new ComputerMove(strategies), O);
        }


        return new Game(
                gameOverHandler, dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new DrawVerifier()
        );
    }
}




