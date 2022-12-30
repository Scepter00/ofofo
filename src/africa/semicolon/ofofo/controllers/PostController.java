package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.data.services.PostService;
import africa.semicolon.ofofo.data.services.PostServiceImp;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.models.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private PostService postService = new PostServiceImp();

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
        return "Successful";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable int postId) {
        return postService.viewPost(postId);
    }

    @GetMapping("/posts")
    public List<Post> viewAllPost() {
        return postService.viewAllPost();
    }
}
