package spring.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 200)
    private String content;
    @ManyToOne
    @JoinColumn(name="boaderId")
    private Boader boader;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @CreationTimestamp
    private Timestamp createdDate;

}
