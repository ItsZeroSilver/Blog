package spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    //로그인
    //select * from User where username = ?1 and password = ?2
    User findByUsernameAndPassword(String username, String password);

    //혹은
//    @Query(value="SELECT * FROM User WHERE username =?1 AND password =?2", nativeQuery = true)
//    User login(String username, String password);
}
