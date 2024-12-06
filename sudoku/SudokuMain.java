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
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        cp.add(btnNewGame, BorderLayout.SOUTH);


        // Initialize the game board to start the game
        btnNewGame.addActionListener(e -> board.newGame());

        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("sudoku");
        setVisible(true);
    }

    public static void main(String[] args){
        System.out.println("sudoku");
        SudokuMain game = new SudokuMain();
    }
}