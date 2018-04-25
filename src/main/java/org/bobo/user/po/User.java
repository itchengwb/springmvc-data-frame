package org.bobo.user.po;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/28  15:11
 * Discribe: user 对象
 */
public class User {
    private int id;//` int(20) NOT NULL,
    private String username;// varchar(30) NOT NULL,
    private String  password;// varchar(30) DEFAULT NULL,

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
