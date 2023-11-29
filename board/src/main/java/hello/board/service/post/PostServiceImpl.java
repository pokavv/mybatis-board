package hello.board.service.post;

import hello.board.domain.post.Post;
import hello.board.dto.post.PostUpdateDto;
import hello.board.repository.post.PostRepository;
import hello.board.repository.post.PostSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void update(Long id, PostUpdateDto updateParam) {
        postRepository.update(id, updateParam);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll(PostSearchCond cond) {
        return postRepository.findAll(cond);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }
}
