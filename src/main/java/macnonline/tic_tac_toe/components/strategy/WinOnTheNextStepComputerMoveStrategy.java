package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

import java.util.Random;

public class WinOnTheNextStepComputerMoveStrategy implements ComputerMoveStrategy {
    @Override
    public final boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveByRows(gameTable, sign) ||
                tryToMakeMoveByCols(gameTable, sign);
    }

    private boolean tryToMakeMoveByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveByConvert(gameTable, sign, (w, j) -> new Cell(w, j), i)) {
                return true;
            }

        }
        return false;
    }

    private boolean tryToMakeMoveByCols(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveByConvert(gameTable, sign, (w, j) -> new Cell(j, w), i)) {
                return true;
            }
        }
        return false;
    }

    @FunctionalInterface
    private interface Lambda {
        Cell getValue(int w, int j);
    }

    private boolean tryToMakeMoveByConvert(final GameTable gameTable, final Sign sign,
                                           final Lambda lambda, final int i) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        int k = 0;
        Cell[] lastEmptyCell = new Cell[3];
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.getValue(i, j);
            if (gameTable.isEmpty(cell)) {
                lastEmptyCell[k++] = cell;
                countEmptyCells++;
            } else if (gameTable.getSign(cell) == sign) {
                countSignCells++;
            } else {
                break;
            }
        }
        if (countEmptyCells == 2 && countSignCells == 1) {
            gameTable.setSign(lastEmptyCell[new Random().nextInt(3)], sign);
            return true;
        }
        return false;
    }

}
