package uuia.info.devbackend.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "relation_user_id")
public class RelationUserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "app_id")
    private int appId;

    @Column(name = "authority")
    private int authority;
}
