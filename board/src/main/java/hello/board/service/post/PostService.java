package hello.board.service.post;

import hello.board.domain.post.Post;
import hello.board.dto.post.PostUpdateDto;
import hello.board.repository.post.PostSearchCond;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post save(Post post);

    void update(Long id, PostUpdateDto updateParam);

    Optional<Post> findById(Long id);

    List<Post> findAll(PostSearchCond cond);

    void delete(Long id);
}
