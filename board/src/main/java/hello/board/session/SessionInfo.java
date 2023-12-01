package hello.board.session;

import hello.board.domain.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionInfo {

    public String getCookieLoginId(HttpSession session) {
        User sessionUserInfo = (User) session.getAttribute(SessionConst.LOGIN_USER);
        log.info("sessionUserInfo={}", sessionUserInfo);

        return sessionUserInfo.getLoginId();
    }

}