package nextstep.helloworld.mvc.domain;

public class MyUser {
    private Long id;
    private String name;
    private String email;

    private MyUser() {
    }

    public MyUser(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
