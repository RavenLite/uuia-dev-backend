package uuia.info.devbackend.entity;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;


    @Column(name = "school")
    private String school;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "comment")
    private String comment;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }
}
