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

import macnonline.tic_tac_toe.model.Cell;
import macnonline.tic_tac_toe.model.GameTable;

/**
 * @author macnonline
 */
public class WinnerVerifier {
    public boolean isUserWin(final GameTable gameTable) {
        return isWinnerByRow(gameTable, Sign.X) ||
                isWinnerByCol(gameTable, Sign.X) ||
                isWinnerByDiagonalRight(gameTable, Sign.X) ||
                isWinnerByDiagonalLeft(gameTable, Sign.X);


    }

    public boolean isComputerWin(final GameTable gameTable) {
        return isWinnerByRow(gameTable, Sign.O) ||
                isWinnerByCol(gameTable, Sign.O) ||
                isWinnerByDiagonalRight(gameTable, Sign.O) ||
                isWinnerByDiagonalLeft(gameTable, Sign.O);
    }


    private boolean isWinnerByDiagonalLeft(final GameTable gameTable, final Sign sign) {
        if (gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(2, 2)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == sign) {
            return true;
        }


        return false;
    }

    private boolean isWinnerByDiagonalRight(final GameTable gameTable, final Sign sign) {

        if (gameTable.getSign(new Cell(2, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == sign) {
            return true;
        }


        return false;
    }

    private boolean isWinnerByCol(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(1, i)) == sign) {
                return true;
            }

        }
        return false;
    }

    private boolean isWinnerByRow(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 1)) == sign) {
                return true;
            }

        }
        return false;
    }


}

