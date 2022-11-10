package macnonline.tic_tac_toe.components.strategy;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.model.game.Cell;
import macnonline.tic_tac_toe.model.game.GameTable;
import macnonline.tic_tac_toe.model.game.Sign;

public class WinNowComputerMoveStrategy implements ComputerMoveStrategy {
    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {

        return isMoveByDiagonalLeft(gameTable, sign) ||
                isMoveByDiagonalRight(gameTable, sign) ||
                isMoveByCol(gameTable, sign) ||
                isMoveByRow(gameTable, sign);
    }


    private boolean isMoveByRow(GameTable gameTable, Sign sign) {

        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == sign) {
                if (gameTable.isEmpty(new Cell(2, i))) {
                    gameTable.setSign(new Cell(2, i), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(0, i)) == sign) {
                if (gameTable.isEmpty(new Cell(1, i))) {
                    gameTable.setSign(new Cell(1, i), sign);
                    return true;

                }
            } else if (gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(1, i)) == sign) {
                if (gameTable.isEmpty(new Cell(0, i))) {
                    gameTable.setSign(new Cell(0, i), sign);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMoveByCol(GameTable gameTable, Sign sign) {

        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1))
                    && gameTable.getSign(new Cell(i, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(i, 2))) {
                    gameTable.setSign(new Cell(i, 2), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2))
                    && gameTable.getSign(new Cell(i, 1)) == sign) {
                if (gameTable.isEmpty(new Cell(i, 0))) {
                    gameTable.setSign(new Cell(i, 0), sign);
                    return true;
                }
            } else if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 2))
                    && gameTable.getSign(new Cell(i, 0)) == sign) {
                if (gameTable.isEmpty(new Cell(i, 1))) {
                    gameTable.setSign(new Cell(i, 1), sign);

                    return true;

                }
            }
        }
        return false;
    }

    private boolean isMoveByDiagonalRight(GameTable gameTable, Sign sign) {
        if (gameTable.getSign(new Cell(2, 0)) == gameTable.getSign(new Cell(1, 1))) {
            if (gameTable.isEmpty(new Cell(0, 2))) {
                gameTable.setSign(new Cell(0, 2), sign);
                return true;
            } else if (gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1))) {
                if (gameTable.isEmpty(new Cell(2, 0))) {
                    gameTable.setSign(new Cell(2, 0), sign);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMoveByDiagonalLeft(GameTable gameTable, Sign sign) {
        if (gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1))) {
            if (gameTable.isEmpty(new Cell(2, 2))) {
                gameTable.setSign(new Cell(2, 2), sign);
                return true;
            }
        } else if (gameTable.getSign(new Cell(2, 2)) == gameTable.getSign(new Cell(1, 1))) {
            if (gameTable.isEmpty(new Cell(0, 0))) {
                gameTable.setSign(new Cell(0, 0), sign);
                return true;

            }

        }
        return false;
    }
}

