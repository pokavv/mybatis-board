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

    @GetMapping("/{postId}")
    public String post(@PathVariable Long postId, Model model) {
        Post post = postService.findById(postId).get();
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
        redirectAttributes.addAttribute("postId", savePost.getPostId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/posts/{postId}";
    }

    @GetMapping("/{postId}/edit")
    public String editForm(@PathVariable Long postId, Model model) {
        Post post = postService.findById(postId).get();
        model.addAttribute("post", post);
        model.addAttribute("postDate", post.getPostDate());
        log.info("post={}", post);
        return "editPostForm";
    }

    @PostMapping("/{postId}/edit")
    public String edit(@PathVariable Long postId,
                       @ModelAttribute PostUpdateDto updateParam) {
        postService.update(postId, updateParam);
        return "redirect:/posts/{postId}";
    }

    @RequestMapping("posts/{postId}/delete")
    public String delete(@PathVariable Long postId) {
        postService.delete(postId);
        return "redirect:/posts";
    }
}
