package hello.board.repository.user;

import lombok.Data;

@Data
public class UserSearchCond {

    private String loginId;
    private String pw;
    private String name;
    private String email;

    public UserSearchCond() {}

    public UserSearchCond(String loginId, String pw, String name, String email) {
        this.loginId = loginId;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
}
