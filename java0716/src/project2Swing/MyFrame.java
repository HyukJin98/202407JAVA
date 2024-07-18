package project2Swing;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class MyFrame extends JFrame {
	JLabel lb1 = new JLabel("아이디");
	JTextField jt1 = new JTextField();
	JLabel lb2 = new JLabel("SSN");
	JTextField jt2 = new JTextField();
    JLabel lb3 = new JLabel("전화번호");
	JTextField jt3 = new JTextField();
	
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	JTextArea ta = new JTextArea();
	List<Member> list;
	Member member;
	
	public MyFrame() {
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));   // 배열을 ArrayList로
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			System.out.println(member);
		}
		System.out.println("총회원수:"+list.size());
		
		
		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(lb1);
		lb1.setLocation(20,50);
		lb1.setSize(100,30);
		
		con.add(jt1);
		jt1.setLocation(80, 50);
		jt1.setSize(100,30);
		
		con.add(lb2);
		lb2.setLocation(220,50);
		lb2.setSize(100,30);
		
		con.add(jt2);
		jt2.setLocation(280, 50);
		jt2.setSize(100,30);
		
		con.add(lb3);
		lb3.setLocation(420,50);
		lb3.setSize(100,30);
		
		con.add(jt3);
		jt3.setLocation(480, 50);
		jt3.setSize(100,30);
		
		con.add(ta);
		ta.setLocation(20,120);
		ta.setSize(900,200);
		
		jb1.setLocation(20,350);
		jb1.setSize(100,30);
		jb1.addActionListener(new MyListener());
		
		con.add(jb1);
		
		jb2.setLocation(220,350);
		jb2.setSize(100,30);
		
		con.add(jb2);
		jb3.setLocation(420,350);
		jb3.setSize(100,30);
		
		con.add(jb3);
		jb4.setLocation(620,350);
		jb4.setSize(100,30);
		
		con.add(jb4);
		jb5.setLocation(820,350);
		jb5.setSize(100,30);
		
		con.add(jb5);
		this.setTitle("안녕 스윙");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,300);
		this.setSize(1000,500);
		this.setVisible(true);
	}

	class MyListener implements ActionListener {
		
		private Member member;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("클릭");
			// 로그인 처리
			System.out.println("로그인 처리");
			
			System.out.print("아이디:");  //출력문
			String name = jt1.getText();
			System.out.print("패스워드:");
			String strPassword = jt2.getText();
			
			for (Member member2 : list) {
				if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
					member = member2;
					System.out.println("로그인 성공");
					break;
				}
			}
			System.out.println(member);
			


		}
		
		

	}

	
	public static void main(String[] args) {
		new MyFrame();
	}

}