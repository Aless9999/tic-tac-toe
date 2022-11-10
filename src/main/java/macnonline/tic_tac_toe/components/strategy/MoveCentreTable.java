package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

public class MoveCentreTable implements ComputerMoveStrategy {
    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {
        final Cell cell = new Cell(1, 1);
        if (gameTable.isEmpty(cell)) {
            gameTable.setSign(cell, sign);
            return true;
        } else {
            return false;
        }
    }
}
