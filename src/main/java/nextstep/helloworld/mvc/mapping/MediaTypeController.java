package nextstep.helloworld.mvc.mapping;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nextstep.helloworld.mvc.domain.User;

@RestController
@RequestMapping("/media-type")
public class MediaTypeController {

    @RequestMapping(
        value = "/users",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User user) {
        Long id = 1L;
        return ResponseEntity.created(URI.create("/users/" + id)).build();
    }

    @RequestMapping(
        value = "/users",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> showUser() {
        List<User> users = Arrays.asList(
            new User("이름", "email"),
            new User("이름", "email")
        );
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(
        value = "/users",
        method = RequestMethod.GET,
        produces = MediaType.TEXT_HTML_VALUE)
    public String userPage() {
        return "user page";
    }
}