package spring.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String title;
    @Lob//대용량
    private String content;//<html>태그가 섞여서 디자인 됌
    @ColumnDefault("0")
    private int count;
    //FK
    @ManyToOne(fetch = FetchType.EAGER) //Many = Board, User = One
    @JoinColumn(name = "userId")
    private User user;//DB는 오브젝트를 지정할 수 없지만, 자바는 오브젝트를 지정할 수 있다.

    //DB 생성할 필요는 없음
    //mappedBy 연관관계 주인이 아니다.(FK가 아님)
    //fetch.lazy는 무조건 들고 오는 것이 아닌, 필요할 때 들고옴.
    @OneToMany(mappedBy="board", fetch = FetchType.LAZY)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createdDate;
}
