package hello.board.repository.post;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostSearchCond {

    private Long writerId;
    private String loginId;
    private String title;
    private String content;
    private LocalDate postDate;

    public PostSearchCond() {}

    public PostSearchCond(Long writerId, String loginId, String title, String content, LocalDate postDate) {
        this.writerId = writerId;
        this.loginId = loginId;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }
}
