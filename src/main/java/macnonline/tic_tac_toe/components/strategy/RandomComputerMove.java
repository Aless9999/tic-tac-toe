package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

import java.util.Random;

public class RandomComputerMove implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {
        final Cell[] arraySign = new Cell[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Cell cell = new Cell(i, j);
                if (gameTable.isEmpty(cell)) {
                    arraySign[count++] = cell;
                }

            }

        }
        if (count > 0) {
            final Cell randomCell = arraySign[new Random().nextInt(count)];
            gameTable.setSign(randomCell, sign);
            return true;
        } else {
            throw new IllegalArgumentException("Game table does not contain any empty cell!");
        }
    }
}

