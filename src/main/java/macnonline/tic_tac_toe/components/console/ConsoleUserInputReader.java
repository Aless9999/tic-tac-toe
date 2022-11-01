package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.CellNumberConverter;
import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.UserInputReader;
import macnonline.tic_tac_toe.components.UserMove;
import macnonline.tic_tac_toe.model.Cell;

public class ConsoleUserInputReader implements UserInputReader {
    private final CellNumberConverter cellNumberConverter;

    public ConsoleUserInputReader(DataPrinter dataPrinter, CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public Cell getUserInput() {
        return userInput();
    }

    public Cell userInput() {
        return cellNumberConverter.toCell(UserMove.getIndex());


    }
}

