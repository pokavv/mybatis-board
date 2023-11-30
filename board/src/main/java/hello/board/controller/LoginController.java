package hello.board.controller;

import hello.board.domain.user.User;
import hello.board.service.login.LoginForm;
import hello.board.service.login.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm")LoginForm form) {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }

        User loginUser = loginService.login(form.getLoginId(), form.getPassword());
        log.info("login 시도 {}", loginUser);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "loginForm";
        }

        return "redirect:/";
    }
}
