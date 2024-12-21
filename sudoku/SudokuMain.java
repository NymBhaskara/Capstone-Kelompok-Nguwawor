/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2024/2025
 * Group Capstone Project
 * Group "Nguwawor"
 * 1 - 5026231162 - I Nyoman Mahadyana Bhaskara
 * 2 - 5026231186 - Javed Amani Syauki
 */


package sudoku;

import java.awt.*;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L; // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");
    JButton btnToggleSound = new JButton("Mute Sound");

    boolean isSoundEnabled = true;

    // Constructor
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.add(btnNewGame);
        southPanel.add(btnToggleSound);
        cp.add(southPanel, BorderLayout.SOUTH);

        // Initialize the game board to start the game
        btnNewGame.addActionListener(e -> {
            board.newGame();
        });

        btnToggleSound.addActionListener(e -> toggleSound());

        if (isSoundEnabled) SoundEffect.BACKGROUND.loop();

        pack(); // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);
    }

    private void toggleSound() {
        isSoundEnabled = !isSoundEnabled;
        if (isSoundEnabled) {
            SoundEffect.BACKGROUND.loop();
            btnToggleSound.setText("Mute Sound");
        } else {
            SoundEffect.BACKGROUND.stop();
            btnToggleSound.setText("Unmute Sound");
        }
    }

    public static void main(String[] args) {
        SoundEffect.initSounds();
        new SudokuMain();
    }
}
