package macnonline.tic_tac_toe.components;

import macnonline.tic_tac_toe.model.PlayerType;

import static macnonline.tic_tac_toe.model.PlayerType.COMPUTER;
import static macnonline.tic_tac_toe.model.PlayerType.USER;

public class CommandLineArgumentParser {

    private final String[] args;

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
    }

    public PlayerTypes parse() {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;

        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = macnonline.tic_tac_toe.model.PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = macnonline.tic_tac_toe.model.PlayerType.valueOf((arg.toUpperCase()));
                } else {
                    System.err.println("not supported " + arg);
                }
            } else {
                System.err.println("not supported " + arg);
            }
        }
        if (playerType1 == null) {
            return new PlayerTypes(USER, COMPUTER);
        } else {
            return new PlayerTypes(playerType1, playerType2);
        }
    }

    public static class PlayerTypes {
        private final PlayerType playerType1;
        private final PlayerType playerType2;


        private PlayerTypes(final PlayerType playerType1, final PlayerType playerType2) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }
    }
}

