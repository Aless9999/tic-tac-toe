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
public class UserMove implements Move {

    private final DataPrinter dataPrinter;

    private final UserInputReader userInputReader;

    public UserMove(DataPrinter dataPrinter, UserInputReader userInputReader) {
        this.dataPrinter = dataPrinter;
        this.userInputReader = userInputReader;
    }

    @Override
    public void makeMove(final GameTable gameTable, final Sign sign) {

        while (true) {

            Cell cell = userInputReader.getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printErrorMessage("Cell is not Empty");
            }
        }
    }
}










