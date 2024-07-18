package project2;

import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String ssn;
    private String phone;
    private int balance;

    public Member(String id, String ssn, String phone, int balance) {
        this.id = id;
        this.ssn = ssn;
        this.phone = phone;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPhone() {
        return phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
