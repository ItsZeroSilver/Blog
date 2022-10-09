package spring.blog.Test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.blog.model.RoleType;
import spring.blog.model.User;
import spring.blog.repository.UserRepository;

import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
@RestController
public class DummyControllerTest {
    private final UserRepository userRepository;
    @PostMapping("/dummy/join")
    public String join(@RequestBody User user){
        System.out.println(user.getCreatedDate());
        System.out.println(user.getUsername());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }

    @GetMapping("/dummy/user/{id}")
    public User selectId(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
        });
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> selectAll(){
        return userRepository.findAll();
    }

    //한 페이지당 2건에 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=2,sort="id",direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();
        return users;
    }

    @Transactional//더티 체킹 //함수 종료시에 자동으로 commit이 됌
    @PutMapping("/dummy/update")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        user.setEmail(requestUser.getEmail());
        user.setPassword(requestUser.getPassword());
        //userRepository.save(user);
        return user;
    }


    @DeleteMapping("/dummy/delete/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }
        return "삭제되었습니다. id: "+id;
    }
    @DeleteMapping("/dummy/delete")
    public void deleteUser(){
        userRepository.deleteAll();
    }
}
