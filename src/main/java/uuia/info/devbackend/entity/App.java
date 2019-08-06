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

    @Column(name = "validation_key")
    private String validationKey;

    @Column(name = "wechat_appid")
    private String wechatAppId;

    @Column(name = "wechat_app_secret")
    private String wechatSecretKey;

    @Column(name = "qq_appid")
    private String qqAppId;

    @Column(name = "qq_app_secret")
    private String qqSecretKey;

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

    public String getWechatAppId() {
        return wechatAppId;
    }

    public String getWechatSecretKey() {
        return wechatSecretKey;
    }

    public String getQqAppId() {
        return qqAppId;
    }

    public String getQqSecretKey() {
        return qqSecretKey;
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

    public void setUuiaAppId(String uuiaAppId) {
        this.uuiaAppId = uuiaAppId;
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

    public void setWechatAppId(String wechatAppId) {
        this.wechatAppId = wechatAppId;
    }

    public void setWechatSecretKey(String wechatSecretKey) {
        this.wechatSecretKey = wechatSecretKey;
    }

    public void setQqAppId(String qqAppId) {
        this.qqAppId = qqAppId;
    }

    public void setQqSecretKey(String qqSecretKey) {
        this.qqSecretKey = qqSecretKey;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getValidationKey() {
        return validationKey;
    }

    public void setValidationKey(String validationKey) {
        this.validationKey = validationKey;
    }
}
