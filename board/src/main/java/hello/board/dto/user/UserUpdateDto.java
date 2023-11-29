package hello.board.dto.user;

import lombok.Data;

@Data
public class UserUpdateDto {

    private String loginId;
    private String pw;
    private String name;
    private String email;

    public UserUpdateDto() {}

    public UserUpdateDto(String loginId, String pw, String name, String email) {
        this.loginId = loginId;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
}
