package hello.board.repository.post;

import hello.board.domain.post.Post;
import hello.board.dto.post.PostUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    void save(Post post);

    void update(@Param("postId") Long postId,
                @Param("updateParam")PostUpdateDto updateParam);

    Optional<Post> findById(Long postId);

    List<Post> findAll(PostSearchCond cond);

    void delete(Long postId);
}
