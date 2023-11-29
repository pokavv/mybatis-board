package hello.board.service.user;

import hello.board.domain.user.User;
import hello.board.dto.user.UserUpdateDto;
import hello.board.repository.user.UserRepository;
import hello.board.repository.user.UserSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(Long id, UserUpdateDto updateParam) {
        userRepository.update(id, updateParam);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll(UserSearchCond cond) {
        return userRepository.findAll(cond);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
