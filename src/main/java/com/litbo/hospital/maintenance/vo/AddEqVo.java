package com.litbo.hospital.maintenance.vo;

/**
 * @Author: 樊小铭
 * Date: 2019/8/28 4:30
 * @Version:
 * @Description:
 */
public class AddEqVo {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "AddEqVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddEqVo() {
    }

    public AddEqVo(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
