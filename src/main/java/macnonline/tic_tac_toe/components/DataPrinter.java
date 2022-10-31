package macnonline.tic_tac_toe.components;

import macnonline.tic_tac_toe.model.GameTable;

public interface DataPrinter {
    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void printMapping();

    void printGameMap(final GameTable gameTable);
}
