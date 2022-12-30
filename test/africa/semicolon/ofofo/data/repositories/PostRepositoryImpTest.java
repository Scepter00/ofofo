package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImpTest {
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImp();
    }

    @Test
    public void saveNewPost_countShouldBeOne_Test() {
        Post post = new Post();
        post.setBody("Our post Body");
        post.setTitle("Our post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
    }

    @Test
    public void saveNewPost_findByIid_shouldReturnSavedPostTest() {
        Post post = new Post();
        post.setBody("Our post Body");
        post.setTitle("Our post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
        Post post2 = new Post();
        postRepository.save(post2);
        assertEquals(post2, postRepository.findById(2));
    }

    @Test
    public void saveNewPost_updatePost_countIsOneTest() {
        Post post = new Post();
        post.setTitle("Our post title");
        post.setBody("Our post body");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("Update body");
        updatedPost.setTitle("Update title");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("Update body", post.getBody());
        assertEquals("Update title", post.getTitle());
    }

//    @Test
//    public void setPostRepositoryThat
}