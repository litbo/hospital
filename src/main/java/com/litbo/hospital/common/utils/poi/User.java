package com.litbo.hospital.common.utils.poi;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private Integer age;

    private String addr;

    public User() {
    }

    public User(Integer id, String username, Integer age, String addr) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
