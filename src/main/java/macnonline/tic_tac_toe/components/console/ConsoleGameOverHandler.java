package macnonline.tic_tac_toe.components.console;

import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.GameOverHandler;

import java.util.Scanner;

public class ConsoleGameOverHandler implements GameOverHandler {
    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessagePrint("GAME OVER!");
        new Scanner(System.in).nextLine();
    }
}
