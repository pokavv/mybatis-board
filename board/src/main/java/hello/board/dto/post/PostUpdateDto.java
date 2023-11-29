package hello.board.dto.post;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostUpdateDto {

    private String title;
    private String content;
    private LocalDate postDate;

    public PostUpdateDto() {}

    public PostUpdateDto(String title, String content, LocalDate postDate) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }
}
