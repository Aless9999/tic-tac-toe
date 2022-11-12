package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

public class PreventUserWin implements ComputerMoveStrategy {
    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {

        return preventUserWinByRows(gameTable, sign) ||
                preventUserWinByCol(gameTable, sign) ||
                preventUserWinByDiagonalRight(gameTable, sign) ||
                preventUserWinByDiagonalLeft(gameTable, sign);
    }

    private boolean preventUserWinByDiagonalLeft(GameTable gameTable, Sign sign) {
        if (preventUserWin(gameTable, sign, -1, (i, j) -> new Cell(j, 2 - j))) {
            return true;
        }
        return false;
    }


    private boolean preventUserWinByDiagonalRight(GameTable gameTable, Sign sign) {
        if (preventUserWin(gameTable, sign, -1, (i, j) -> new Cell(j, j))) {
            return true;
        }
        return false;
    }

    private boolean preventUserWinByCol(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (preventUserWin(gameTable, sign, i, (k, j) -> new Cell(k, j))) {
                return true;
            }
        }
        return false;
    }

    private boolean preventUserWinByRows(GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (preventUserWin(gameTable, sign, i, (k, j) -> new Cell(j, k))) {
                return true;
            }
        }
        return false;
    }

    @FunctionalInterface
    private interface Lambda {
        Cell getValue(int k, int j);
    }

    private boolean preventUserWin(GameTable gameTable, Sign sign, int i, Lambda lambda) {

        int countCellEmpty = 0;
        int countCellSign = 0;
        Cell lostEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.getValue(i, j);
            if (gameTable.isEmpty(cell)) {
                countCellEmpty++;
                lostEmptyCell = cell;
            } else if (gameTable.getSign(cell) != sign) {
                countCellSign++;

            } else {
                break;
            }
        }
        if (countCellSign == 2 & countCellEmpty == 1) {
            gameTable.setSign(lostEmptyCell, sign);
            return true;
        }

        return false;

    }
}
