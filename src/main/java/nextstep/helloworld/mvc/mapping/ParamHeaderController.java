package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @RequestMapping(value = "/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @RequestMapping(
        value = "/message",
        method = RequestMethod.GET,
        params = "name"
    )
    public ResponseEntity<String> messageForParam(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(name);
    }

    @RequestMapping(
        value = "/message",
        method = RequestMethod.GET,
        headers = {"HEADER=hi"}
    )
    public ResponseEntity<String> messageForHeader() {
        return ResponseEntity.ok().body("hi");
    }
}