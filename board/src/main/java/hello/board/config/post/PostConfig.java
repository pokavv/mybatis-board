package hello.board.config.post;

import hello.board.repository.post.PostMapper;
import hello.board.repository.post.PostRepository;
import hello.board.repository.post.PostRepositoryImpl;
import hello.board.service.post.PostService;
import hello.board.service.post.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PostConfig {

    private final PostMapper postMapper;

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository());
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryImpl(postMapper);
    }
}
