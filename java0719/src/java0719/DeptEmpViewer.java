package java0719;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeptEmpViewer extends JFrame {
    private JTextField tableQueryField;
    private JButton loadTableButton;
    private JTextArea displayArea;

    public DeptEmpViewer() {
        setTitle("안녕 스윙스");
        setLayout(new BorderLayout());

        // Query input field and button
        JPanel inputPanel = new JPanel(new GridLayout(1, 3));
        tableQueryField = new JTextField();
        loadTableButton = new JButton("테이블 자료 출력");

        inputPanel.add(new JLabel("테이블 이름:"));
        inputPanel.add(tableQueryField);
        inputPanel.add(loadTableButton);

        add(inputPanel, BorderLayout.NORTH);

        // Display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Button action listener
        loadTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = tableQueryField.getText().trim();
                if (!tableName.isEmpty()) {
                    loadTableData(tableName);
                } else {
                    displayArea.setText("테이블을 이름을 쓰세요");
                }
            }
        });

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadTableData(String tableName) {
        displayArea.setText("");  // Clear display area
        String query = "SELECT * FROM " + tableName;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                displayArea.append(metaData.getColumnName(i) + "\t");
            }
            displayArea.append("\n");

            // Print rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    displayArea.append(rs.getString(i) + "\t");
                }
                displayArea.append("\n");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.setText("Error loading data from table: " + tableName);
        }
    }


    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/spring5fs";
        String user = "spring5";
        String password = "spring5";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DeptEmpViewer());
    }
}