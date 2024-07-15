package project1_1;

import java.io.*;
import java.util.Scanner;

public class Project1_1 {

    public static void main(String[] args) {
        Member member = null;
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        Member[] list = new Member[100]; // 배열 초기화, 최대 10명의 회원을 가정
        int memCnt = 0;

        // 프로그램 시작 시 파일에서 회원 목록 불러오기
        try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Member[] list2 = (Member[]) ois.readObject();
            System.arraycopy(list2, 0, list, 0, list2.length);
            System.out.println("회원정보를 불러 왔습니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("새로운 회원 목록을 생성합니다.");
        }

        // 불러온 회원 정보를 출력하고 회원 수 계산
        for (Member m : list) {
            if (m != null) {
                System.out.println(m);
                ++memCnt;
            }
        }
        System.out.println("총 회원 수: " + memCnt);

        while (run) {
            System.out.println("-------------------------------------");
            System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> ");
            int menuNum = Integer.parseInt(scanner.nextLine());
            switch (menuNum) {
                case 1:
                    // 로그인 처리
                    System.out.println("로그인 처리");
                    System.out.print("아이디: ");
                    String name = scanner.nextLine();
                    System.out.print("패스워드: ");
                    String strPassword = scanner.nextLine();
                    member = null;
                    for (Member m : list) {
                        if (m != null && m.name.equals(name) && m.num.equals(strPassword)) {
                            member = m;
                            break;
                        }
                    }
                    if (member != null) {
                        System.out.println("로그인 성공");
                    } else {
                        System.out.println("로그인 실패: 아이디나 패스워드가 틀립니다.");
                    }
                    break;
                case 2:
                    // 회원 가입
                    System.out.println("회원 가입");
                    System.out.println("[필수 정보 입력]");
                    System.out.print("1. 이름: ");
                    String name2 = scanner.nextLine();
                    System.out.print("2. 주민번호 앞 6자리: ");
                    String ssn = scanner.nextLine();
                    System.out.print("3. 전화번호: ");
                    String tel = scanner.nextLine();
                    System.out.println("[입력된 내용]");
                    System.out.println("1. 이름: " + name2);
                    System.out.println("2. 주민번호 앞 6자리: " + ssn);
                    System.out.println("3. 전화번호: " + tel);

                    member = new Member(name2, ssn, tel);

                    // 회원 목록에 추가
                    boolean added = false;
                    for (int i = 0; i < list.length; i++) {
                        if (list[i] == null) {
                            list[i] = member;
                            added = true;
                            ++memCnt;
                            break;
                        }
                    }
                    if (!added) {
                        System.out.println("회원 목록이 가득 찼습니다.");
                    } else {
                        System.out.println("회원정보가 등록 되었습니다.");
                    }

                    // 파일에 저장
                    try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
                         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    // 예금 출금
                    if (member == null) {
                        System.out.println("먼저 로그인 해주세요.");
                        break;
                    }
                    System.out.println("예금 출금");
                    boolean run2 = true;
                    while (run2) {
                        System.out.println("-------------------------------------");
                        System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
                        System.out.println("-------------------------------------");
                        System.out.print("선택> ");
                        int menuNum2 = Integer.parseInt(scanner.nextLine());
                        switch (menuNum2) {
                            case 1:
                                System.out.print("예금액> ");
                                member.balance += Integer.parseInt(scanner.nextLine());
                                break;
                            case 2:
                                System.out.print("출금액> ");
                                member.balance -= Integer.parseInt(scanner.nextLine());
                                break;
                            case 3:
                                System.out.print("잔고> ");
                                System.out.println(member.balance);
                                break;
                            case 4:
                                run2 = false;
                                break;
                        }
                        System.out.println();
                    }
                    System.out.println("예금/출금 프로그램 종료");
                    break;
                case 4:
                    // 종료 시 파일에 회원 목록 저장
                    try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
                         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(list);
                        System.out.println("저장 후 종료");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 전체 종료");
    }
}