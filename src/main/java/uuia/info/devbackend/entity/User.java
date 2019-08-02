package uuia.info.devbackend.entity;


import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
