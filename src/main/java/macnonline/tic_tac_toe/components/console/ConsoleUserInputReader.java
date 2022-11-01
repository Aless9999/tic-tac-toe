package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.CellNumberConverter;
import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.Sign;
import macnonline.tic_tac_toe.components.UserInputReader;
import macnonline.tic_tac_toe.model.Cell;
import macnonline.tic_tac_toe.model.GameTable;

import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {
    final private DataPrinter dataPrinter;
    final private CellNumberConverter cellNumberConverter;

    public ConsoleUserInputReader(DataPrinter dataPrinter, CellNumberConverter cellNumberConverter) {
        this.dataPrinter = dataPrinter;
        this.cellNumberConverter = cellNumberConverter;
    }
    @Override
    public void inputUser(GameTable gameTable, Sign sign) {
        while (true) {
            dataPrinter.printInfoMessagePrintln("Your move");
            int index = new Scanner(System.in).nextInt();
            if (index < 0 || index > 9) {
                continue;
            }
            Cell cell = getIndexNumber(index);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printErrorMessage("Cell is not Empty");
            }
        }
    }


    public Cell getIndexNumber(int index) {
        return cellNumberConverter.toCell(index);
    }
}
