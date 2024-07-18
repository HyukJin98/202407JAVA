package java0718;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class Component extends JFrame{
	JPanel titlePanel,numPanel,btPanel01,btPanel02,resultPanel;
	JTextField num1, num2;
	JButton plus, minus,multiply,divide;
	JLabel title,label01,label02;

	public Component() {
		
		setTitle("계산기 화면");
		setSize(300, 250);
		setLocation(1000,300);

		
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 300,40);
		add(titlePanel);
		title = new JLabel("계산기", JLabel.CENTER);
		title.setFont(new Font("함초롱돋움", Font.BOLD, 20));
		titlePanel.add(title);	

		
			
		numPanel = new JPanel();		
		numPanel.setBounds(0, 40, 300, 40);
		add(numPanel);		
		num1 = new JTextField(5);	
		numPanel.add(num1);
		num2 = new JTextField(5);
		numPanel.add(num2);
	
		
		
		btPanel01 = new JPanel();	
		btPanel01.setBounds(0, 80, 300, 40);
		add(btPanel01);		
		plus = new JButton("+");		
		btPanel01.add(plus);
		minus = new JButton("-");
		btPanel01.add(minus);
		
		
		btPanel02 = new JPanel();	
		btPanel02.setBounds(0, 120, 300, 40);
		add(btPanel02);		
		multiply = new JButton("*");	
		btPanel02.add(multiply);
		divide = new JButton("/");
		btPanel02.add(divide);
				
		
		resultPanel = new JPanel();
		resultPanel.setBounds(0, 160, 300, 40);
		add(resultPanel);
		label01 = new JLabel("계산결과 : ");
		label02 = new JLabel("0.0");
		resultPanel.add(label01);
		resultPanel.add(label02);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		plus.addActionListener(new MyListener());
		minus.addActionListener(new MyListener());
		multiply.addActionListener(new MyListener());
		divide.addActionListener(new MyListener());
		
	}
	
    class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(e.getActionCommand());
			double result = 0.0;
			double no1 = Double.parseDouble(num1.getText());
			double no2 = Double.parseDouble(num2.getText());
			switch(e.getActionCommand()) {
			case "+" : 
				result = no1+no2;
				break;
			case "-" : 
				result = no1-no2;
				break;
			case "*" : 
				result = no1*no2;
				break;
			case "/" : 
				result = no1/no2;
				break;
			}
//			if(e.getSource()==plus) {
//				result = no1+no2;
//				label02.setText(String.valueOf(result));
//			}
//			else if(e.getSource()==minus) {
//				result = no1-no2;
//				label02.setText(String.valueOf(result));
//			}
//			else if(e.getSource()==multiply) {
//				result = no1*no2;
//				label02.setText(String.valueOf(result));
//			}
//			else if(e.getSource()==divide) {
//				result = no1/no2;
				label02.setText(String.valueOf(result));
			}
			
		}
		
	
	
	public static void main(String[] args) {  
		new Component();
	}

}