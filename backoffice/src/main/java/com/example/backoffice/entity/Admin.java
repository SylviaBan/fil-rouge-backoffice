package com.example.backoffice.entity;

public class Admin {
    private Long id;
    private String login;
    private String password ;

    public Admin(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Admin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
