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

    @Column(name = "status")
    private int status;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getWechatAppid() {
        return wechatAppid;
    }

    public String getWechatAppSecret() {
        return wechatAppSecret;
    }

    public String getQqAppid() {
        return qqAppid;
    }

    public String getQqAppSecret() {
        return qqAppSecret;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getUuiaAppId() {
        return uuiaAppId;
    }

    public int getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setWechatAppid(String wechatAppid) {
        this.wechatAppid = wechatAppid;
    }

    public void setWechatAppSecret(String wechatAppSecret) {
        this.wechatAppSecret = wechatAppSecret;
    }

    public void setQqAppid(String qqAppid) {
        this.qqAppid = qqAppid;
    }

    public void setQqAppSecret(String qqAppSecret) {
        this.qqAppSecret = qqAppSecret;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setUuiaAppId(String uuiaAppId) {
        this.uuiaAppId = uuiaAppId;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
