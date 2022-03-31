package cn.tedu.mybatis.entity;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {

    private Integer id;
    private String name;
    //包含的员工集合
    private List<User> users;

    //get\set\toString

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
