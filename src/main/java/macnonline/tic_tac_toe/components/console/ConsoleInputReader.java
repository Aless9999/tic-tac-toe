package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.CellNumberConverter;
import macnonline.tic_tac_toe.components.UserInputReader;
import macnonline.tic_tac_toe.model.Cell;

public class ConsoleInputReader implements UserInputReader {
    CellNumberConverter cellNumberConverter;
    @Override
    public Cell getIndexNumber(int index) {
        return cellNumberConverter.toCell(index);
    }
}
