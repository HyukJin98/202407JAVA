package javagame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;

public class TypingPractice extends JFrame {
    private JTextArea textArea;
    private JTextField inputField;
    private JLabel wpmLabel, accuracyLabel, timerLabel;
    private String sampleText = "한글 타자 연습을 위한 샘플 텍스트입니다.";
    private Instant startTime;
    
    public TypingPractice() {
        setTitle("한컴 타자 연습");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        textArea = new JTextArea(sampleText);
        textArea.setFont(new Font("돋움", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        
        inputField = new JTextField();
        inputField.setFont(new Font("돋움", Font.PLAIN, 18));
        inputField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (startTime == null) {
                    startTime = Instant.now();
                }
                String inputText = inputField.getText();
                if (inputText.equals(sampleText)) {
                    Duration timeElapsed = Duration.between(startTime, Instant.now());
                    calculateResults(inputText, timeElapsed);
                }
            }
        });
        
        wpmLabel = new JLabel("WPM: 0");
        accuracyLabel = new JLabel("Accuracy: 0%");
        timerLabel = new JLabel("Time: 0s");
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(inputField, BorderLayout.SOUTH);
        
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 3));
        resultPanel.add(wpmLabel);
        resultPanel.add(accuracyLabel);
        resultPanel.add(timerLabel);
        
        add(panel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
    }
    
    private void calculateResults(String inputText, Duration timeElapsed) {
        int totalChars = sampleText.length();
        int typedChars = inputText.length();
        int correctChars = 0;
        
        for (int i = 0; i < typedChars; i++) {
            if (inputText.charAt(i) == sampleText.charAt(i)) {
                correctChars++;
            }
        }
        
        double accuracy = (double) correctChars / totalChars * 100;
        double minutes = timeElapsed.toMillis() / 60000.0;
        int wpm = (int) (typedChars / 5 / minutes);
        
        wpmLabel.setText("WPM: " + wpm);
        accuracyLabel.setText("Accuracy: " + String.format("%.2f", accuracy) + "%");
        timerLabel.setText("Time: " + timeElapsed.toSeconds() + "s");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TypingPractice tp = new TypingPractice();
            tp.setVisible(true);
        });
    }
}
