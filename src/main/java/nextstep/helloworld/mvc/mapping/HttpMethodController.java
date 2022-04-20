package nextstep.helloworld.mvc.mapping;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nextstep.helloworld.mvc.domain.User;

@RestController
public class HttpMethodController {

    @PostMapping("/http-method/users")
    public ResponseEntity createUser(@RequestBody User user) {
        Long id = 1L;
        return ResponseEntity.created(URI.create("/users/" + id)).build();
    }

    @GetMapping("/http-method/users")
    public ResponseEntity<List<User>> showUser() {
        List<User> users = Arrays.asList(
            new User("이름", "email"),
            new User("이름", "email")
        );
        return ResponseEntity.ok().body(users);
    }
}