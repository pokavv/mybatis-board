package hello.board.controller.user;

import hello.board.domain.user.User;
import hello.board.dto.user.UserUpdateDto;
import hello.board.repository.user.UserSearchCond;
import hello.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String users(@ModelAttribute("userSearch") UserSearchCond userSearch,
                        Model model) {
        List<User> users = userService.findAll(userSearch);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String user(@PathVariable Long id, Model model) {
        User user = userService.findById(id).get();
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addUserForm";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user,
                          RedirectAttributes redirectAttributes) {
        User saveUser = userService.save(user);
        redirectAttributes.addAttribute("id", saveUser.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/users/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id).get();
        model.addAttribute("user", user);
        return "editUserForm";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       @ModelAttribute UserUpdateDto updateParam) {
        userService.update(id, updateParam);
        return "redirect:/users/{id}";
    }
}
