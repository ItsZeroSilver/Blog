package spring.blog.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.blog.model.User;
import spring.blog.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = true)//select 할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정학성)
    public User login(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
