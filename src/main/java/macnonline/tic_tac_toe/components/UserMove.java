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

import java.util.Scanner;

/**
 * @author macnonline
 */
public class UserMove implements Move {
    static int index;

    public static int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    private final DataPrinter dataPrinter;

    private final UserInputReader userInputReader;

    public UserMove(DataPrinter dataPrinter, UserInputReader userInputReader) {
        this.dataPrinter = dataPrinter;
        this.userInputReader = userInputReader;
    }

    @Override
    public void makeMove(final GameTable gameTable, final Sign sign) {

        while (true) {


            dataPrinter.printInfoMessagePrintln("Your move");
            index = new Scanner(System.in).nextInt();
            if (index < 0 || index > 9) {
                continue;
            }
            setIndex(index);
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










