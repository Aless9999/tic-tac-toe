package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

public abstract class AbstractMoveComputerStrategy implements ComputerMoveStrategy {
    @Override
    public final boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveByRows(gameTable, sign) ||
                tryToMakeMoveByCols(gameTable, sign) ||
                tryToMakeMoveByMainDiagonal(gameTable, sign) ||
                tryToMakeMoveBySecondaryDiagonal(gameTable, sign);
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

    private boolean tryToMakeMoveByMainDiagonal(final GameTable gameTable, final Sign sign) {
        if (tryToMakeMoveByConvert(gameTable, sign, (w, j) -> new Cell(j, j), -1)) {
            return true;
        }
        return false;
    }

    private boolean tryToMakeMoveBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        if (tryToMakeMoveByConvert(gameTable, sign, (w, j) -> new Cell(j, 2 - j), -1)) {
            return true;
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
        Cell lastEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.getValue(i, j);
            if (gameTable.isEmpty(cell)) {
                lastEmptyCell = cell;
                countEmptyCells++;
            } else if (getFindSign(gameTable, sign, cell)) {
                countSignCells++;
            } else {
                break;
            }
        }
        if (countEmptyCells == 1 && countSignCells == 2) {
            gameTable.setSign(lastEmptyCell, sign);
            return true;
        }
        return false;
    }

    abstract boolean getFindSign(GameTable gameTable, Sign sign, Cell cell);


}

