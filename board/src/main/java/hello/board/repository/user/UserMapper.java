package hello.board.repository.user;

import hello.board.controller.LoginController;
import hello.board.domain.user.User;
import hello.board.dto.user.UserUpdateDto;
import hello.board.session.SessionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    void save(User user);

    void update(@Param("id") Long id,
                @Param("updateParam")UserUpdateDto updateParam);

    Optional<User> findById(Long id);

    List<User> findAll(UserSearchCond cond);

    void delete(Long id);

    Optional<User> findByLoginId(String loginId);
}
