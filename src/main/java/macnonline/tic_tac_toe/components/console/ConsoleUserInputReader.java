package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.UserInputReader;
import macnonline.tic_tac_toe.model.game.Cell;

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

            dataPrinter.printInfoMessagePrintln("Please insert number our 1 to 9");
            index = new Scanner(System.in).nextInt();

            if (index <= 0 || index > 9) {


                continue;
            }
            return cellNumberConverter.toCell(index);
        }



    }
}

