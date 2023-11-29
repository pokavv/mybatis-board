package hello.board.repository.post;

import hello.board.domain.post.Post;
import hello.board.dto.post.PostUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    void update(Long id, PostUpdateDto updateParam);

    Optional<Post> findById(Long id);

    List<Post> findAll(PostSearchCond cond);

    void delete(Long id);
}
