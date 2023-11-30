package hello.board.config.user;

import hello.board.repository.user.UserMapper;
import hello.board.repository.user.UserRepository;
import hello.board.repository.user.UserRepositoryImpl;
import hello.board.service.login.LoginService;
import hello.board.service.login.SessionManager;
import hello.board.service.user.UserService;
import hello.board.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final UserMapper userMapper;

    @Bean
    LoginService loginService() {
        return new LoginService(userRepository());
    }

    @Bean
    SessionManager sessionManager() {
        return new SessionManager();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl(userMapper);
    }
}
