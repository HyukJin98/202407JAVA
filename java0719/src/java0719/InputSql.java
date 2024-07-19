package java0719;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InputSql extends JFrame {
    private JTextField deptQueryField;
  
    private JButton loadDeptButton;
    
    private JTextArea displayArea;

    public InputSql() {
        setTitle("SQL 출력 프로그램");
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new FlowLayout());
        deptQueryField = new JTextField(50);
        
        loadDeptButton = new JButton("출력");

        inputPanel.add(new JLabel("SQL 구문을 입력하십시오 :"));
        inputPanel.add(deptQueryField);
        inputPanel.add(loadDeptButton);
  

        add(inputPanel, BorderLayout.NORTH);

        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        
        loadDeptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDeptData(deptQueryField.getText());
            }
        });
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadDeptData(String query) {
        displayArea.setText("");  
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            
            for (int i = 1; i <= columnCount; i++) {
                displayArea.append(metaData.getColumnName(i) + "\t");
            }
            displayArea.append("\n");

            
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
            displayArea.setText("Error loading data");
        }
    }



    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/spring5fs";
        String user = "spring5";
        String password = "spring5";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InputSql());
    }
}
