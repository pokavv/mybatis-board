package hello.board.domain.post;

import hello.board.domain.user.User;
import hello.board.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;

@Slf4j
@Data
public class Post {

    private Long postId; // pk
    private Long writerId; // fk
    private String loginId; // join
    private String title;
    private String content;
    private LocalDate postDate;

    // 기본 생성자
    public Post() {}

    public Post(Long writerId, String loginId, String title, String content, LocalDate postDate) {
        this.writerId = writerId;
        this.loginId = loginId;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }

    public String getCookieLoginId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User sessionUserInfo = (User) session.getAttribute(SessionConst.LOGIN_USER);
        log.info("sessionUserInfo={}", sessionUserInfo);

        return sessionUserInfo.getLoginId();
    }

    public Long getCookieWriterId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User sessionUserInfo = (User) session.getAttribute(SessionConst.LOGIN_USER);
        log.info("sessionUserInfo={}", sessionUserInfo);

        return sessionUserInfo.getId();
    }
}