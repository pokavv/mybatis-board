package hello.board.service.login;

import hello.board.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        // createSession
        MockHttpServletResponse response = new MockHttpServletResponse();
        User user = new User();
        sessionManager.createSession(user, response);

        // store responseCookie
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // getSession
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(user);

        // expireSession
        sessionManager.expire(request);
        Object expiredSession = sessionManager.getSession(request);
        assertThat(expiredSession).isNull();
    }
}