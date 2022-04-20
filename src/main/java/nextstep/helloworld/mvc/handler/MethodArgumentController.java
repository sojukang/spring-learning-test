package nextstep.helloworld.mvc.handler;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}