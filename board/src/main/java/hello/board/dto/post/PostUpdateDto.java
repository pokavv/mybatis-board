package hello.board.dto.post;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostUpdateDto {

    private String title;
    private String content;
    private LocalDate date;

    public PostUpdateDto() {}

    public PostUpdateDto(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
