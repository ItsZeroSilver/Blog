package spring.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Boader {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String title;
    @Lob//대용량
    private String content;//<html>태그가 섞여서 디자인 됌
    @ColumnDefault("0")
    private int count;
    //FK
    @ManyToOne //Many = Board, User = One
    @JoinColumn(name = "userId")
    private User user;//DB는 오브젝트를 지정할 수 없지만, 자바는 오브젝트를 지정할 수 있다.
    @CreationTimestamp
    private Timestamp createdDate;
}
