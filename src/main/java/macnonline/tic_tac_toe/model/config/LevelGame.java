package macnonline.tic_tac_toe.model.config;

import macnonline.tic_tac_toe.components.ComputerMoveStrategy;
import macnonline.tic_tac_toe.components.strategy.*;

public enum LevelGame {
    LEVEL1(new ComputerMoveStrategy[]{
            new MoveCentreTable(),
            new RandomComputerMove()}),
    LEVEL2(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWin(),
            new MoveCentreTable(),
            new RandomComputerMove()}),

    LEVEL3(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWin(),
            new WinOnTheNextStepComputerMoveStrategy(),
            new MoveCentreTable(),
            new RandomComputerMove()});

    public ComputerMoveStrategy[] getStrategies() {
        return strategies.clone();
    }

    private final ComputerMoveStrategy[] strategies;

    LevelGame(ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }
}
