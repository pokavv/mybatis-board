package hello.board.service.login;

import hello.board.domain.user.User;
import hello.board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    /**
     * @param loginId
     * @param password
     * @return이 null 일 경우 로그인 실패
     */
    public User login(String loginId, String password) {
        return userRepository.findByLoginId(loginId)
                .filter(user -> user.getPw().equals(password))
                .orElse(null);
    }
}
