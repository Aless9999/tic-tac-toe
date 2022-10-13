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

package macnonline.java.tic_tac_toe.keypad;

import macnonline.java.tic_tac_toe.components.CellNumberConverter;
import macnonline.java.tic_tac_toe.model.Cell;

/**
 * @author macnonline
 */
public class DesktopNumericKeypadCellNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    @Override
    public Cell toCell(final int index) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == Integer.toString(index).charAt(0)) {

                    return new Cell(i, j);
                }

            }

        }
        return null;
    }


    @Override
    public char toNumber(final Cell cell) {
        return mapping[cell.getRow()][cell.getCol()];
    }
}
