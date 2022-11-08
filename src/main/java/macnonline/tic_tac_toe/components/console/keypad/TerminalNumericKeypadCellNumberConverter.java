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

package macnonline.tic_tac_toe.components.console.keypad;

import macnonline.tic_tac_toe.components.console.CellNumberConverter;
import macnonline.tic_tac_toe.model.game.Cell;

import static java.lang.String.format;

/**
 * @author macnonline
 */
public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    @Override
    public Cell toCell(final int index) {

        if (index >=1 && index < 9) {
            return new Cell((index - 1) / 3, (index - 1) % 3);
        } else {
            throw new IllegalArgumentException(format("Must be index our 0 to 2. Current index '%s'", index));
        }
    }


    @Override
    public char toNumber(final Cell cell) {
        if (cell.getCol() >= 0 && cell.getCol() <= 2 && cell.getRow() >= 0 && cell.getRow() <= 2) {
            return mapping[cell.getRow()][cell.getCol()];
        }else{
            throw new IllegalArgumentException(
                    format(
                            "Row and col indexes must be between 0 and 2! Current row is %s, current col is %s!",
                            cell.getRow(), cell.getCol()
                    ));
        }

    }
}
