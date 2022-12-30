package africa.semicolon.ofofo.data.services;

import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.models.Comment;
import africa.semicolon.ofofo.models.Post;

import java.util.List;

public interface PostService {
    void createPost(String title, String body);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);

    List<Post> viewAllPost();

    void createPost(CreatePostRequest createPostRequest);
    void addComment(int postId, Comment comment);
}
