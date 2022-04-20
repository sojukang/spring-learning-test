package nextstep.helloworld.mvc.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import nextstep.helloworld.mvc.exceptions.exception.HelloException;

@ControllerAdvice
public class HelloAdvice {

    @GetMapping("/exceptions/hi")
    @ExceptionHandler(HelloException.class)
    public ResponseEntity<String> handle() {
        return ResponseEntity.badRequest().body("HelloException");
    }
}
