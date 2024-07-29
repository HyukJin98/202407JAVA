package java0729;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MinesweeperClient extends JFrame {
    private static final int SIZE = 10;
    private static final char HIDDEN = '-';
    
    private JButton[][] buttons;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public MinesweeperClient(String serverAddress) {
        setTitle("Minesweeper Client");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));
        
        buttons = new JButton[SIZE][SIZE];
        initializeButtons();
        
        try {
            socket = new Socket(serverAddress, 12345);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            updateBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
    private void updateBoard() {
        try {
            String line;
            for (int i = 0; i < SIZE; i++) {
                line = in.readLine();
                String[] cells = line.split(" ");
                for (int j = 0; j < SIZE; j++) {
                    if (cells[j].charAt(0) == HIDDEN) {
                        buttons[i][j].setText("");
                        buttons[i][j].setEnabled(true);
                    } else {
                        buttons[i][j].setText(String.valueOf(cells[j].charAt(0)));
                        buttons[i][j].setEnabled(false);
                    }
                }
            }
            String message = in.readLine();
            if (message != null) {
                JOptionPane.showMessageDialog(this, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            out.println(row + " " + col);
            updateBoard();
        }
    }
    
    public static void main(String[] args) {
        String serverAddress = JOptionPane.showInputDialog("Enter IP Address of the Server:");
        MinesweeperClient client = new MinesweeperClient(serverAddress);
        client.setVisible(true);
    }
}