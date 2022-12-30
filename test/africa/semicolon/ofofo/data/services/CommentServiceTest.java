package africa.semicolon.ofofo.data.services;

import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {
    private CommentService commentService;
    private PostService postService;

    @BeforeEach
    public void setUp() {
        commentService = new CommentServiceImp();
        postService = new PostServiceImp();
    }

    @Test
    public void createCommentTest() {
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setBody("body");
        postService.createPost(createPostRequest);

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createCommentRequest.setCommenterName("Ebuka");
        createCommentRequest.setComment("I love History");
        commentService.creteComment(createPostRequest);

        assertEquals(1, commentService.viewAll.sizeAll());
    }
}