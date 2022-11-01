package macnonline.tic_tac_toe.components.swing;

import macnonline.tic_tac_toe.components.DataPrinter;
import macnonline.tic_tac_toe.components.UserInputReader;
import macnonline.tic_tac_toe.model.Cell;
import macnonline.tic_tac_toe.model.GameTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class GameWindow extends JFrame implements DataPrinter, UserInputReader {

    private static final int GAME_TABLE_SIZE = 3;

    private static final int FONT_SIZE = 35;

    private static final int CELL_SIZE = 150;

    private final JLabel[][] cells = new JLabel[GAME_TABLE_SIZE][GAME_TABLE_SIZE];

    private Cell clickedCell;

    public GameWindow() {
        super("Tic-tac-toe");
        setSystemLookAndFeel();
        setLayout(new GridLayout(GAME_TABLE_SIZE, GAME_TABLE_SIZE));
        createGameTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        displayInTheMiddleOfTheScreen();
    }

    private void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | UnsupportedLookAndFeelException |
                       IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private void createGameTable() {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                final JLabel label = new JLabel();
                cells[i][j] = label;
                label.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setFont(new Font(Font.SERIF, Font.PLAIN, FONT_SIZE));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(label);
                final Cell cell = new Cell(i, j);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent unused) {
                        synchronized (GameWindow.this) {
                            clickedCell = cell;
                            GameWindow.this.notifyAll();
                        }
                    }
                });
            }
        }
    }

    private void displayInTheMiddleOfTheScreen() {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setVisible(true);
    }

    @Override
    public void printInfoMessagePrintln(final String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void printInfoMessagePrint(String message) {

    }

    @Override
    public void printErrorMessage(final String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void printMapping() {
        // do nothing
    }

    @Override
    public void printGameMap(final GameTable gameTable) {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                cells[i][j].setText(String.valueOf(gameTable.getSign(new Cell(i, j))));
            }
        }
    }

    @Override
    public Cell getUserInput() {
        synchronized (this) {
            try {
                wait();
            } catch (final InterruptedException exception) {
                exception.printStackTrace();
                System.exit(2);
            }
        }
        return clickedCell;
    }
}
