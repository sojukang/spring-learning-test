package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nextstep.helloworld.mvc.domain.User;

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @RequestMapping(
        value = "/users/{id}"
    )
    public ResponseEntity<User> pathVariable(@PathVariable Long id) {
        User user = new User(id, "이름", "email");
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(
        value = "/patterns/?"
    )
    public ResponseEntity<String> pattern() {
        return ResponseEntity.ok().body("pattern");
    }

    @RequestMapping(
        value = "/patterns/**"
    )
    public ResponseEntity<String> patternStars() {
        return ResponseEntity.ok().body("pattern-multi");
    }
}