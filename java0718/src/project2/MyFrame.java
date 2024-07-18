package project2;

import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame{
	JLabel la1 = new JLabel("아이디");
	JLabel la2 = new JLabel("SSN");
	JLabel la3 = new JLabel("전화번호");
	
	JTextField tf1 = new JTextField(5);
	JTextField tf2 = new JTextField(5);
	JTextField tf3 = new JTextField(8);
	
	JTextArea ta = new JTextArea(50,50);
	
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	
	MyFrame(){
		JPanel jp1 = new JPanel();
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1,BorderLayout.NORTH);
		jp1.setLayout(new FlowLayout());
		jp1.add(la1);
		jp1.add(tf1);
		jp1.add(la2);
		jp1.add(tf2);
		jp1.add(la3);
		jp1.add(tf3);
		
		
		
		JPanel jp2 = new JPanel();
		con.add(jp2,BorderLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		JPanel jp3 = new JPanel();
		con.add(jp3,BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(1200, 200, 700, 500);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
