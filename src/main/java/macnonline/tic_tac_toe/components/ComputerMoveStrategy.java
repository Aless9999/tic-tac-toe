package macnonline.tic_tac_toe.components;

import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

public interface ComputerMoveStrategy {
    boolean tryToMakeMove(GameTable gameTable, Sign sign);
}
