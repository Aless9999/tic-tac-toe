package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.CellNumberConverter;
import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.UserInputReader;
import macnonline.tic_tac_toe.model.Cell;

import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {
    private final CellNumberConverter cellNumberConverter;
    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(DataPrinter dataPrinter, CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        return userInput();
    }


    public Cell userInput() {
        int index;
        while (true) {


            index = new Scanner(System.in).nextInt();
            if (index < 0 || index > 9) {
                continue;
            }
            return cellNumberConverter.toCell(index);
        }



    }
}

