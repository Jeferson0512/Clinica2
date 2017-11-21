package com.tecsup.jeferson.clinica.Model;

/**
 * Created by Usuario on 21/11/2017.
 */

public class Usuario {

    private Integer id;
    private String username;
    private String type;
    private String regDate;


    public Usuario() {
    }

    public Usuario(Integer id, String username, String type, String regDate) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.regDate = regDate;
    }

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
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }

}
