package nextstep.helloworld.mvc.handler;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nextstep.helloworld.mvc.domain.User;

@RestController
@RequestMapping("/method-argument")
public class MethodArgumentController {

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<User>> requestParam(@RequestParam(name = "name") String userName) {
        List<User> users = Arrays.asList(
            new User(userName, "email"),
            new User(userName, "email")
        );
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users/body")
    @ResponseBody
    public ResponseEntity requestBody(@RequestBody User user) {
        User newUser = new User(1L, user.getName(), user.getEmail());
        return ResponseEntity.created(URI.create("/users/" + newUser.getId())).body(newUser);
    }

    @PostMapping("/users/model-attribute-param")
    public ResponseEntity testModelAttributeWithQueryParams(@ModelAttribute User user) {
        // User newUser = new User(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(user);
    }

    /**
     * 기본생성자의 접근제어자는 상관 없음
     * 기본생성자 & 그외 생성자 2개 이상 -> 무조건 기본 생성자로 생성하고 setter로 binding
     * 기본생성자 & 그외 생성자 1개 -> 그 외 생성자로 생성 + 빈 값 setter로 binding
     * 기본생성자 X & 그 외 생성자 1개 -> 그 외 생성자로 생성 + 빈 값 setter로 binding
     * 기본생성자 X & 그 외 생성자 2개 이상 -> 기본 생성자 오류 Exception
     */
}