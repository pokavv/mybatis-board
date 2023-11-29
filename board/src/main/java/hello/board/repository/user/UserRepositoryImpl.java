package hello.board.repository.user;

import hello.board.domain.user.User;
import hello.board.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    // UserMapper 에 기능 위임
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public void update(Long id, UserUpdateDto updateParam) {
        userMapper.update(id, updateParam);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findAll(UserSearchCond cond) {
        return userMapper.findAll(cond);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
