package nextstep.helloworld.mvc.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nextstep.helloworld.mvc.domain.User;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping("/message")
    @ResponseBody
    public String string() {
        return "message";
    }

    @GetMapping("/users")
    @ResponseBody
    public User responseBodyForUser() {
        return new User("name", "email");
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @GetMapping("/members")
    @ResponseBody
    public ResponseEntity responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }
}