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

package macnonline.java.tic_tac_toe.components;

import macnonline.java.tic_tac_toe.model.Cell;
import macnonline.java.tic_tac_toe.model.GameTable;

import java.util.Scanner;

/**
 * @author macnonline
 */
public class UserMove {
    private final CellNumberConverter cellNumberConverter;

    public UserMove(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    public void makeMove(final GameTable gameTable) {

        while (true) {
            System.out.println("Your move");
            int index = new Scanner(System.in).nextInt();
            if (index < 0 || index > 9) {
                continue;
            }
            Cell cell = getIndexNumber(index);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, 'X');
                return;
            } else {
                System.out.println("Cell is not Empty");
            }
        }
    }

    private Cell getIndexNumber(final int index) {

        return cellNumberConverter.toCell(index);
    }

}


