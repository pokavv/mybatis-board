package hello.board.repository.post;

import hello.board.domain.post.Post;
import hello.board.dto.post.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    // PostMapper 에 기능 위임
    private final PostMapper postMapper;

    @Override
    public Post save(Post post) {
        postMapper.save(post);
        return post;
    }

    @Override
    public void update(Long id, PostUpdateDto updateParam) {
        postMapper.update(id, updateParam);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postMapper.findById(id);
    }

    @Override
    public List<Post> findAll(PostSearchCond cond) {
        return postMapper.findAll(cond);
    }

    @Override
    public void delete(Long id) {
        postMapper.delete(id);
    }

}
