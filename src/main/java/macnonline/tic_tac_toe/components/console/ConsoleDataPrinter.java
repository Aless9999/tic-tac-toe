package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.CellNumberConverter;
import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.DataPrinterImpl;
import macnonline.tic_tac_toe.model.Cell;
import macnonline.tic_tac_toe.model.GameTable;

public class ConsoleDataPrinter implements DataPrinter {
    CellNumberConverter cellNumberConverter;
    @Override
    public void printInfoMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(String message) {
        System.err.println(message);
    }

    @Override
    public void printMapping() {
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    @Override
    public void printGameMap(GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }
    public void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");

            }
            System.out.println("|");

        }
        System.out.println("-------------");
    }
    @FunctionalInterface
    private interface Lambda {

        String getValue(int i, int j);
    }
}
