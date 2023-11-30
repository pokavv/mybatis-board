package hello.board.controller;

import hello.board.domain.user.User;
import hello.board.repository.user.UserRepository;
import hello.board.service.login.SessionManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    private final SessionManager sessionManager;

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model) {
        // sessionManager 에 저장된 회원 정보 조회
        User user = (User) sessionManager.getSession(request);
        if (user == null) {
            return "home";
        }

        // login
        model.addAttribute("user", user);
        log.info("contained model = {}", model.getAttribute("user"));
        return "loginHome";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }
}