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

}
