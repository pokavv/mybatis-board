package hello.board.domain.post;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {

    private Long postId; // pk
    private Long writerId; // fk
    private String loginId; // join
    private String title;
    private String content;
    private LocalDate postDate;

    // 기본 생성자
    public Post() {}

    public Post(Long writerId, String loginId, String title, String content, LocalDate postDate) {
        this.writerId = writerId;
        this.loginId = loginId;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }
}