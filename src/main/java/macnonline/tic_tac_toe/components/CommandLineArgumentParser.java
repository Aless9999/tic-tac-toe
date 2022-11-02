package macnonline.tic_tac_toe.components;

import macnonline.tic_tac_toe.components.console.ConsoleDataPrinter;
import macnonline.tic_tac_toe.model.PlayerType;

import static macnonline.tic_tac_toe.components.UserInterface.CONSOLE;
import static macnonline.tic_tac_toe.components.UserInterface.GUI;
import static macnonline.tic_tac_toe.model.PlayerType.COMPUTER;
import static macnonline.tic_tac_toe.model.PlayerType.USER;

public class CommandLineArgumentParser {
    ConsoleDataPrinter consoleDataPrinter = new ConsoleDataPrinter();

    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    public PlayerTypes parse() {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;
        UserInterface userInterface = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = macnonline.tic_tac_toe.model.PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = macnonline.tic_tac_toe.model.PlayerType.valueOf((arg.toUpperCase()));
                } else {
                    consoleDataPrinter.printErrorMessage("not supported " + arg);
                }
            } else if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                userInterface = UserInterface.valueOf(arg.toUpperCase());

            } else {
                consoleDataPrinter.printErrorMessage("not supported " + arg);
            }
        }
        if (userInterface == null) {
            userInterface = CONSOLE;
        }

        if (playerType1 == null) {
            return new PlayerTypes(USER, COMPUTER, userInterface);
        } else {
            return new PlayerTypes(playerType1, playerType2, userInterface);
        }
    }

    public static class PlayerTypes {
        private final PlayerType playerType1;
        private final PlayerType playerType2;
        private final UserInterface userInterface;

        public PlayerTypes(PlayerType playerType1, PlayerType playerType2, UserInterface userInterface) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
            this.userInterface = userInterface;
        }

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}

