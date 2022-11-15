package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

public class PreventUserWin extends AbstractMoveComputerStrategy {
    boolean getFindSign(GameTable gameTable, Sign sign, Cell cell) {
        return (gameTable.getSign(cell) != sign);
    }
}

