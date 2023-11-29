package hello.board.repository.post;

import lombok.Data;

@Data
public class PostSearchCond {

    private Long writerId;
    private String title;
    private String content;

    public PostSearchCond() {}

    public PostSearchCond(Long writerId ,String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
