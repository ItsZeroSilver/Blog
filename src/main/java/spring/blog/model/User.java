package spring.blog.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@DynamicInsert//null인 칼럼은 제외하고 insert
//(insert into User (username, password, email, createdDate) values (?, ?, ?, ?);
//role은 제외


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 30, unique = true)
    private String username;
    @Column(nullable = false, length =100)
    private String password;
    @Column(nullable = false, length = 50)
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleType role;
    @CreationTimestamp
    private Timestamp createdDate;
}
