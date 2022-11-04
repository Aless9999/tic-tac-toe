package macnonline.tic_tac_toe.components;

import macnonline.tic_tac_toe.model.GameTable;

public interface DataPrinter {
    void printInstruction();
    void printInfoMessagePrintln(String message);
    void printInfoMessagePrint(String message);

    void printErrorMessage(String message);


    void printGameMap(final GameTable gameTable);
}
