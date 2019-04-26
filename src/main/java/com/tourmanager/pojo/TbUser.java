package com.tourmanager.pojo;

public class TbUser {
    private Integer id;

    private String username;

    private String password;

    private String age;

    private String regisgertime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getRegisgertime() {
        return regisgertime;
    }

    public void setRegisgertime(String regisgertime) {
        this.regisgertime = regisgertime == null ? null : regisgertime.trim();
    }
}