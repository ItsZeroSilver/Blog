package spring.blog.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.blog.Service.UserService;
import spring.blog.dto.ResponseDto;
import spring.blog.model.RoleType;
import spring.blog.model.User;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> join(@RequestBody User user){
        user.setRole(RoleType.USER);
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    /* 전통적인 회원방법
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        User principal = userService.login(user);//principal 접근주체
        if (principal != null){
            session.setAttribute("principal",principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
     */
}
