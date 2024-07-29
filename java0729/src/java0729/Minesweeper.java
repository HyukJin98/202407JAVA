package java0729;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Minesweeper extends JFrame {
    private static final int SIZE = 10; // 보드 크기
    private static final int MINES = 10; // 지뢰 개수
    private static final char MINE = '*';
    private static final char EMPTY = ' ';
    
    private JButton[][] buttons;
    private char[][] board;
    private boolean[][] revealed;
    private boolean gameOver;
    
    public Minesweeper() {
        setTitle("Minesweeper");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));
        
        buttons = new JButton[SIZE][SIZE];
        board = new char[SIZE][SIZE];
        revealed = new boolean[SIZE][SIZE];
        gameOver = false;
        
        initializeBoard();
        initializeButtons();
    }
    
    private void initializeBoard() {
        Random rand = new Random();
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
                revealed[i][j] = false;
            }
        }
        
        int minesPlaced = 0;
        while (minesPlaced < MINES) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (board[row][col] != MINE) {
                board[row][col] = MINE;
                minesPlaced++;
            }
        }
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != MINE) {
                    board[i][j] = countAdjacentMines(i, j);
                }
            }
        }
        
        // 디버깅: 보드 상태 출력
        printBoard();
    }
    
    private char countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && board[newRow][newCol] == MINE) {
                    count++;
                }
            }
        }
        return count == 0 ? EMPTY : (char) (count + '0');
    }
    
    private void initializeButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(40, 40));
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[i][j].addActionListener(new ButtonListener(i, j));
                add(buttons[i][j]);
            }
        }
    }
    
    private void reveal(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || revealed[row][col]) {
            return;
        }
        revealed[row][col] = true;
        
        if (board[row][col] == EMPTY) {
            buttons[row][col].setText("");
            buttons[row][col].setEnabled(false);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    reveal(row + i, col + j);
                }
            }
        } else {
            buttons[row][col].setText(String.valueOf(board[row][col]));
            buttons[row][col].setEnabled(false);
        }
    }
    
    private boolean isMine(int row, int col) {
        return board[row][col] == MINE;
    }
    
    private boolean hasWon() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != MINE && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private class ButtonListener implements ActionListener {
        private int row;
        private int col;
        
        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameOver) {
                return;
            }
            
            if (isMine(row, col)) {
                buttons[row][col].setText(String.valueOf(MINE));
                buttons[row][col].setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Game Over! You hit a mine!");
                gameOver = true;
            } else {
                // 새로운 스레드에서 비동기적으로 칸을 공개
                new Thread(() -> {
                    reveal(row, col);
                    if (hasWon()) {
                        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Congratulations! You've won the game!"));
                        gameOver = true;
                    }
                }).start();
            }
        }
    }
    
    // 디버깅: 보드 상태를 출력하는 메서드
    private void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Minesweeper().setVisible(true));
    }
}