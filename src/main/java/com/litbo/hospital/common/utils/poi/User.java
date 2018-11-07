package com.litbo.hospital.common.utils.poi;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private Integer age;

    private String addr;

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
