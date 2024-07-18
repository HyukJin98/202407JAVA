package project2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
    JLabel la1 = new JLabel("아이디");
    JLabel la2 = new JLabel("SSN");
    JLabel la3 = new JLabel("전화번호");

    JTextField tf1 = new JTextField(5);
    JTextField tf2 = new JTextField(5);
    JTextField tf3 = new JTextField(8);

    JTextArea ta = new JTextArea(50, 50);

    JButton jb1 = new JButton("로그인");
    JButton jb2 = new JButton("회원가입");
    JButton jb3 = new JButton("예금");
    JButton jb4 = new JButton("출금");
    JButton jb5 = new JButton("잔고");
    List<Member> list = new ArrayList<>();
    Member loggedInMember;

    MyFrame() {

        JPanel jp1 = new JPanel();
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(jp1, BorderLayout.NORTH);
        jp1.setLayout(new FlowLayout());
        jp1.add(la1);
        jp1.add(tf1);
        jp1.add(la2);
        jp1.add(tf2);
        jp1.add(la3);
        jp1.add(tf3);

        JPanel jp2 = new JPanel();
        con.add(jp2, BorderLayout.CENTER);
        jp2.setLayout(new FlowLayout());
        jp2.add(ta);

        JPanel jp3 = new JPanel();
        con.add(jp3, BorderLayout.SOUTH);
        jp3.setLayout(new FlowLayout());
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        jp3.add(jb4);
        jp3.add(jb5);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1200, 200, 700, 500);


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
    }

    private void login() {
        String id = tf1.getText();
        String ssn = tf2.getText();
        loggedInMember = null;

        for (Member member : list) {
            if (member.getId().equals(id) && member.getSsn().equals(ssn)) {
                loggedInMember = member;
                break;
            }
        }

        if (loggedInMember != null) {
            ta.setText("로그인 성공: " + loggedInMember.getId());
        } else {
            ta.setText("로그인 실패");
        }
    }

    private void signUp() {
        String id = tf1.getText();
        String ssn = tf2.getText();
        String phone = tf3.getText();

        for (Member member : list) {
            if (member.getId().equals(id)) {
                ta.setText("이미 존재하는 아이디입니다.");
                return;
            }
        }

        Member newMember = new Member(id, ssn, phone, 0);
        list.add(newMember);
        ta.setText("회원정보가 등록되었습니다.");
    }

    private void deposit() {
        if (loggedInMember != null) {
            String amountStr = JOptionPane.showInputDialog("예금할 금액을 입력하세요:");
            int amount = Integer.parseInt(amountStr);
            loggedInMember.setBalance(loggedInMember.getBalance() + amount);
            ta.setText("예금 완료. 현재 잔액: " + loggedInMember.getBalance());
        } else {
            ta.setText("로그인이 필요합니다.");
        }
    }

    private void withdraw() {
        if (loggedInMember != null) {
            String amountStr = JOptionPane.showInputDialog("출금할 금액을 입력하세요:");
            int amount = Integer.parseInt(amountStr);
            if (loggedInMember.getBalance() >= amount) {
                loggedInMember.setBalance(loggedInMember.getBalance() - amount);
                ta.setText("출금 완료. 현재 잔액: " + loggedInMember.getBalance());
            } else {
                ta.setText("잔액이 부족합니다.");
            }
        } else {
            ta.setText("로그인이 필요합니다.");
        }
    }

    private void checkBalance() {
        if (loggedInMember != null) {
            ta.setText("현재 잔액: " + loggedInMember.getBalance());
        } else {
            ta.setText("로그인이 필요합니다.");
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}