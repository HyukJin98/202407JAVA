package project1_1;

import java.io.Serializable;

class Member implements Serializable {
    private static final long serialVersionUID = 1L;  // serialVersionUID 추가

    String name;
    String num;
    String tel;
    int balance;

    Member(String name, String num, String tel) {
        this.name = name;
        this.num = num;
        this.tel = tel;
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "Member{name='" + name + "', num='" + num + "', tel='" + tel + "', balance=" + balance + "}";
    }
}