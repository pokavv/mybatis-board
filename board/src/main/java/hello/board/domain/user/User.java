package hello.board.domain.user;

import lombok.Data;

@Data
public class User {

    private Long id; // pk
    private String loginId;
    private String pw;
    private String name;
    private String email;

    // 기본 생성자
    public User() {}

    public User(String loginId, String pw, String name, String email) {
        this.loginId = loginId;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
}
