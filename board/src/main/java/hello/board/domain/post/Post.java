package hello.board.domain.post;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {

    private Long id; // pk
    private Long writerId; // fk (User.id)
    private String title;
    private String content;
    private LocalDate date;

    // 기본 생성자
    public Post() {}

    public Post(Long writerId, String title, String content, LocalDate date) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.date = date;
    }
}