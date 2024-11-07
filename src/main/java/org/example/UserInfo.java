package org.example;

public class UserInfo {
    private long id;
    private String namn;
    private long saldo;

    public long getId() {
        return id;
    }

    public String getNamn() {
        return namn;
    }

    public long getSaldo() {
        return saldo;
    }

    public UserInfo(long id, String namn, long saldo) {
        this.id = id;
        this.namn = namn;
        this.saldo = saldo;
    }
}
