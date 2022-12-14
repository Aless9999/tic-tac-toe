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

import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

import java.util.Random;

/**
 * @author macnonline
 */
public class ComputerMove implements Move {

    private final ComputerMoveStrategy[] strategies;

    public ComputerMove(ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    @Override
    public void makeMove(final GameTable gameTable, final Sign sign) {
        for(ComputerMoveStrategy strateg : strategies){
            if(strateg.tryToMakeMove(gameTable,sign)){
                return;
            }
        }throw new IllegalArgumentException("Game table does not contain empty cells or invalid configuration for the computer move strategies!");
    }

}





