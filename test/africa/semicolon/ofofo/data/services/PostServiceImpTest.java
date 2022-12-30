package africa.semicolon.ofofo.data.services;




import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.models.Comment;
import africa.semicolon.ofofo.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostServiceImpTest {
    private PostService postService;

    @BeforeEach
    public void setUp() {
        postService = new PostServiceImp();
    }

    @Test
    public void cratePostTest() {
        postService.createPost("New Post", "Egusi is my best soup");
        assertEquals(1, postService.viewAllPost().size());
    }

    @Test
    public void viewPostTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("New post");
        createPostRequest.setTitle("Egusi is my best soup");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPost().size());

        Post post = postService.viewPost(1);
        assertEquals("New post", post.getBody());
        assertEquals("Egusi is my best soup", post.getTitle());
        assertNotNull(post.getCreationTime());
    }

    public void addCommentTest() {
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("Post body");
        createPostRequest.setTitle("Post title");
        postService.createPost(createPostRequest);
        Comment comment = new Comment();
        comment.setComment("I love your post");
        postService.addComment(1, comment);

        Post savedPost = postService.viewPost(1);
        assertEquals(1, savedPost.getComments().size());
        List<Comment> comments = savedPost.getComments();
        assertEquals("I love your post", savedPost.getComments().get(0).getComment());
    }
}
