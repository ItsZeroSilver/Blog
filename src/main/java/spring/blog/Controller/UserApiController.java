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

@AllArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> join(@RequestBody User user){
        user.setRole(RoleType.USER);
        int result = userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
    }
}