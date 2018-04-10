package org.cbb.wasteRecovery.bean;

public class BankAccount {
    private int id;
    private String uid;
    private String account;//卡号
    private int bank_code;//银行id
    private String username;//银行用户名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getBank_code() {
        return bank_code;
    }

    public void setBank_code(int bank_code) {
        this.bank_code = bank_code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", account='" + account + '\'' +
                ", bank_code=" + bank_code +
                ", username='" + username + '\'' +
                '}';
    }
}
