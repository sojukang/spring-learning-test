package nextstep.helloworld.mvc.handler;

import static org.hamcrest.core.Is.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import nextstep.helloworld.mvc.domain.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MethodArgumentTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    /**
     * MethodArgumentController > requestParam 메서드
     * > @RequestParam 활용하여 메서드 파라미터로 활용하기
     * > 생략이 가능하다는 점도 함께 알아보기
     * > @ModelAttribute와 차이를 알아보기
     */
    @DisplayName("Method Arguments - @RequestParam")
    @Test
    void requestParam() {
        String name = "hello";
        RestAssured.given().log().all()
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .when().get("/method-argument/users?name={name}", name)
            .then().log().all()
            .statusCode(HttpStatus.OK.value())
            .body("size()", is(2))
            .body("[0].name", is(name));
    }

    /**
     * MethodArgumentController > requestParam 메서드
     * > @RequestBody 활용하여 메서드 파라미터로 활용하기
     * > 로그 창에서 http request의 body 값을 확인하기
     */
    @DisplayName("Method Arguments - @RequestBody")
    @Test
    void requestBody() {
        User user = new User("이름", "email@email.com");

        RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(user)
            .when().post("/method-argument/users/body")
            .then().log().all()
            .statusCode(HttpStatus.CREATED.value())
            .header("Location", "/users/1")
            .body("name", is("이름"))
            .body("email", is("email@email.com"));
    }

    @DisplayName("model attribute with query params test")
    @Test
    void modelAttributeTestWithQueryParams() {
        RestAssured.given().log().all()
            .when().post("/method-argument/users/model-attribute-param?id=1&name=hello&email=emailil")
            .then().log().all()
            .statusCode(HttpStatus.OK.value())
            .body("id", is(1))
            .body("email", is("emailil"))
            .body("name", is("hello"));
    }
}
