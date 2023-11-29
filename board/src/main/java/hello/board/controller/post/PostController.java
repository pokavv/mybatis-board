package hello.board.controller.post;

import hello.board.domain.post.Post;
import hello.board.dto.post.PostUpdateDto;
import hello.board.repository.post.PostSearchCond;
import hello.board.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String posts(@ModelAttribute("postSearch")PostSearchCond postSearch,
                        Model model) {
        List<Post> posts = postService.findAll(postSearch);
        model.addAttribute("posts", posts);
        log.info("posts = {}", posts);
        return "posts";
    }

    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).get();
        model.addAttribute("post", post);
        log.info("post = {}", post);
        return "post";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addPostForm";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Post post,
                          RedirectAttributes redirectAttributes) {
        Post savePost = postService.save(post);
        redirectAttributes.addAttribute("id", savePost.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).get();
        return "editPostForm";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       @ModelAttribute PostUpdateDto updateParam) {
        postService.update(id, updateParam);
        return "redirect:/posts/{id}";
    }
}
