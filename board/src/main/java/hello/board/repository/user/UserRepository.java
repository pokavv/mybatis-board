package hello.board.repository.user;

import hello.board.domain.user.User;
import hello.board.dto.user.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    void update(Long id, UserUpdateDto updateParam);

    Optional<User> findById(Long id);

    List<User> findAll(UserSearchCond cond);

    void delete(Long id);
}