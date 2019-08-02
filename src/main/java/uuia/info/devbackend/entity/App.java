package uuia.info.devbackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "secret_key")
    private String secretKey;

    @Column(name = "wechat_appid")
    private String wechatAppid;

    @Column(name = "wechat_app_secret")
    private String wechatAppSecret;

    @Column(name = "qq_appid")
    private String qqAppid;

    @Column(name = "qq_app_secret")
    private String qqAppSecret;

    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "uuia_app_id")
    private String uuiaAppId;

}